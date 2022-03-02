package io.github.fallOut015.glazed_bricks.data.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class LootTableProviderGlazedBricks extends LootTableProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator generator;

    public LootTableProviderGlazedBricks(DataGenerator dataGenerator) {
        super(dataGenerator);
        this.generator = dataGenerator;
    }

    @Override
    public void run(HashCache hashCache) {
        Path path = this.generator.getOutputFolder();
        Map<ResourceLocation, LootTable> map = Maps.newHashMap();

        this.addLootTables(map);

        map.forEach((resourceLocation, lootTable) -> {
            Path path1 = createPath(path, resourceLocation);

            try {
                DataProvider.save(GSON, hashCache, LootTables.serialize(lootTable), path1);
            } catch (IOException ioexception) {
                LOGGER.error("Couldn't save loot table {}", path1, ioexception);
            }
        });
    }

    protected void addLootTables(Map<ResourceLocation, LootTable> map) {
        ForgeRegistries.BLOCKS.getValues().stream().filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(block -> {
            if(block instanceof FlowerPotBlock && !((FlowerPotBlock) block).getContent().equals(Blocks.AIR)) {
                map.put(new ResourceLocation(MainGlazedBricks.MODID, "blocks/" + block.getRegistryName().getPath()), LootTableProviderGlazedBricks.createPotFlowerItemTable(block).setParamSet(LootContextParamSets.BLOCK).build());
            } else if(block instanceof SlabBlock) {
                map.put(new ResourceLocation(MainGlazedBricks.MODID, "blocks/" + block.getRegistryName().getPath()), LootTableProviderGlazedBricks.createSlabItemTable(block).setParamSet(LootContextParamSets.BLOCK).build());
            } else {
                map.put(new ResourceLocation(MainGlazedBricks.MODID, "blocks/" + block.getRegistryName().getPath()), LootTableProviderGlazedBricks.createSingleItemTable(block).setParamSet(LootContextParamSets.BLOCK).build());
            }
        });
    }

    private static Path createPath(Path path, ResourceLocation resourceLocation) {
        return path.resolve("data/" + resourceLocation.getNamespace() + "/loot_tables/" + resourceLocation.getPath() + ".json");
    }

    // From BlockLoot
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(ImmutableSet.toImmutableSet());

    protected static <T> T applyExplosionDecay(ItemLike p_124132_, FunctionUserBuilder<T> p_124133_) {
        return (T)(!EXPLOSION_RESISTANT.contains(p_124132_.asItem()) ? p_124133_.apply(ApplyExplosionDecay.explosionDecay()) : p_124133_.unwrap());
    }

    protected static <T> T applyExplosionCondition(ItemLike itemLike, ConditionUserBuilder<T> conditionUserBuilder) {
        return (T)(!EXPLOSION_RESISTANT.contains(itemLike.asItem()) ? conditionUserBuilder.when(ExplosionCondition.survivesExplosion()) : conditionUserBuilder.unwrap());
    }

    protected static LootTable.Builder createSingleItemTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
    }

    protected static LootTable.Builder createPotFlowerItemTable(Block block) {
        return LootTable.lootTable().withPool(applyExplosionCondition(((FlowerPotBlock) block).getEmptyPot(), LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(((FlowerPotBlock) block).getEmptyPot())))).withPool(applyExplosionCondition(((FlowerPotBlock) block).getContent(), LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(((FlowerPotBlock) block).getContent()))));
    }

    protected static LootTable.Builder createSlabItemTable(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(applyExplosionDecay(block, LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))));
    }
}
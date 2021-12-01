package io.github.fallOut015.glazed_bricks.data.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseLootTableProvider extends LootTableProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    private final DataGenerator generator;

    public BaseLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }

    protected abstract void addTables();

    public static void buildSurvivesExplosion(Block block, final Map<Block, LootTable.Builder> lootTables) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(ItemLootEntry.lootTableItem(block))
                .when(ExplosionCondition.survivesExplosion());

        lootTables.put(block, LootTable.lootTable().withPool(builder));
    }
    public static void buildMultiPoolSurvivesExplosion(Block block, Block[] blocks, final Map<Block, LootTable.Builder> lootTables) {
        LootTable.Builder builder = LootTable.lootTable();
        for(Block blockEntry : blocks) {
            LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(ItemLootEntry.lootTableItem(blockEntry))
                .when(ExplosionCondition.survivesExplosion());
            builder.withPool(pool);
        }
        lootTables.put(block, builder);
    }
    public static void buildPottedPlant(FlowerPotBlock block, final Map<Block, LootTable.Builder> lootTables) {
        buildMultiPoolSurvivesExplosion(block, new Block [] { block.getEmptyPot(), block.getContent() }, lootTables);
    }

    public static void buildSlabType(Block block, final Map<Block, LootTable.Builder> lootTables) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                        ItemLootEntry.lootTableItem(
                                block
                        ).apply(
                                SetCount.setCount(
                                        ConstantValue.exactly(2)
                                ).when(
                                        BlockStateProperty.hasBlockStateProperties(
                                                block
                                        ).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))
                                )
                        ).apply(ExplosionDecay.explosionDecay())
                );

        lootTables.put(block, LootTable.lootTable().withPool(builder));
    }

    @Override
    public void run(HashCache cache) {
        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParamSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(HashCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                IDataProvider.save(GSON, cache, LootTableManager.serialize(lootTable), path);
            } catch (IOException e) {
                //MainGlazedBricks.LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }
}
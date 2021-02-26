package io.github.fallOut015.glazed_bricks.data.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.*;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;

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
        LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(block))
                .acceptCondition(SurvivesExplosion.builder());

        lootTables.put(block, LootTable.builder().addLootPool(builder));
    }
    public static void buildMultiPoolSurvivesExplosion(Block block, Block[] blocks, final Map<Block, LootTable.Builder> lootTables) {
        LootTable.Builder builder = LootTable.builder();
        for(Block blockEntry : blocks) {
            LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(blockEntry))
                .acceptCondition(SurvivesExplosion.builder());
            builder.addLootPool(pool);
        }
        lootTables.put(block, builder);
    }
    public static void buildPottedPlant(FlowerPotBlock block, final Map<Block, LootTable.Builder> lootTables) {
        buildMultiPoolSurvivesExplosion(block, new Block [] { block.getEmptyPot(), block.getFlower() }, lootTables);
    }

    public static void buildSlabType(Block block, final Map<Block, LootTable.Builder> lootTables) {
        LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(
                        ItemLootEntry.builder(
                                block
                        ).acceptFunction(
                                SetCount.builder(
                                        ConstantRange.of(2)
                                ).acceptCondition(
                                        BlockStateProperty.builder(
                                                block
                                        ).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(SlabBlock.TYPE, SlabType.DOUBLE))
                                )
                        ).acceptFunction(ExplosionDecay.builder())
                );

        lootTables.put(block, LootTable.builder().addLootPool(builder));
    }

    @Override
    public void act(DirectoryCache cache) {
        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DirectoryCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(lootTable), path);
            } catch (IOException e) {
                MainGlazedBricks.LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }
}
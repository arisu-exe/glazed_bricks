package io.github.fallOut015.glazed_bricks.data.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
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
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(block))
                .when(SurvivesExplosion.survivesExplosion());

        lootTables.put(block, LootTable.lootTable().withPool(builder));
    }
    public static void buildMultiPoolSurvivesExplosion(Block block, Block[] blocks, final Map<Block, LootTable.Builder> lootTables) {
        LootTable.Builder builder = LootTable.lootTable();
        for(Block blockEntry : blocks) {
            LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(blockEntry))
                .when(SurvivesExplosion.survivesExplosion());
            builder.withPool(pool);
        }
        lootTables.put(block, builder);
    }
    public static void buildPottedPlant(FlowerPotBlock block, final Map<Block, LootTable.Builder> lootTables) {
        buildMultiPoolSurvivesExplosion(block, new Block [] { block.getEmptyPot(), block.getContent() }, lootTables);
    }

    public static void buildSlabType(Block block, final Map<Block, LootTable.Builder> lootTables) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1))
                .add(
                        ItemLootEntry.lootTableItem(
                                block
                        ).apply(
                                SetCount.setCount(
                                        ConstantRange.exactly(2)
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
    public void run(DirectoryCache cache) {
        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParamSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DirectoryCache cache, Map<ResourceLocation, LootTable> tables) {
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
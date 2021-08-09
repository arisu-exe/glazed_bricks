package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.block.BlocksGlazedBricks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.fml.RegistryObject;

public class LootTableProviderGlazedBricks extends BaseLootTableProvider {
    public LootTableProviderGlazedBricks(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        for(RegistryObject<Block> block : BlocksGlazedBricks.getEntries()) {
            if(block.get() instanceof FlowerPotBlock) {
                if(((FlowerPotBlock) block.get()).getContent() == Blocks.AIR) {
                    buildSurvivesExplosion(block.get(), lootTables);
                } else {
                    buildPottedPlant((FlowerPotBlock) block.get(), lootTables);
                }
            }
        }
    }
}
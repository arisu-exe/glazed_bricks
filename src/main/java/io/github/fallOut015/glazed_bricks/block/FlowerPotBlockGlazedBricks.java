package io.github.fallOut015.glazed_bricks.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;

public class FlowerPotBlockGlazedBricks extends FlowerPotBlock {
    public FlowerPotBlockGlazedBricks(@javax.annotation.Nullable java.util.function.Supplier<FlowerPotBlock> emptyPot, java.util.function.Supplier<? extends Block> block, AbstractBlock.Properties properties) {
        super(emptyPot, block, properties);

        if(emptyPot != null) {
            emptyPot.get().addPlant(this.getFlower().getRegistryName(), () -> this);
        }
    }
}
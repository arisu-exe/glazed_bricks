package io.github.fallOut015.glazed_bricks.block;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FlowerPotBlockGlazedBricks extends FlowerPotBlock {
    public FlowerPotBlockGlazedBricks(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> block, Properties properties) {
        super(emptyPot, block, properties);

        if(emptyPot != null) {
            emptyPot.get().addPlant(this.getContent().getRegistryName(), () -> this);
        }
    }
}
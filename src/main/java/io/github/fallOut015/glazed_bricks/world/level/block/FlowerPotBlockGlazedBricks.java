package io.github.fallOut015.glazed_bricks.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public class FlowerPotBlockGlazedBricks extends FlowerPotBlock {
    public FlowerPotBlockGlazedBricks(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> block, Properties properties) {
        super(emptyPot, block, properties);

        if(emptyPot != null) {
            emptyPot.get().addPlant(Objects.requireNonNull(this.getContent().getRegistryName()), () -> this);
        }
    }
}
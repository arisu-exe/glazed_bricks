package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

public class BlockTagsProviderGlazedBricks extends BlockTagsProvider {
    public BlockTagsProviderGlazedBricks(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ForgeRegistries.BLOCKS.getValues().stream().filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(block -> {
            if(block instanceof FlowerPotBlock) {
                this.tag(BlockTags.FLOWER_POTS).add(block);
                if(((FlowerPotBlock) block).getContent().equals(Blocks.WARPED_FUNGUS)) {
                    this.tag(BlockTags.HOGLIN_REPELLENTS).add(block);
                }
            } else if(block instanceof SlabBlock) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                this.tag(BlockTags.SLABS).add(block);
            } else if(block instanceof StairBlock) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                this.tag(BlockTags.STAIRS).add(block);
            } else if(block instanceof WallBlock) {
                this.tag(BlockTags.WALLS).add(block);
            } else if(block.getRegistryName().getPath().endsWith("glazed_bricks")) {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
        });
    }
}
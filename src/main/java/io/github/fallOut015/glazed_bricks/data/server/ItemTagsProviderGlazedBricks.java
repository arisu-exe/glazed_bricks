package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

public class ItemTagsProviderGlazedBricks extends ItemTagsProvider {
    public ItemTagsProviderGlazedBricks(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ForgeRegistries.ITEMS.getValues().stream().filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(item -> {
            if(item.getRegistryName().getPath().endsWith("glazed_brick_slab")) {
                this.tag(ItemTags.SLABS).add(item);
            } else if(item.getRegistryName().getPath().endsWith("glazed_brick_stairs")) {
                this.tag(ItemTags.STAIRS).add(item);
            } else if(item.getRegistryName().getPath().endsWith("glazed_brick_wall")) {
                this.tag(ItemTags.WALLS).add(item);
            } else if(item.getRegistryName().getPath().endsWith("glazed_brick")) {
                this.tag(Tags.Items.INGOTS_BRICK).add(item);
            }
        });
    }
}
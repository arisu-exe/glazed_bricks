package io.github.fallOut015.glazed_bricks.data.server;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.nio.file.Path;

public class TagProviderGlazedBricks extends TagsProvider<Block> {
    public TagProviderGlazedBricks(DataGenerator generatorIn, Registry<Block> registryIn, String modId, ExistingFileHelper existingFileHelper) {
        super(generatorIn, registryIn, modId, existingFileHelper);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    protected void registerTags() {
        // TODO Auto-generated method stub
    }
    @Override
    protected Path makePath(ResourceLocation id) {
        // TODO Auto-generated method stub
        return null;
    }
}
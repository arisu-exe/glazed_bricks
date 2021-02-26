package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.block.BlocksGlazedBricks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.extensions.IForgeTagBuilder;
import net.minecraftforge.fml.RegistryObject;

import java.nio.file.Path;

public class TagProviderGlazedBricks extends TagsProvider<Block> {
    public TagProviderGlazedBricks(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Registry.BLOCK, MainGlazedBricks.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Block Tags: " + this.modId;
    }
    @Override
    protected void registerTags() {
        ITag.Builder builder = new ITag.Builder();
        for(RegistryObject<Block> block : BlocksGlazedBricks.getEntries()) {
            if(block.get() instanceof FlowerPotBlock) {
                builder.addItemEntry(block.get().getRegistryName(), "");
            }
        }
        this.tagToBuilder.put(new ResourceLocation("tags/blocks/flower_pots.json"), builder);
    }
    @Override
    protected Path makePath(ResourceLocation id) {
        return this.generator.getOutputFolder().resolve(id.getPath()); // TODO fix resolve
    }
}
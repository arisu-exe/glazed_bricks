package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

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
    protected void addTags() {
        Tag.Builder builder = new Tag.Builder();
        for(RegistryObject<Block> block : BlocksGlazedBricks.getEntries()) {
            if(block.get() instanceof FlowerPotBlock) {
                builder.addElement(block.get().getRegistryName(), "");
            }
        }
        this.builders.put(new ResourceLocation("tags/blocks/flower_pots.json"), builder);
    }
    @Override
    protected Path getPath(ResourceLocation id) {
        return this.generator.getOutputFolder().resolve(id.getPath()); // TODO fix resolve
    }
}
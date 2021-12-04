package io.github.fallOut015.glazed_bricks.data.client;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BlockStateProviderGlazedBricks extends BlockStateProvider {
    public BlockStateProviderGlazedBricks(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ForgeRegistries.BLOCKS.getValues().stream().filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(block -> {
            String p = Objects.requireNonNull(block.getRegistryName()).getPath();
            if(p.endsWith("glazed_bricks")) {
                this.simpleBlock(block);
            } else if(block instanceof StairBlock) {
                this.stairsBlock((StairBlock) block, new ResourceLocation(MainGlazedBricks.MODID, "block/" + BlockStateProviderGlazedBricks.getColor(p) + "_glazed_bricks"));
            } else if(block instanceof SlabBlock) {
                this.slabBlock((SlabBlock) block, new ResourceLocation(MainGlazedBricks.MODID, BlockStateProviderGlazedBricks.getColor(p) + "_glazed_bricks"), new ResourceLocation(MainGlazedBricks.MODID, "block/" + BlockStateProviderGlazedBricks.getColor(p) + "_glazed_bricks"));
            } else if(block instanceof WallBlock) {
                this.wallBlock((WallBlock) block, new ResourceLocation(MainGlazedBricks.MODID, "block/" + BlockStateProviderGlazedBricks.getColor(p) + "_glazed_bricks"));
            } else if(block instanceof FlowerPotBlock) {
                if(((FlowerPotBlock) block).getContent() == Blocks.AIR) {
                    this.emptyFlowerPotBlock((FlowerPotBlock) block, new ResourceLocation(MainGlazedBricks.MODID, "block/" + p));
                } else {
                    this.flowerPotBlock((FlowerPotBlock) block, new ResourceLocation("minecraft", BlockStateProviderGlazedBricks.getGlazedSuffix(p)), new ResourceLocation(MainGlazedBricks.MODID, "block/" + BlockStateProviderGlazedBricks.getColor(p) + "_glazed_flower_pot"));
                }
            }
        });
    }

    private static String getColor(String p) {
        StringBuilder s = new StringBuilder();
        for(String t : p.split("_")) {
            if(t.equals("glazed")) {
                break;
            }
            s.append(t).append("_");
        }
        return s.substring(0, s.toString().length() - 1);
    }
    private static String getGlazedSuffix(String p) {
        StringBuilder s = new StringBuilder();
        boolean append = false;
        for(String t : p.split("_")) {
            if(t.equals("glazed")) {
                append = true;
                continue;
            }
            if(append) {
                s.append(t).append("_");
            }
        }
        return s.substring(0, s.toString().length() - 1);
    }

    public void emptyFlowerPotBlock(FlowerPotBlock block, ResourceLocation texture) {
        this.flowerPotBlock(block, new ResourceLocation("minecraft", "flower_pot"), texture);
    }
    public void flowerPotBlock(FlowerPotBlock block, ResourceLocation parent, ResourceLocation texture) {
        ModelFile modelFile = this.models().withExistingParent(Objects.requireNonNull(block.getRegistryName()).getPath(), parent).texture("particle", texture).texture("flowerpot", texture);
        ConfiguredModel configuredModel = new ConfiguredModel(modelFile);
        this.getVariantBuilder(block).partialState().setModels(configuredModel);
    }
}
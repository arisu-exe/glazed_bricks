package io.github.fallOut015.glazed_bricks.data.client;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.Map;
import java.util.Objects;

public class BlockModelProviderGlazedBricks extends BlockModelProvider {
    public BlockModelProviderGlazedBricks(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MainGlazedBricks.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Block> block : BlocksGlazedBricks.getEntries()) {
            if(block.get() instanceof FlowerPotBlock) {
                if(((FlowerPotBlock) block.get()).getContent() == Blocks.CACTUS) {
                    registerPottedCactus((FlowerPotBlock) block.get(), generatedModels);
                } else if(((FlowerPotBlock) block.get()).getContent() == Blocks.BAMBOO) {
                    registerPottedBamboo((FlowerPotBlock) block.get(), generatedModels);
                } else if(((FlowerPotBlock) block.get()).getContent() != Blocks.AIR) {
                    registerPottedPlant((FlowerPotBlock) block.get(), generatedModels);
                }
            }
        }

        //register((FlowerPotBlock) BlocksGlazedBricks.WHITE_GLAZED_POTTED_OAK_SAPLING.get(), generatedModels);
        //generatedModels.put(new ResourceLocation("assets/glazed_bricks/models/blocks/block.json"), this.torch("plant", new ResourceLocation("textures/block/oak_sapling.png")));
    }

    private void registerPottedPlant(FlowerPotBlock block, final Map<ResourceLocation, BlockModelBuilder> generatedModels) {
        generatedModels.put(new ResourceLocation(Objects.requireNonNull(block.getRegistryName()).getNamespace() + ":block/" + block.getRegistryName().getPath()), pottedPlant(block));
    }
    private void registerPottedCactus(FlowerPotBlock block, final Map<ResourceLocation, BlockModelBuilder> generatedModels) {
        generatedModels.put(new ResourceLocation(Objects.requireNonNull(block.getRegistryName()).getNamespace() + ":block/" + block.getRegistryName().getPath()), pottedCactus(block));
    }
    private void registerPottedBamboo(FlowerPotBlock block, final Map<ResourceLocation, BlockModelBuilder> generatedModels) {
        generatedModels.put(new ResourceLocation(Objects.requireNonNull(block.getRegistryName()).getNamespace() + ":block/" + block.getRegistryName().getPath()), pottedBamboo(block));
    }

    public BlockModelBuilder pottedPlant(FlowerPotBlock block) {
        return this.singleTexture(Objects.requireNonNull(block.getRegistryName()).getPath(), new ResourceLocation(Objects.requireNonNull(block.getEmptyPot().getRegistryName()).getNamespace() + ":block/" + block.getEmptyPot().getRegistryName().getPath() + "_cross"), "plant", new ResourceLocation(Objects.requireNonNull(block.getContent().getRegistryName()).getNamespace() + ":block/" + block.getContent().getRegistryName().getPath()));
    }
    public BlockModelBuilder pottedCactus(FlowerPotBlock block) {
        return this.withExistingParent(Objects.requireNonNull(block.getRegistryName()).getPath(), "minecraft:block/potted_cactus").texture("particle", new ResourceLocation(Objects.requireNonNull(block.getEmptyPot().getRegistryName()).getNamespace() + ":block/" + block.getEmptyPot().getRegistryName().getPath())).texture("flowerpot", new ResourceLocation(block.getEmptyPot().getRegistryName().getNamespace() + ":block/" + block.getEmptyPot().getRegistryName().getPath()));
    }
    public BlockModelBuilder pottedBamboo(FlowerPotBlock block) {
        return this.withExistingParent(Objects.requireNonNull(block.getRegistryName()).getPath(), "minecraft:block/potted_bamboo").texture("particle", new ResourceLocation(Objects.requireNonNull(block.getEmptyPot().getRegistryName()).getNamespace() + ":block/" + block.getEmptyPot().getRegistryName().getPath())).texture("flowerpot", new ResourceLocation(block.getEmptyPot().getRegistryName().getNamespace() + ":block/" + block.getEmptyPot().getRegistryName().getPath()));
    }
}
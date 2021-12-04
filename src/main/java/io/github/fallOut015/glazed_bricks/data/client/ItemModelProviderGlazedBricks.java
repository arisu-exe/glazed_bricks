package io.github.fallOut015.glazed_bricks.data.client;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ItemModelProviderGlazedBricks extends ItemModelProvider {
    public ItemModelProviderGlazedBricks(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ForgeRegistries.ITEMS.getValues().stream().filter(item -> Objects.requireNonNull(item.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(item -> {
            if(item.getRegistryName().getPath().endsWith("glazed_brick") || item.getRegistryName().getPath().endsWith("glazed_flower_pot")) {
                this.singleTexture(item.getRegistryName().getPath(), new ResourceLocation("minecraft", "item/generated"), "layer0", new ResourceLocation(MainGlazedBricks.MODID, "item/" + item.getRegistryName().getPath()));
            } else {
                if(item instanceof BlockItem blockItem) {
                    if(blockItem.getBlock() instanceof WallBlock) {
                        this.withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(MainGlazedBricks.MODID, "block/" + item.getRegistryName().getPath() + "_inventory"));
                    } else {
                        this.withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(MainGlazedBricks.MODID, "block/" + item.getRegistryName().getPath()));
                    }
                }
            }
        });
    }
}
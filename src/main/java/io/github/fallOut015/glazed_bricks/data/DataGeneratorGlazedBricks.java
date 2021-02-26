package io.github.fallOut015.glazed_bricks.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.block.BlocksGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.server.LootTableProviderGlazedBricks;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class DataGeneratorGlazedBricks {
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Gen {
        @SubscribeEvent
        public static void gatherData(final GatherDataEvent event) {
            @SuppressWarnings("unused")
            DataGenerator gen = event.getGenerator();

            if(event.includeClient()) {
                final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                Path outputFolder = gen.getOutputFolder();

                Block block = BlocksGlazedBricks.WHITE_GLAZED_FLOWER_POT.get();
                ResourceLocation key = block.getRegistryName();
                Path path = outputFolder.resolve("assets/" + key.getNamespace() + "/blockstates/" + key.getPath() + ".json");

                JsonObject blockState = new JsonObject();
                JsonObject variants = new JsonObject();
                JsonObject variant = new JsonObject();
                variant.addProperty("model", key.getNamespace() + ":block/" + key.getPath());
                variants.add("", variant);
                blockState.add("variants", variants);

                //File f = new File(path.toString() + "");

                try {
                    DirectoryCache cache = new DirectoryCache(outputFolder, "cache");
                    IDataProvider.save(GSON, cache, blockState, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for(RegistryObject<Block> block2 : BlocksGlazedBricks.getEntries()) {
                    if(block2.get() instanceof FlowerPotBlock) {

                    }
                }
            }

            if(event.includeServer()) {
				gen.addProvider(new LootTableProviderGlazedBricks(gen));
                //gen.addProvider(new TagProviderGlazedBricks(gen, Registry.BLOCK, MainGlazedBricks.MODID, event.getExistingFileHelper()));
            }
        }
    }
}
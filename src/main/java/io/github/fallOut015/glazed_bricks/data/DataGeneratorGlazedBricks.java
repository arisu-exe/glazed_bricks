package io.github.fallOut015.glazed_bricks.data;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.client.BlockModelProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.client.BlockStateProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.client.ItemModelProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.client.LanguageProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.server.BlockTagsProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.server.ItemTagsProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.server.LootTableProviderGlazedBricks;
import io.github.fallOut015.glazed_bricks.data.server.RecipeProviderGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorGlazedBricks {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        @SuppressWarnings("unused")
        DataGenerator gen = event.getGenerator();

        if(event.includeClient()) {
            gen.addProvider(new BlockStateProviderGlazedBricks(gen, MainGlazedBricks.MODID, event.getExistingFileHelper()));
            gen.addProvider(new LanguageProviderGlazedBricks(gen, MainGlazedBricks.MODID, "en_au"));
            gen.addProvider(new LanguageProviderGlazedBricks(gen, MainGlazedBricks.MODID, "en_ca"));
            gen.addProvider(new LanguageProviderGlazedBricks(gen, MainGlazedBricks.MODID, "en_gb"));
            gen.addProvider(new LanguageProviderGlazedBricks(gen, MainGlazedBricks.MODID, "en_nz"));
            gen.addProvider(new LanguageProviderGlazedBricks(gen, MainGlazedBricks.MODID, "en_us"));
            gen.addProvider(new BlockModelProviderGlazedBricks(gen, MainGlazedBricks.MODID, event.getExistingFileHelper()));
            gen.addProvider(new ItemModelProviderGlazedBricks(gen, MainGlazedBricks.MODID, event.getExistingFileHelper()));
        }

        if(event.includeServer()) {
            gen.addProvider(new LootTableProviderGlazedBricks(gen));
            gen.addProvider(new RecipeProviderGlazedBricks(gen));
            BlockTagsProvider blockTagsProvider = new BlockTagsProviderGlazedBricks(gen, MainGlazedBricks.MODID, event.getExistingFileHelper());
            gen.addProvider(blockTagsProvider);
            gen.addProvider(new ItemTagsProviderGlazedBricks(gen, blockTagsProvider, MainGlazedBricks.MODID, event.getExistingFileHelper()));
        }
    }
}
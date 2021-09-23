package io.github.fallOut015.glazed_bricks.data;

import net.minecraft.data.DataGenerator;
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
            //gen.addProvider(new BlockStateProviderGlazedBricks(gen));
            //gen.addProvider(new BlockModelProviderGlazedBricks(gen, event.getExistingFileHelper()));
        }

        if(event.includeServer()) {
            //gen.addProvider(new LootTableProviderGlazedBricks(gen));
            //gen.addProvider(new TagProviderGlazedBricks(gen, event.getExistingFileHelper()));
        }
    }
}
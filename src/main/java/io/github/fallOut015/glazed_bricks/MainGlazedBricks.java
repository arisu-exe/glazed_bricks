package io.github.fallOut015.glazed_bricks;

import io.github.fallOut015.glazed_bricks.block.BlocksGlazedBricks;
import io.github.fallOut015.glazed_bricks.client.RenderTypeLookupGlazedBricks;
import io.github.fallOut015.glazed_bricks.item.ItemsGlazedBricks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MainGlazedBricks.MODID)
public class MainGlazedBricks {
    public static final String MODID = "glazed_bricks";

    public MainGlazedBricks() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        BlocksGlazedBricks.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemsGlazedBricks.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookupGlazedBricks.doClientStuff(event);
    }
}
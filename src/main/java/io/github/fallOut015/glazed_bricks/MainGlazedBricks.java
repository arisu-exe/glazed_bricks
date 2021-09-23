package io.github.fallOut015.glazed_bricks;

import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import io.github.fallOut015.glazed_bricks.client.renderer.ItemBlockRenderTypesGlazedBricks;
import io.github.fallOut015.glazed_bricks.world.item.ItemsGlazedBricks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        ItemBlockRenderTypesGlazedBricks.doClientStuff(event);
    }
}
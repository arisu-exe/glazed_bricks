package io.github.fallOut015.glazed_bricks.world.item;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import io.github.fallOut015.glazed_bricks.world.level.block.BlocksGlazedBricks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsGlazedBricks {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainGlazedBricks.MODID);



    public static final RegistryObject<Item> WHITE_GLAZED_BRICKS = ITEMS.register("white_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.WHITE_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> ORANGE_GLAZED_BRICKS = ITEMS.register("orange_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.ORANGE_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_BRICKS = ITEMS.register("magenta_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.MAGENTA_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_BRICKS = ITEMS.register("light_blue_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.LIGHT_BLUE_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> YELLOW_GLAZED_BRICKS = ITEMS.register("yellow_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.YELLOW_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIME_GLAZED_BRICKS = ITEMS.register("lime_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.LIME_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PINK_GLAZED_BRICKS = ITEMS.register("pink_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.PINK_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GRAY_GLAZED_BRICKS = ITEMS.register("gray_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.GRAY_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_BRICKS = ITEMS.register("light_gray_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.LIGHT_GRAY_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> CYAN_GLAZED_BRICKS = ITEMS.register("cyan_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.CYAN_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PURPLE_GLAZED_BRICKS = ITEMS.register("purple_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.PURPLE_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLUE_GLAZED_BRICKS = ITEMS.register("blue_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.BLUE_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BROWN_GLAZED_BRICKS = ITEMS.register("brown_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.BROWN_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GREEN_GLAZED_BRICKS = ITEMS.register("green_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.GREEN_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> RED_GLAZED_BRICKS = ITEMS.register("red_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.RED_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLACK_GLAZED_BRICKS = ITEMS.register("black_glazed_bricks", () -> new BlockItem(BlocksGlazedBricks.BLACK_GLAZED_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> WHITE_GLAZED_BRICK_SLAB = ITEMS.register("white_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.WHITE_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> ORANGE_GLAZED_BRICK_SLAB = ITEMS.register("orange_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.ORANGE_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_BRICK_SLAB = ITEMS.register("magenta_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.MAGENTA_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_BRICK_SLAB = ITEMS.register("light_blue_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.LIGHT_BLUE_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> YELLOW_GLAZED_BRICK_SLAB = ITEMS.register("yellow_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.YELLOW_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIME_GLAZED_BRICK_SLAB = ITEMS.register("lime_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.LIME_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PINK_GLAZED_BRICK_SLAB = ITEMS.register("pink_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.PINK_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GRAY_GLAZED_BRICK_SLAB = ITEMS.register("gray_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.GRAY_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_BRICK_SLAB = ITEMS.register("light_gray_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.LIGHT_GRAY_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> CYAN_GLAZED_BRICK_SLAB = ITEMS.register("cyan_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.CYAN_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PURPLE_GLAZED_BRICK_SLAB = ITEMS.register("purple_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.PURPLE_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLUE_GLAZED_BRICK_SLAB = ITEMS.register("blue_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.BLUE_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BROWN_GLAZED_BRICK_SLAB = ITEMS.register("brown_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.BROWN_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GREEN_GLAZED_BRICK_SLAB = ITEMS.register("green_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.GREEN_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> RED_GLAZED_BRICK_SLAB = ITEMS.register("red_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.RED_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLACK_GLAZED_BRICK_SLAB = ITEMS.register("black_glazed_brick_slab", () -> new BlockItem(BlocksGlazedBricks.BLACK_GLAZED_BRICK_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> WHITE_GLAZED_BRICK_STAIRS = ITEMS.register("white_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.WHITE_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> ORANGE_GLAZED_BRICK_STAIRS = ITEMS.register("orange_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.ORANGE_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_BRICK_STAIRS = ITEMS.register("magenta_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.MAGENTA_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_BRICK_STAIRS = ITEMS.register("light_blue_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.LIGHT_BLUE_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> YELLOW_GLAZED_BRICK_STAIRS = ITEMS.register("yellow_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.YELLOW_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIME_GLAZED_BRICK_STAIRS = ITEMS.register("lime_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.LIME_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PINK_GLAZED_BRICK_STAIRS = ITEMS.register("pink_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.PINK_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GRAY_GLAZED_BRICK_STAIRS = ITEMS.register("gray_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.GRAY_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_BRICK_STAIRS = ITEMS.register("light_gray_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.LIGHT_GRAY_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> CYAN_GLAZED_BRICK_STAIRS = ITEMS.register("cyan_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.CYAN_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> PURPLE_GLAZED_BRICK_STAIRS = ITEMS.register("purple_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.PURPLE_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLUE_GLAZED_BRICK_STAIRS = ITEMS.register("blue_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.BLUE_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BROWN_GLAZED_BRICK_STAIRS = ITEMS.register("brown_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.BROWN_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> GREEN_GLAZED_BRICK_STAIRS = ITEMS.register("green_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.GREEN_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> RED_GLAZED_BRICK_STAIRS = ITEMS.register("red_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.RED_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BLACK_GLAZED_BRICK_STAIRS = ITEMS.register("black_glazed_brick_stairs", () -> new BlockItem(BlocksGlazedBricks.BLACK_GLAZED_BRICK_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> WHITE_GLAZED_BRICK_WALL = ITEMS.register("white_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.WHITE_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> ORANGE_GLAZED_BRICK_WALL = ITEMS.register("orange_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.ORANGE_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_BRICK_WALL = ITEMS.register("magenta_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.MAGENTA_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_BRICK_WALL = ITEMS.register("light_blue_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.LIGHT_BLUE_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> YELLOW_GLAZED_BRICK_WALL = ITEMS.register("yellow_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.YELLOW_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIME_GLAZED_BRICK_WALL = ITEMS.register("lime_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.LIME_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PINK_GLAZED_BRICK_WALL = ITEMS.register("pink_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.PINK_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> GRAY_GLAZED_BRICK_WALL = ITEMS.register("gray_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.GRAY_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_BRICK_WALL = ITEMS.register("light_gray_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.LIGHT_GRAY_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CYAN_GLAZED_BRICK_WALL = ITEMS.register("cyan_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.CYAN_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PURPLE_GLAZED_BRICK_WALL = ITEMS.register("purple_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.PURPLE_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BLUE_GLAZED_BRICK_WALL = ITEMS.register("blue_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.BLUE_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BROWN_GLAZED_BRICK_WALL = ITEMS.register("brown_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.BROWN_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> GREEN_GLAZED_BRICK_WALL = ITEMS.register("green_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.GREEN_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> RED_GLAZED_BRICK_WALL = ITEMS.register("red_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.RED_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BLACK_GLAZED_BRICK_WALL = ITEMS.register("black_glazed_brick_wall", () -> new BlockItem(BlocksGlazedBricks.BLACK_GLAZED_BRICK_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> WHITE_GLAZED_FLOWER_POT = ITEMS.register("white_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.WHITE_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> ORANGE_GLAZED_FLOWER_POT = ITEMS.register("orange_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.ORANGE_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_FLOWER_POT = ITEMS.register("magenta_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.MAGENTA_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_FLOWER_POT = ITEMS.register("light_blue_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.LIGHT_BLUE_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> YELLOW_GLAZED_FLOWER_POT = ITEMS.register("yellow_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.YELLOW_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIME_GLAZED_FLOWER_POT = ITEMS.register("lime_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.LIME_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PINK_GLAZED_FLOWER_POT = ITEMS.register("pink_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.PINK_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> GRAY_GLAZED_FLOWER_POT = ITEMS.register("gray_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.GRAY_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_FLOWER_POT = ITEMS.register("light_gray_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.LIGHT_GRAY_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CYAN_GLAZED_FLOWER_POT = ITEMS.register("cyan_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.CYAN_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PURPLE_GLAZED_FLOWER_POT = ITEMS.register("purple_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.PURPLE_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BLUE_GLAZED_FLOWER_POT = ITEMS.register("blue_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.BLUE_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BROWN_GLAZED_FLOWER_POT = ITEMS.register("brown_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.BROWN_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> GREEN_GLAZED_FLOWER_POT = ITEMS.register("green_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.GREEN_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> RED_GLAZED_FLOWER_POT = ITEMS.register("red_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.RED_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BLACK_GLAZED_FLOWER_POT = ITEMS.register("black_glazed_flower_pot", () -> new BlockItem(BlocksGlazedBricks.BLACK_GLAZED_FLOWER_POT.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> WHITE_GLAZED_BRICK = ITEMS.register("white_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ORANGE_GLAZED_BRICK = ITEMS.register("orange_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> MAGENTA_GLAZED_BRICK = ITEMS.register("magenta_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIGHT_BLUE_GLAZED_BRICK = ITEMS.register("light_blue_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> YELLOW_GLAZED_BRICK = ITEMS.register("yellow_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIME_GLAZED_BRICK = ITEMS.register("lime_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PINK_GLAZED_BRICK = ITEMS.register("pink_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GRAY_GLAZED_BRICK = ITEMS.register("gray_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIGHT_GRAY_GLAZED_BRICK = ITEMS.register("light_gray_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CYAN_GLAZED_BRICK = ITEMS.register("cyan_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PURPLE_GLAZED_BRICK = ITEMS.register("purple_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BLUE_GLAZED_BRICK = ITEMS.register("blue_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BROWN_GLAZED_BRICK = ITEMS.register("brown_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GREEN_GLAZED_BRICK = ITEMS.register("green_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RED_GLAZED_BRICK = ITEMS.register("red_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BLACK_GLAZED_BRICK = ITEMS.register("black_glazed_brick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
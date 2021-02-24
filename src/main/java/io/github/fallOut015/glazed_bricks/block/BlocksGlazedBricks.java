package io.github.fallOut015.glazed_bricks.block;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksGlazedBricks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainGlazedBricks.MODID);



    public static final RegistryObject<Block> WHITE_GLAZED_BRICKS = BLOCKS.register("white_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.WHITE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> ORANGE_GLAZED_BRICKS = BLOCKS.register("orange_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.ORANGE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> MAGENTA_GLAZED_BRICKS = BLOCKS.register("magenta_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.MAGENTA).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE_GLAZED_BRICKS = BLOCKS.register("light_blue_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> YELLOW_GLAZED_BRICKS = BLOCKS.register("yellow_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.YELLOW).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIME_GLAZED_BRICKS = BLOCKS.register("lime_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.LIME).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> PINK_GLAZED_BRICKS = BLOCKS.register("pink_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.PINK).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> GRAY_GLAZED_BRICKS = BLOCKS.register("gray_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.GRAY).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_GRAY_GLAZED_BRICKS = BLOCKS.register("light_gray_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.LIGHT_GRAY).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> CYAN_GLAZED_BRICKS = BLOCKS.register("cyan_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.CYAN).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> PURPLE_GLAZED_BRICKS = BLOCKS.register("purple_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.PURPLE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> BLUE_GLAZED_BRICKS = BLOCKS.register("blue_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.BLUE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> BROWN_GLAZED_BRICKS = BLOCKS.register("brown_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.BROWN).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> GREEN_GLAZED_BRICKS = BLOCKS.register("green_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.GREEN).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> RED_GLAZED_BRICKS = BLOCKS.register("red_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.RED).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> BLACK_GLAZED_BRICKS = BLOCKS.register("black_glazed_bricks", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.BLACK).hardnessAndResistance(2.0F, 6.0F)));

    public static final RegistryObject<Block> WHITE_GLAZED_BRICK_SLAB = BLOCKS.register("white_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(WHITE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_GLAZED_BRICK_SLAB = BLOCKS.register("orange_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(ORANGE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_GLAZED_BRICK_SLAB = BLOCKS.register("magenta_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(MAGENTA_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_GLAZED_BRICK_SLAB = BLOCKS.register("light_blue_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_GLAZED_BRICK_SLAB = BLOCKS.register("yellow_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(YELLOW_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIME_GLAZED_BRICK_SLAB = BLOCKS.register("lime_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(LIME_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PINK_GLAZED_BRICK_SLAB = BLOCKS.register("pink_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(PINK_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_GLAZED_BRICK_SLAB = BLOCKS.register("gray_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_GLAZED_BRICK_SLAB = BLOCKS.register("light_gray_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_GLAZED_BRICK_SLAB = BLOCKS.register("cyan_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(CYAN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_GLAZED_BRICK_SLAB = BLOCKS.register("purple_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(PURPLE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_GLAZED_BRICK_SLAB = BLOCKS.register("blue_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_GLAZED_BRICK_SLAB = BLOCKS.register("brown_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(BROWN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_GLAZED_BRICK_SLAB = BLOCKS.register("green_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(GREEN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> RED_GLAZED_BRICK_SLAB = BLOCKS.register("red_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(RED_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_GLAZED_BRICK_SLAB = BLOCKS.register("black_glazed_brick_slab", () -> new SlabBlock(Block.Properties.from(BLACK_GLAZED_BRICKS.get())));

    public static final RegistryObject<Block> WHITE_GLAZED_BRICK_STAIRS = BLOCKS.register("white_glazed_brick_stairs", () -> new StairsBlock(WHITE_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(WHITE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_GLAZED_BRICK_STAIRS = BLOCKS.register("orange_glazed_brick_stairs", () -> new StairsBlock(ORANGE_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(ORANGE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_GLAZED_BRICK_STAIRS = BLOCKS.register("magenta_glazed_brick_stairs", () -> new StairsBlock(MAGENTA_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(MAGENTA_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_GLAZED_BRICK_STAIRS = BLOCKS.register("light_blue_glazed_brick_stairs", () -> new StairsBlock(LIGHT_BLUE_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_GLAZED_BRICK_STAIRS = BLOCKS.register("yellow_glazed_brick_stairs", () -> new StairsBlock(YELLOW_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(YELLOW_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIME_GLAZED_BRICK_STAIRS = BLOCKS.register("lime_glazed_brick_stairs", () -> new StairsBlock(LIME_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(LIME_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PINK_GLAZED_BRICK_STAIRS = BLOCKS.register("pink_glazed_brick_stairs", () -> new StairsBlock(PINK_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(PINK_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_GLAZED_BRICK_STAIRS = BLOCKS.register("gray_glazed_brick_stairs", () -> new StairsBlock(GRAY_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_GLAZED_BRICK_STAIRS = BLOCKS.register("light_gray_glazed_brick_stairs", () -> new StairsBlock(LIGHT_GRAY_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_GLAZED_BRICK_STAIRS = BLOCKS.register("cyan_glazed_brick_stairs", () -> new StairsBlock(CYAN_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(CYAN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_GLAZED_BRICK_STAIRS = BLOCKS.register("purple_glazed_brick_stairs", () -> new StairsBlock(PURPLE_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(PURPLE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_GLAZED_BRICK_STAIRS = BLOCKS.register("blue_glazed_brick_stairs", () -> new StairsBlock(BLUE_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_GLAZED_BRICK_STAIRS = BLOCKS.register("brown_glazed_brick_stairs", () -> new StairsBlock(BROWN_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(BROWN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_GLAZED_BRICK_STAIRS = BLOCKS.register("green_glazed_brick_stairs", () -> new StairsBlock(GREEN_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(GREEN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> RED_GLAZED_BRICK_STAIRS = BLOCKS.register("red_glazed_brick_stairs", () -> new StairsBlock(RED_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(RED_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_GLAZED_BRICK_STAIRS = BLOCKS.register("black_glazed_brick_stairs", () -> new StairsBlock(BLACK_GLAZED_BRICKS.get()::getDefaultState, Block.Properties.from(BLACK_GLAZED_BRICKS.get())));

    public static final RegistryObject<Block> WHITE_GLAZED_BRICK_WALL = BLOCKS.register("white_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(WHITE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_GLAZED_BRICK_WALL = BLOCKS.register("orange_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(ORANGE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_GLAZED_BRICK_WALL = BLOCKS.register("magenta_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(MAGENTA_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_GLAZED_BRICK_WALL = BLOCKS.register("light_blue_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(LIGHT_BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_GLAZED_BRICK_WALL = BLOCKS.register("yellow_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(YELLOW_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIME_GLAZED_BRICK_WALL = BLOCKS.register("lime_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(LIME_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PINK_GLAZED_BRICK_WALL = BLOCKS.register("pink_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(PINK_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_GLAZED_BRICK_WALL = BLOCKS.register("gray_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_GLAZED_BRICK_WALL = BLOCKS.register("light_gray_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(LIGHT_GRAY_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_GLAZED_BRICK_WALL = BLOCKS.register("cyan_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(CYAN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_GLAZED_BRICK_WALL = BLOCKS.register("purple_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(PURPLE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_GLAZED_BRICK_WALL = BLOCKS.register("blue_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(BLUE_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_GLAZED_BRICK_WALL = BLOCKS.register("brown_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(BROWN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_GLAZED_BRICK_WALL = BLOCKS.register("green_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(GREEN_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> RED_GLAZED_BRICK_WALL = BLOCKS.register("red_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(RED_GLAZED_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_GLAZED_BRICK_WALL = BLOCKS.register("black_glazed_brick_wall", () -> new WallBlock(Block.Properties.from(BLACK_GLAZED_BRICKS.get())));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}

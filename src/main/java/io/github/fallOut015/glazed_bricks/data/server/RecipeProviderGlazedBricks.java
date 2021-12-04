package io.github.fallOut015.glazed_bricks.data.server;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class RecipeProviderGlazedBricks extends RecipeProvider {
    public RecipeProviderGlazedBricks(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for(DyeColor dyeColor : DyeColor.values()) {
            ItemLike dyeItem = DyeItem.byColor(dyeColor);
            ItemLike brickItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_brick"));
            ItemLike bricksBlock = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_bricks"));

            stainedBrickFromBrickAndDye(consumer, brickItem, dyeItem);

            ItemLike slab = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_brick_slab"));

            stainedSlabFromBricksBlock(consumer, slab, bricksBlock);
            stonecutterResultFromBase(consumer, slab, bricksBlock, 2);
            stainedSlabFromSlabAndDye(consumer, slab, dyeItem);

            ItemLike stairs = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_brick_stairs"));

            stainedStairsFromBricksBlock(consumer, stairs, bricksBlock);
            stonecutterResultFromBase(consumer, stairs, bricksBlock);
            stainedStairsFromStairsAndDye(consumer, stairs, dyeItem);
            stainedBricksBlockFromBricksBlockAndDye(consumer, bricksBlock, dyeItem);

            ItemLike wall = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_brick_wall"));

            stainedWallFromBricksBlock(consumer, wall, bricksBlock);
            stonecutterResultFromBase(consumer, wall, bricksBlock);
            stainedWallFromWallAndDye(consumer, wall, dyeItem);
            stainedBricksBlockFromBrick(consumer, bricksBlock, brickItem);

            ItemLike flowerPot = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MainGlazedBricks.MODID, dyeColor + "_glazed_flower_pot"));

            stainedFlowerPotFromBrick(consumer, flowerPot, brickItem);
            stainedFlowerPotFromFlowerPotAndDye(consumer, flowerPot, dyeItem);
        }
    }

    private static void stainedBrickFromBrickAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.BRICK).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_brick").unlockedBy("has_brick", has(Items.BRICK)).save(consumer);
    }
    private static void stainedSlabFromBricksBlock(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike brick) {
        ShapedRecipeBuilder.shaped(result, 6).define('#', brick).pattern("###").unlockedBy("has_brick", has(brick)).group("stained_brick_slab").save(consumer);
    }
    private static void stainedSlabFromSlabAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.BRICK_SLAB).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_brick_slab").unlockedBy("has_brick_slab", has(Items.BRICK_SLAB)).save(consumer, getDefaultRecipeId(result) + "_from_dye");
    }
    private static void stainedStairsFromBricksBlock(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike brick) {
        ShapedRecipeBuilder.shaped(result, 4).define('#', brick).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_brick", has(brick)).group("stained_brick_stairs").save(consumer);
    }
    private static void stainedStairsFromStairsAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.BRICK_STAIRS).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_brick_stairs").unlockedBy("has_brick_stairs", has(Items.BRICK_STAIRS)).save(consumer, getDefaultRecipeId(result) + "_from_dye");
    }
    private static void stainedWallFromBricksBlock(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike brick) {
        ShapedRecipeBuilder.shaped(result, 6).define('#', brick).pattern("###").pattern("###").unlockedBy("has_brick", has(brick)).group("stained_brick_wall").save(consumer);
    }
    private static void stainedBricksBlockFromBricksBlockAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.BRICKS).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_bricks").unlockedBy("has_bricks", has(Items.BRICKS)).save(consumer, getDefaultRecipeId(result) + "_from_dye");
    }
    private static void stainedWallFromWallAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.BRICK_WALL).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_brick_wall").unlockedBy("has_brick_wall", has(Items.BRICK_WALL)).save(consumer, getDefaultRecipeId(result) + "_from_dye");
    }
    private static void stainedBricksBlockFromBrick(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike brick) {
        ShapedRecipeBuilder.shaped(result).define('#', brick).pattern("##").pattern("##").unlockedBy("has_brick", has(brick)).group("stained_bricks").save(consumer);
    }
    private static void stainedFlowerPotFromBrick(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike brick) {
        ShapedRecipeBuilder.shaped(result).define('#', brick).pattern("# #").pattern(" # ").unlockedBy("has_brick", has(brick)).group("stained_flower_pot").save(consumer);
    }
    private static void stainedFlowerPotFromFlowerPotAndDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike dye) {
        ShapedRecipeBuilder.shaped(result, 8).define('#', Items.FLOWER_POT).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_flower_pot").unlockedBy("has_flower_pot", has(Items.FLOWER_POT)).save(consumer, getDefaultRecipeId(result) + "_from_dye");
    }

    private static String getConversionRecipeName(ItemLike result, ItemLike base) {
        return getItemName(result) + "_from_" + getItemName(base);
    }

    private static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, "glazed_bricks:" + getConversionRecipeName(result, ingredient) + "_stonecutting");
    }

    private static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        stonecutterResultFromBase(consumer, result, ingredient, 1);
    }

    private static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    private static String getItemName(ItemLike itemLike) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemLike.asItem())).getPath();
    }
    static ResourceLocation getDefaultRecipeId(ItemLike itemLike) {
        return ForgeRegistries.ITEMS.getKey(itemLike.asItem());
    }
}
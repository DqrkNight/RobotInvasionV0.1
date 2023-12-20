package net.DqrkNight.robotinvasion.datagen;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.DqrkNight.robotinvasion.item.util.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static net.DqrkNight.robotinvasion.item.util.ModTags.Items.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.Raw_Titanium.get(),
            ModBlocks.TITANIUM_ORE.get());
    private static final List<ItemLike> SILVER_SMELTABLES = List.of(ModItems.SilverOre.get(),
            ModBlocks.SILVER_ORE_BLOCK.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.Titanium.get(), 0.9f, 300, "titanium");
        oreSmelting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.Titanium.get(), 0.9f, 340, "titanium");
        oreBlasting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.Titanium.get(), 0.8f, 220, "silver");
        oreSmelting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.Titanium.get(), 0.8f, 260, "steel");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Silver.get())
                .unlockedBy(getHasName(ModItems.Silver.get()), has(ModItems.Silver.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Silver.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RATION.get())
                .pattern(" ! ")
                .pattern("@#$")
                .pattern(" % ")
                .define('!', ModItems.BEAN.get())
                .define('@', RATION_VEGGIES)
                .define('#', Items.IRON_INGOT)
                .define('$', RATION_FRUITS)
                .define('%', RAW_MEATS)
                .unlockedBy(getHasName(ModItems.RATION.get()), has(ModItems.RATION.get()))
                .save(pWriter);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, RobotInvasion.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

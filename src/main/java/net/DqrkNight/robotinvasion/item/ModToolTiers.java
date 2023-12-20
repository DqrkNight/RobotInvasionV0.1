package net.DqrkNight.robotinvasion.item;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.item.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 800, 4.0f, 1.0f, 13,
                    ModTags.Blocks.NEEDS_STEEL_TOOL, () -> Ingredient.of(ModItems.Steel.get())),
            new ResourceLocation(RobotInvasion.MOD_ID, "steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}

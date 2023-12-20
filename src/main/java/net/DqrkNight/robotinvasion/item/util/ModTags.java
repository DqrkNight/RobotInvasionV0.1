package net.DqrkNight.robotinvasion.item.util;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> LAB_BLOCKS = tag("lab_blocks");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RobotInvasion.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> RAW_MEATS = tag("raw_meats");
        public static final TagKey<Item> RATION_VEGGIES = tag("ration_veggies");
        public static final TagKey<Item> RATION_FRUITS = tag("ration_fruits");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RobotInvasion.MOD_ID, name));


        }
    }
}

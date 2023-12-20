package net.DqrkNight.robotinvasion.datagen;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.DqrkNight.robotinvasion.item.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.item.Items.*;


public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, RobotInvasion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STEEL_HELMET.get(), (ModItems.STEEL_CHESTPLATE.get()), (ModItems.STEEL_LEGGINGS.get()), (ModItems.STEEL_BOOTS.get()));
        this.tag(ModTags.Items.RAW_MEATS)
                .add((BEEF), (PORKCHOP), (MUTTON), (RABBIT), (COD), (SALMON), (EGG), (CHICKEN));
        this.tag(ModTags.Items.RATION_VEGGIES)
                .add((CARROT), (POTATO), (BEETROOT), (KELP));
        this.tag(ModTags.Items.RATION_FRUITS)
                .add((APPLE), (MELON), (SWEET_BERRIES), (GLOW_BERRIES));
    }
}
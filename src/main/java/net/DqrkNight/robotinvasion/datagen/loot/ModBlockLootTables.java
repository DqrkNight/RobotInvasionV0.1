package net.DqrkNight.robotinvasion.datagen.loot;

import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.block.custom.BeanCropBlock;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.RESISTANCE_WORKSTATION.get());

        this.dropSelf(ModBlocks.COPPER_WIRING_MACHINE.get());

        this.dropSelf(ModBlocks.STEEL_FENCE.get());
        this.dropSelf(ModBlocks.STEEL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.STEEL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STEEL_BUTTON.get());
        this.dropSelf(ModBlocks.STEEL_STAIRS.get());
        this.dropSelf(ModBlocks.STEEL_WALL.get());
        this.dropSelf(ModBlocks.STEEL_PRESSURE_PLATE.get());

        this.dropSelf(ModBlocks.LAB_BLOCK1.get());
        this.dropSelf(ModBlocks.LAB_BLOCK2.get());
        this.dropSelf(ModBlocks.LAB_BLOCK3.get());

        this.add(ModBlocks.TITANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TITANIUM_ORE.get(), ModItems.Raw_Titanium.get()));
        this.add(ModBlocks.SILVER_ORE_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SILVER_ORE_BLOCK.get(), ModItems.SilverOre.get()));

        this.add(ModBlocks.STEEL_SLAB.get(),
            block -> createSlabItemTable(ModBlocks.STEEL_SLAB.get()));
        this.add(ModBlocks.STEEL_DOOR.get(),
                block -> createDoorTable(ModBlocks.STEEL_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeanCropBlock.AGE, 5));

        this.add(ModBlocks.BEAN_CROP.get(), createCropDrops(ModBlocks.BEAN_CROP.get(), ModItems.BEAN.get(),
                ModItems.BEAN_SEEDS.get(), lootitemcondition$builder));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

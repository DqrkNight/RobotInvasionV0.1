package net.DqrkNight.robotinvasion.datagen;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.item.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RobotInvasion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.LAB_BLOCKS)
                .add(ModBlocks.LAB_BLOCK1.get(),
                        ModBlocks.LAB_BLOCK2.get(),
                        ModBlocks.LAB_BLOCK2.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.SILVER_ORE_BLOCK.get(),
                        ModBlocks.STEEL_BLOCK.get(),
                        ModBlocks.TITANIUM_ORE.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.SILVER_ORE_BLOCK.get(),
                        ModBlocks.STEEL_BLOCK.get(),
                        ModBlocks.TITANIUM_ORE.get(),
                        ModBlocks.LAB_BLOCK1.get(),
                        ModBlocks.LAB_BLOCK2.get(),
                        ModBlocks.LAB_BLOCK2.get(),
                        ModBlocks.RESISTANCE_WORKSTATION.get()
                );

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.STEEL_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.STEEL_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.STEEL_WALL.get());
    }
}

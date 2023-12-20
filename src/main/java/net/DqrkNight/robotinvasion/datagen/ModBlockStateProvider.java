package net.DqrkNight.robotinvasion.datagen;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.block.custom.BeanCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RobotInvasion.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.SILVER_BLOCK);

        blockWithItem(ModBlocks.SILVER_ORE_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_ORE);

        blockWithItem(ModBlocks.LAB_BLOCK1);
        blockWithItem(ModBlocks.LAB_BLOCK2);
        blockWithItem(ModBlocks.LAB_BLOCK3);

        blockWithItem(ModBlocks.RESISTANCE_WORKSTATION);

        stairsBlock(((StairBlock) ModBlocks.STEEL_STAIRS.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.STEEL_SLAB.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.STEEL_BUTTON.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.STEEL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.STEEL_FENCE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.STEEL_FENCE_GATE.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.STEEL_WALL.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.STEEL_DOOR.get()), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.STEEL_TRAPDOOR.get()), modLoc("block/steel_trapdoor"), true, "cutout");

        makeBeanCrop((CropBlock) ModBlocks.BEAN_CROP.get(), "bean_stage", "bean_stage");

        simpleBlock(ModBlocks.COPPER_WIRING_MACHINE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/copper_wiring_machine")));
    }
    public void makeBeanCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> beanStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] beanStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BeanCropBlock) block).getAgeProperty()),
                new ResourceLocation(RobotInvasion.MOD_ID, "block/" + textureName + state.getValue(((BeanCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

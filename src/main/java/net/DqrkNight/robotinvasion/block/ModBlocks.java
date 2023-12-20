package net.DqrkNight.robotinvasion.block;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.custom.BeanCropBlock;
import net.DqrkNight.robotinvasion.block.custom.CopperWiringMachineBlock;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RobotInvasion.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock( "steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).destroyTime(3.0f)));

    public static final RegistryObject<Block> SILVER_ORE_BLOCK = registerBlock( "silver_ore_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).destroyTime(1.5f)));

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock( "silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3f)));

    public static final RegistryObject<Block> TITANIUM_ORE= registerBlock( "titanium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).destroyTime(1.5f)));

    public static final RegistryObject<Block> LAB_BLOCK1 = registerBlock( "lab_block1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).destroyTime(3.0f)));

    public static final RegistryObject<Block> LAB_BLOCK2 = registerBlock( "lab_block2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).destroyTime(3.0f)));

    public static final RegistryObject<Block> LAB_BLOCK3 = registerBlock( "lab_block3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).destroyTime(3.0f)));

    public static final RegistryObject<Block> RESISTANCE_WORKSTATION = registerBlock( "resistance_workstation",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).destroyTime(3.0f)));


    public static final RegistryObject<Block> STEEL_STAIRS = registerBlock( "steel_stairs",
            () -> new StairBlock(() -> ModBlocks.STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f)));
    public static final RegistryObject<Block> STEEL_SLAB = registerBlock( "steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f)));
    public static final RegistryObject<Block> STEEL_BUTTON = registerBlock( "steel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 20, true));
    public static final RegistryObject<Block> STEEL_PRESSURE_PLATE = registerBlock( "steel_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f), BlockSetType.IRON  ));
    public static final RegistryObject<Block> STEEL_FENCE = registerBlock( "steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f)));
    public static final RegistryObject<Block> STEEL_FENCE_GATE = registerBlock( "steel_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> STEEL_WALL = registerBlock( "steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f)));
    public static final RegistryObject<Block> STEEL_DOOR = registerBlock( "steel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> STEEL_TRAPDOOR = registerBlock( "steel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).destroyTime(3.5f).noOcclusion(), BlockSetType.STONE));

    public static final RegistryObject<Block> BEAN_CROP = BLOCKS.register( "bean_crop",
            () -> new BeanCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));

    public static final RegistryObject<Block> COPPER_WIRING_MACHINE = BLOCKS.register( "copper_wiring_machine",
            () -> new CopperWiringMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register (name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

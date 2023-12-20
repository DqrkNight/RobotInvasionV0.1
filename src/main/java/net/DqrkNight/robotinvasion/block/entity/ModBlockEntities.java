package net.DqrkNight.robotinvasion.block.entity;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RobotInvasion.MOD_ID);

    public static final RegistryObject<BlockEntityType<CopperWiringMachineBlockEntity>> COPPER_WIRING_BE =
            BLOCK_ENTITIES.register("copper_wiring_be", () ->
                    BlockEntityType.Builder.of(CopperWiringMachineBlockEntity::new,
                            ModBlocks.COPPER_WIRING_MACHINE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

package net.DqrkNight.robotinvasion.item;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RobotInvasion.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROBOT_INVASION = CREATIVE_MODE_TABS.register("robot_invasion_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_PICKAXE.get()))
                    .title(Component.translatable("Robot Invasion"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Roamer_SpawnEgg.get());
                        pOutput.accept(ModItems.Hammer.get());
                        pOutput.accept(ModItems.RATION.get());
                        pOutput.accept(ModItems.CoalCoke.get());

                        pOutput.accept(ModItems.Steel.get());
                        pOutput.accept(ModItems.Steel_Dust.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.STEEL_FENCE.get());
                        pOutput.accept(ModBlocks.STEEL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.STEEL_DOOR.get());
                        pOutput.accept(ModBlocks.STEEL_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.STEEL_BUTTON.get());
                        pOutput.accept(ModBlocks.STEEL_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.STEEL_SLAB.get());
                        pOutput.accept(ModBlocks.STEEL_STAIRS.get());
                        pOutput.accept(ModBlocks.STEEL_WALL.get());
                        pOutput.accept(ModItems.STEEL_HELMET.get());
                        pOutput.accept(ModItems.STEEL_CHESTPLATE.get());
                        pOutput.accept(ModItems.STEEL_LEGGINGS.get());
                        pOutput.accept(ModItems.STEEL_BOOTS.get());

                        pOutput.accept(ModItems.STEEL_SWORD.get());
                        pOutput.accept(ModItems.STEEL_PICKAXE.get());
                        pOutput.accept(ModItems.STEEL_AXE.get());
                        pOutput.accept(ModItems.STEEL_SHOVEL.get());
                        pOutput.accept(ModItems.STEEL_HOE.get());

                        pOutput.accept(ModBlocks.SILVER_ORE_BLOCK.get());
                        pOutput.accept(ModItems.Silver.get());
                        pOutput.accept(ModItems.SilverOre.get());
                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());

                        pOutput.accept(ModItems.Raw_Titanium.get());
                        pOutput.accept(ModItems.Titanium.get());
                        pOutput.accept(ModBlocks.TITANIUM_ORE.get());

                        pOutput.accept(ModBlocks.LAB_BLOCK1.get());
                        pOutput.accept(ModBlocks.LAB_BLOCK2.get());

                        pOutput.accept(ModBlocks.RESISTANCE_WORKSTATION.get());

                        pOutput.accept(ModItems.BEAN_SEEDS.get());
                        pOutput.accept(ModItems.BEAN.get());

                        pOutput.accept(ModItems.COPPER_WIRE.get());
                        pOutput.accept(ModBlocks.COPPER_WIRING_MACHINE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

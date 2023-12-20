package net.DqrkNight.robotinvasion.screen;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, RobotInvasion.MOD_ID);

    public static final RegistryObject<MenuType<CopperWiringMachineMenu>> COPPER_WIRING_MENU =
            registerMenuType("gem_polishing_menu", CopperWiringMachineMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventbus){
        MENUS.register(eventbus);
    }
}

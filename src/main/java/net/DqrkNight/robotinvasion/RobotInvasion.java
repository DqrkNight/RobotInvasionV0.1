package net.DqrkNight.robotinvasion;

import com.mojang.logging.LogUtils;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.block.entity.ModBlockEntities;
import net.DqrkNight.robotinvasion.item.ModCreativeModTabs;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.DqrkNight.robotinvasion.loot.ModLootModifiers;
import net.DqrkNight.robotinvasion.screen.CopperWiringMachineScreen;
import net.DqrkNight.robotinvasion.screen.ModMenuTypes;
import net.DqrkNight.robotinvasion.villager.ModVillagers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RobotInvasion.MOD_ID)
public class RobotInvasion {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "robotinvasion";
    private static final Logger LOGGER = LogUtils.getLogger();


    public RobotInvasion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.COPPER_WIRING_MENU.get(), CopperWiringMachineScreen::new);
        }
    }
}

package net.DqrkNight.robotinvasion.villager;

import com.google.common.collect.ImmutableSet;
import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, RobotInvasion.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, RobotInvasion.MOD_ID);

    public static final RegistryObject<PoiType> RESISTANCE_POI = POI_TYPES.register("resistance_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.RESISTANCE_WORKSTATION.get().getStateDefinition().getPossibleStates()),
                    2, 2));

    public static final RegistryObject<VillagerProfession> RESISTANCE_MEMBER =
            VILLAGER_PROFESSIONS.register("resistance_member", () -> new VillagerProfession("resistance_member",
                    holder -> holder.get() == RESISTANCE_POI.get(), holder -> holder.get() == RESISTANCE_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }


}

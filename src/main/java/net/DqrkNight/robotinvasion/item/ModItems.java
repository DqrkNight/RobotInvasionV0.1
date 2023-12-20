package net.DqrkNight.robotinvasion.item;

import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.block.ModBlocks;
import net.DqrkNight.robotinvasion.item.custom.FuelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RobotInvasion.MOD_ID);

    public static final RegistryObject<Item> Hammer = ITEMS.register("hammer",
            ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> Steel = ITEMS.register("steel",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Steel_Dust = ITEMS.register("steel_dust",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Roamer_SpawnEgg = ITEMS.register("roamer_spawnegg",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CoalCoke = ITEMS.register("coalcoke",
            ()-> new FuelItem(new Item.Properties(), 3200));
    public static final RegistryObject<Item> SilverOre = ITEMS.register("silver_ore",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Silver = ITEMS.register("silver",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_Titanium = ITEMS.register("raw_titanium",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Titanium = ITEMS.register("titanium",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RATION = ITEMS.register("ration",
            ()-> new Item(new Item.Properties().food(ModFoods.RATION)));

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            ()-> new SwordItem(ModToolTiers.STEEL, 3, 1, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            ()-> new PickaxeItem(ModToolTiers.STEEL, 1, 1.1f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            ()-> new AxeItem(ModToolTiers.STEEL, 7, 1.2f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            ()-> new ShovelItem(ModToolTiers.STEEL, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            ()-> new HoeItem(ModToolTiers.STEEL, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            ()-> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            ()-> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            ()-> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> BEAN_SEEDS = ITEMS.register("bean_seeds",
            ()-> new ItemNameBlockItem(ModBlocks.BEAN_CROP.get(), new  Item.Properties()));
    public static final RegistryObject<Item> BEAN = ITEMS.register("bean",
            ()-> new Item(new Item.Properties().food(ModFoods.BEAN)));

    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",
            ()-> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package net.DqrkNight.robotinvasion.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.DqrkNight.robotinvasion.RobotInvasion;
import net.DqrkNight.robotinvasion.item.ModItems;
import net.DqrkNight.robotinvasion.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RobotInvasion.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.Steel.get(), 2),
                    4, 18, 0.4f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.Steel.get(), 1),
                    new ItemStack(Items.EMERALD, 3),
                    8, 18, 0.4f));
        }
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.BEAN_SEEDS.get(), 1),
                    8, 8, 0.02f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BEAN.get(), 1),
                    new ItemStack(ModItems.BEAN_SEEDS.get(), 1),
                    4, 8, 0.02f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BEAN.get(), 16),
                    new ItemStack(Items.EMERALD, 1),
                    8, 8, 0.02f));
        }
        if(event.getType() == ModVillagers.RESISTANCE_MEMBER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.RATION.get(), 1),
                    4, 8, 0.02f));
        }
    }

    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
           new ItemStack(Items.EMERALD, 4),
           new ItemStack(ModItems.BEAN_SEEDS.get(), 1),
           4, 2, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 32),
                new ItemStack(ModItems.Hammer.get(), 1),
                1, 12, 1.0f));
    }

}

package site.hellishmods.blahaj.init;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import site.hellishmods.blahaj.blahaj;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = blahaj.MOD_ID)
public class VillagerTradeInit {
    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent e) { // Add Klappar Haj to villager trades
        if (e.getType()!=VillagerProfession.SHEPHERD||!ConfigInit.GrayHajEnabled.get()) return; // If it's enabled and the villager's profession is shepherd

        // Add a Klappar Haj trade that costs 15 emeralds each
        e.getTrades().get(3).add((trader, rand) -> new MerchantOffer(
            new ItemStack(Items.EMERALD, 15),
            new ItemStack(ItemInit.grayShork.get()),
            2, 30, 0.1f)
        );
    }
}

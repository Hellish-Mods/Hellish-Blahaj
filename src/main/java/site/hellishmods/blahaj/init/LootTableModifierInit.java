package site.hellishmods.blahaj.init;

import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import site.hellishmods.blahaj.blahaj;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = blahaj.MOD_ID)
public class LootTableModifierInit {
    @SubscribeEvent
    public static void onLootTableRegister(LootTableLoadEvent e) { // Add Klappar Haj to loot tables
        if (!ConfigInit.GrayHajEnabled.get()) return; // If it's enabled

        if (
            e.getName().equals(LootTables.VILLAGE_PLAINS_HOUSE) ||
            e.getName().equals(LootTables.VILLAGE_TAIGA_HOUSE) ||
            e.getName().equals(LootTables.VILLAGE_SNOWY_HOUSE) ||
            e.getName().equals(LootTables.STRONGHOLD_CROSSING) ||
            e.getName().equals(LootTables.STRONGHOLD_CORRIDOR)
        ) {
            e.getTable().addPool(new LootPool.Builder()
                .add(ItemLootEntry.lootTableItem(() -> ItemInit.grayShork.get()).setWeight(5))
                .add(ItemLootEntry.lootTableItem(() -> Items.AIR).setWeight(100))
                .build() // Add a 5% of finding it
            );
        }
    }
}

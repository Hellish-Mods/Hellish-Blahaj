package site.hellishmods.blahaj.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.lib.PillowItem;

public class ItemInit {
    public static RegistryObject<Item> grayShork; 

    // Add items
    public static void init() {
        blahaj.ITEMS.register("blue_shark", () -> new PillowItem()); // Blahaj
        grayShork = blahaj.ITEMS.register("gray_shark", () -> new PillowItem()); // Klappar Haj
        blahaj.ITEMS.register("bread", () -> new PillowItem()); // Bread
    }
}

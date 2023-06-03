package site.hellishmods.blahaj.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.lib.PillowItem;

public class ItemInit {
    public static RegistryObject<Item> shork;
    public static RegistryObject<Item> grayShork;
    public static RegistryObject<Item> bread;

    // Add items
    public static void init() {
        shork = blahaj.ITEMS.register("blue_shark", () -> new PillowItem()); // Blahaj
        grayShork = blahaj.ITEMS.register("gray_shark", () -> new PillowItem()); // Klappar Haj
        bread = blahaj.ITEMS.register("bread", () -> new PillowItem()); // Bread
    }
}

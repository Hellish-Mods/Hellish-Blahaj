package site.hellishmods.blahaj;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import site.hellishmods.blahaj.init.ConfigInit;
import site.hellishmods.blahaj.init.ItemInit;

@Mod(blahaj.MOD_ID)
public class blahaj
{
    // Consts and vars
    public static final String MOD_ID = "blahaj";

    // Registries
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public blahaj() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); // Event bus

        // Register stuff
        ModLoadingContext.get().registerConfig(Type.COMMON, ConfigInit.SPEC, MOD_ID+"-common.toml"); // Config
        ItemInit.init(); // Items

        ITEMS.register(bus); // Add item regestry to bus

        MinecraftForge.EVENT_BUS.register(this); // Register mod
    }
}

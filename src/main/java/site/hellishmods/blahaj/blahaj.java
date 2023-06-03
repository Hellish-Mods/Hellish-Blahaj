package site.hellishmods.blahaj;

import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import site.hellishmods.blahaj.init.ConfigInit;
import site.hellishmods.blahaj.init.ItemInit;

@Mod(blahaj.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = blahaj.MOD_ID)
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

        ITEMS.register(bus); // Add item registry to bus

        MinecraftForge.EVENT_BUS.register(this); // Register mod
    }

    // Events
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void beyouModelRegister(final FMLClientSetupEvent event) { // Model overwrite register
        event.enqueueWork(() -> {
            ItemModelsProperties.register(ItemInit.shork.get(), new ResourceLocation(MOD_ID, "is_beyou"), (stack, world, living) -> {
                return stack.hasCustomHoverName() && stack.getHoverName().getString().toLowerCase().replaceAll(" ", "").equals("beyou") ? 1 : 0; // If the blåhaj is named "beyou", set the model to trans_shark.json
            });
        });
    }
}

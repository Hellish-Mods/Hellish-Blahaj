package site.hellishmods.blahaj.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.lib.BlahajConfigCondition;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = blahaj.MOD_ID)
public class RecipeConditionInit {
    @SubscribeEvent
    public static void registerRecipeCondition(RegistryEvent.Register<IRecipeSerializer<?>> e) {
        CraftingHelper.register(new BlahajConfigCondition.Serializer()); // Register the bread recipe condition
    }
}

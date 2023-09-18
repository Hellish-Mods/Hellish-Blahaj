package site.hellishmods.blahaj.lib;

import com.google.common.collect.Lists;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.util.ResourceLocation;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.init.ConfigInit;
import site.hellishmods.blahaj.init.ItemInit;

@JeiPlugin
public class BlahajJeiPlugin implements IModPlugin { // JEI plugin
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(blahaj.MOD_ID, "jei_plugin");
    }
    
    // Hide items if they are disabled in the config
    @Override
    public void onRuntimeAvailable(IJeiRuntime r) {
        if(!ConfigInit.GrayHajEnabled.get()) r.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM, Lists.newArrayList(ItemInit.grayShork.get().getDefaultInstance()));
        if(!ConfigInit.WhaleEnabled.get()) r.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM, Lists.newArrayList(ItemInit.whale.get().getDefaultInstance()));
        if(!ConfigInit.BreadEnabled.get()) r.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM, Lists.newArrayList(ItemInit.bread.get().getDefaultInstance()));
    }
}

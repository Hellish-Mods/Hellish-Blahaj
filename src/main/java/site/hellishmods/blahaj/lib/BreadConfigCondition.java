package site.hellishmods.blahaj.lib;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.init.ConfigInit;

public class BreadConfigCondition implements ICondition { // Bread pillow recipe condition
    public static final ResourceLocation ID = new ResourceLocation(blahaj.MOD_ID, "bread");

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ConfigInit.BreadEnabled.get(); // Return if it's enabled in the config
    }

    // Serializer
    public static class Serializer implements IConditionSerializer<BreadConfigCondition> {
        @Override
        public void write(JsonObject json, BreadConfigCondition value) {}

        @Override
        public BreadConfigCondition read(JsonObject json) {
            return new BreadConfigCondition();
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
        
    }
    
}

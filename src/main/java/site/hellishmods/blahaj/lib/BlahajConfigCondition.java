package site.hellishmods.blahaj.lib;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import site.hellishmods.blahaj.blahaj;
import site.hellishmods.blahaj.init.ConfigInit;

public class BlahajConfigCondition implements ICondition { // Bread pillow recipe condition
    public static final ResourceLocation ID = new ResourceLocation(blahaj.MOD_ID, "config");
    static Map<String, ConfigValue<Boolean>> configMap = new HashMap<>();
    static {
        configMap.put("whale", ConfigInit.WhaleEnabled);
        configMap.put("bread", ConfigInit.BreadEnabled);
    }

    public String configOptionName;
    ConfigValue<Boolean> configOption;
    public BlahajConfigCondition(String configOptionName) {
        this.configOptionName = configOptionName;
        configOption = configMap.get(configOptionName);
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return configOption.get(); // Return if it's enabled in the config
    }

    // Serializer
    public static class Serializer implements IConditionSerializer<BlahajConfigCondition> {
        @Override
        public void write(JsonObject json, BlahajConfigCondition value) {
            json.addProperty("config", value.configOptionName);
        }

        @Override
        public BlahajConfigCondition read(JsonObject json) {
            return new BlahajConfigCondition(json.get("config").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
        
    }
    
}

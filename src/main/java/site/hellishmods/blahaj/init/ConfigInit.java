package site.hellishmods.blahaj.init;

import net.minecraftforge.common.ForgeConfigSpec;

// Config
public class ConfigInit {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GrayHajEnabled; // Is Klappar Haj enabled?
    public static final ForgeConfigSpec.ConfigValue<Boolean> BreadEnabled; // Is bread enabled?

    static {
        GrayHajEnabled = BUILDER.comment("Is the Klappar Haj enabled? (Should it spawn naturally in the world?)").define("Klappar Haj", true);
        BreadEnabled = BUILDER.comment("Is the bread pillow enabled? (Should it be craftable?)").define("Bread", true);

        SPEC = BUILDER.build();
    }
}

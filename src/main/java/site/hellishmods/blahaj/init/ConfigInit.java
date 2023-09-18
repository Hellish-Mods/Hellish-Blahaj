package site.hellishmods.blahaj.init;

import net.minecraftforge.common.ForgeConfigSpec;

// Config
public class ConfigInit {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GrayHajEnabled; // Is Klappar Haj enabled?
    public static final ForgeConfigSpec.ConfigValue<Boolean> BreadEnabled; // Is bread enabled?
    public static final ForgeConfigSpec.ConfigValue<Boolean> WhaleEnabled; // Is Blavingad enabled?

    static {
        GrayHajEnabled = BUILDER.comment("Enable Klappar Haj? (Should it spawn naturally in the world?)").define("Klappar Haj", true);
        WhaleEnabled = BUILDER.comment("Enable Blavingad? (Should it be craftable?)").define("Blavingad", true);
        BreadEnabled = BUILDER.comment("Enable the bread pillow? (Should it be craftable?)").define("Bread", true);

        SPEC = BUILDER.build();
    }
}

package site.hellishmods.hellishtemplate;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(hellishtemplate.MOD_ID)
public class hellishtemplate
{
    // Consts and vars
    public static final String MOD_ID = "hellishtemplate";

    public hellishtemplate() {
        MinecraftForge.EVENT_BUS.register(this); // Register mod
    }
}

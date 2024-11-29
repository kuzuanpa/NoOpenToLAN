package cn.kuzuanpa.NoOpenToLAN;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = NoOpenToLAN.MODID, useMetadata = true, dependencies = "required-after:unimixins")
public class NoOpenToLAN {
    public static Configuration config;

    public static final String MODID = "NoOpenToLAN";

    public static boolean disableButton, removeButton, sendHint, guiHint;

    public static String hintMessage = "Open To LAN is buggy and shouldn't be used!";
    public static String hintMessage2 = "Please refer to [https://minecraft.fandom.com/wiki/Tutorials/Setting_up_a_Minecraft_Forge_server] to setup a dedicated server";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        loadConfig();
        config.save();
    }

    public void loadConfig(){
        removeButton = config.getBoolean("removeButton", "NoOpenToLAN", false, "remove the open to LAN button");
        disableButton = config.getBoolean("disableButton", "NoOpenToLAN", false, "Disable the open to LAN Button");
        sendHint = config.getBoolean("HintAfterOpen", "NoOpenToLAN", true, "Send Hints when player opened to LAN");
        guiHint = config.getBoolean("HintInGui", "NoOpenToLAN", true, "Send Hints when player opened to LAN");
        hintMessage = config.getString("hintMessage", "NoOpenToLAN", hintMessage, "The hint message when player opened to LAN.");
        hintMessage2 = config.getString("hintMessage2", "NoOpenToLAN", hintMessage2, "Hint message2, provides a link to help player setup dedicated server.");
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
    {
        if (!eventArgs.modID.equals(MODID))return;
        loadConfig();
    }
}


package net.alexanders.foodgalore.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.alexanders.foodgalore.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean enableOreo = true;
    public static boolean enableTomato = true;
    public static boolean enableLettuce = true;
    public static boolean enableHamburger = true;
    public static boolean enableBoiledEgg = true;
    public static boolean enableChocolate = true;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        enableOreo = configuration.getBoolean("enableOreo", Configuration.CATEGORY_GENERAL, true, "");
        enableTomato = configuration.getBoolean("enableTomato", Configuration.CATEGORY_GENERAL, true, "");
        enableLettuce = configuration.getBoolean("enableLettuce", Configuration.CATEGORY_GENERAL, true, "");
        enableHamburger = configuration.getBoolean("enableHamburger", Configuration.CATEGORY_GENERAL, true, "");
        enableBoiledEgg = configuration.getBoolean("enableBoiledEgg", Configuration.CATEGORY_GENERAL, true, "");
        enableChocolate = configuration.getBoolean("enableChocolate", Configuration.CATEGORY_GENERAL, true, "");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
}

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
    public static boolean enableSyrup = true;
    public static boolean enablePancakes = true;
    public static boolean enableCheese = true;
    public static final String CATEGORY_CROPS = "crops";
    public static final String CATEGORY_FOODITEMS = "food";


    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
            configuration.setCategoryRequiresMcRestart(CATEGORY_CROPS, true);
            configuration.setCategoryRequiresMcRestart(CATEGORY_FOODITEMS, true);

        }
    }

    private static void loadConfiguration()
    {
        configuration.getCategory(CATEGORY_CROPS);
        configuration.getCategory(CATEGORY_FOODITEMS);
        enableOreo = configuration.getBoolean("enableOreo", CATEGORY_FOODITEMS, true, "");
        enableTomato = configuration.getBoolean("enableTomato", CATEGORY_CROPS, true, "");
        enableLettuce = configuration.getBoolean("enableLettuce", CATEGORY_CROPS, true, "");
        enableHamburger = configuration.getBoolean("enableHamburger", CATEGORY_FOODITEMS, true, "");
        enableBoiledEgg = configuration.getBoolean("enableBoiledEgg", CATEGORY_FOODITEMS, true, "");
        enableChocolate = configuration.getBoolean("enableChocolate", CATEGORY_FOODITEMS, true, "");
        enableSyrup = configuration.getBoolean("enableSyrup", CATEGORY_FOODITEMS, true, "");
        enablePancakes = configuration.getBoolean("enablePancakes", CATEGORY_FOODITEMS, true, "");
        enableCheese = configuration.getBoolean("enableCheese", CATEGORY_FOODITEMS, true, "");
        configuration.setCategoryRequiresMcRestart(CATEGORY_CROPS, true);
        configuration.setCategoryRequiresMcRestart(CATEGORY_FOODITEMS, true);
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

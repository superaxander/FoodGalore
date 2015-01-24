package net.alexanders.FoodGalore;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.alexanders.FoodGalore.configuration.ConfigurationHandler;
import net.alexanders.FoodGalore.proxy.*;
import net.alexanders.FoodGalore.reference.*;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class FoodGalore
{
    @Mod.Instance(Reference.MOD_ID)
    public static FoodGalore instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent evt)
    {

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {

    }
}

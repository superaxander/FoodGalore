package net.alexanders.foodgalore;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.alexanders.foodgalore.handler.ConfigurationHandler;
import net.alexanders.foodgalore.init.ModItems;
import net.alexanders.foodgalore.proxy.*;
import net.alexanders.foodgalore.reference.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FoodGalore
{
    @Mod.Instance(Reference.MOD_ID)
    public static FoodGalore instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static CreativeTabs tabCustom = new CreativeTabs("FoodGalore") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModItems.boiledEgg;
        }
    };
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
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

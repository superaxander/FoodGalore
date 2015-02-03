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
import net.alexanders.foodgalore.handler.ModLivingDropsEvent;
import net.alexanders.foodgalore.init.ModItems;
import net.alexanders.foodgalore.proxy.*;
import net.alexanders.foodgalore.reference.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

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
            if(ConfigurationHandler.enableBoiledEgg){
                return ModItems.boiledEgg;
            }else if(ConfigurationHandler.enableHamburger){
                return ModItems.hamburger;
            }else{
                return Items.apple;
            }
        }
    };
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.lettuceseeds), 10);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.tomatoseeds), 10);
        MinecraftForge.EVENT_BUS.register(new ModLivingDropsEvent());

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

package net.alexanders.foodgalore.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.alexanders.foodgalore.block.BlockCropLettuce;
import net.alexanders.foodgalore.block.BlockCropTomato;
import net.alexanders.foodgalore.block.BlockFGCrop;
import net.alexanders.foodgalore.handler.ConfigurationHandler;
import net.alexanders.foodgalore.item.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModItems
{
    public static final ItemFGFood boiledEgg = new ItemBoiledEgg(2, 0.5f, false);
    public static final ItemFGFood oreoCookie = new ItemOreo(8, 2.5f, false);
    public static final ItemFGFood chocolate = new ItemChocolate(3, 1.0f, false);
    public static final ItemFG bitterChocolate = new ItemBitterChocolate();
    public static final BlockFGCrop lettucecrop = new BlockCropLettuce();
    public static final ItemFGSeeds lettuceseeds = new ItemLettuceSeeds();
    public static final ItemFGFood lettuce = new ItemLettuce();
    public static final BlockFGCrop tomatocrop = new BlockCropTomato();
    public static final ItemFGSeeds tomatoseeds = new ItemTomatoSeeds();
    public static final ItemFGFood tomato = new ItemTomato();
    public static final ItemFGFood hamburger = new ItemHamburger();
    public static final ItemFGFood hamburgerlettuce = new ItemHamburgerLettuce();
    public static final ItemFGFood hamburgertomato = new ItemHamburgerTomato();
    public static final ItemFGFood hamburgerlettucetomato = new ItemHamburgerLettuceTomato();

    public static void init()
    {
        registerItems();
        registerBlocks();
        registerCraftingRecipes();
    }
    private static void registerItems()
    {
        if(ConfigurationHandler.enableBoiledEgg) {
            GameRegistry.registerItem(boiledEgg, "BoiledEgg");
        }
        if(ConfigurationHandler.enableChocolate) {
            GameRegistry.registerItem(bitterChocolate, "BitterChocolate");
            GameRegistry.registerItem(chocolate, "Chocolate");
            if(ConfigurationHandler.enableOreo) {
                GameRegistry.registerItem(oreoCookie, "Oreo");
            }
        }
        if(ConfigurationHandler.enableLettuce) {
            GameRegistry.registerItem(lettuce, "Lettuce");
            GameRegistry.registerItem(lettuceseeds, "Lettuce_Seeds");
            if (ConfigurationHandler.enableHamburger){
                GameRegistry.registerItem(hamburgertomato, "Hamburger_tomato");
            }
        }
        if(ConfigurationHandler.enableTomato) {
            GameRegistry.registerItem(tomato, "Tomato");
            GameRegistry.registerItem(tomatoseeds, "Tomato_Seeds");
            if(ConfigurationHandler.enableHamburger){
                GameRegistry.registerItem(hamburgerlettuce, "Hamburger_lettuce");
            }
        }
        if(ConfigurationHandler.enableHamburger) {
            GameRegistry.registerItem(hamburger, "Hamburger");
            if(ConfigurationHandler.enableLettuce && ConfigurationHandler.enableHamburger) {
                GameRegistry.registerItem(hamburgerlettucetomato, "Hamburger_lettuce_tomato");
            }
        }
    }
    private static void registerBlocks() {
        if (ConfigurationHandler.enableLettuce) {
            GameRegistry.registerBlock(lettucecrop, "Lettuce_Block");
        }
        if (ConfigurationHandler.enableTomato){
            GameRegistry.registerBlock(tomatocrop, "Tomato_Block");
        }
    }
    private static void registerCraftingRecipes()
    {

        if(ConfigurationHandler.enableBoiledEgg) {
            GameRegistry.addSmelting(Items.egg, new ItemStack(boiledEgg), 2);
        }
        if(ConfigurationHandler.enableChocolate) {
            GameRegistry.addSmelting(new ItemStack(Items.dye, 1, 3), new ItemStack(bitterChocolate, 2), 2);

            GameRegistry.addShapelessRecipe(new ItemStack(chocolate), new ItemStack(bitterChocolate), new ItemStack(Items.sugar), new ItemStack(Items.sugar));
            if(ConfigurationHandler.enableOreo) {
                GameRegistry.addShapelessRecipe(new ItemStack(oreoCookie), new ItemStack(Items.cookie), new ItemStack(chocolate), new ItemStack(chocolate), new ItemStack(Items.milk_bucket));
            }
        }
        if(ConfigurationHandler.enableHamburger) {
            GameRegistry.addShapelessRecipe(new ItemStack(hamburger), new ItemStack(Items.bread), new ItemStack(Items.cooked_beef));
            if (ConfigurationHandler.enableTomato) {
                GameRegistry.addShapelessRecipe(new ItemStack(hamburgertomato), new ItemStack(hamburger), new ItemStack(tomato));
            }
            if (ConfigurationHandler.enableLettuce) {
                GameRegistry.addShapelessRecipe(new ItemStack(hamburgerlettuce), new ItemStack(hamburger), new ItemStack(lettuce));
            }
            if (ConfigurationHandler.enableLettuce && ConfigurationHandler.enableTomato){
                GameRegistry.addShapelessRecipe(new ItemStack(hamburgerlettucetomato), new ItemStack(hamburgertomato), new ItemStack(lettuce));
                GameRegistry.addShapelessRecipe(new ItemStack(hamburgerlettucetomato), new ItemStack(hamburgerlettuce), new ItemStack(tomato));
                GameRegistry.addShapelessRecipe(new ItemStack(hamburgerlettucetomato), new ItemStack(Items.bread), new ItemStack(Items.cooked_beef), new ItemStack(lettuce), new ItemStack(tomato));
            }
        }
        if(ConfigurationHandler.enableTomato) {
            GameRegistry.addShapelessRecipe(new ItemStack(tomatoseeds), new ItemStack(tomato));
        }
        if(ConfigurationHandler.enableLettuce) {
            GameRegistry.addShapelessRecipe(new ItemStack(lettuceseeds), new ItemStack(lettuce));
        }
    }
}

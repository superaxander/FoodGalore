package net.alexanders.foodgalore.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.alexanders.foodgalore.block.BlockCropLettuce;
import net.alexanders.foodgalore.block.BlockFGCrop;
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


    public static void init()
    {
        GameRegistry.registerItem(boiledEgg, "BoiledEgg");
        GameRegistry.addSmelting(Items.egg, new ItemStack(boiledEgg), 2);
        GameRegistry.registerItem(bitterChocolate, "BitterChocolate");
        GameRegistry.addSmelting(new ItemStack(Items.dye, 1, 3), new ItemStack(bitterChocolate, 2), 2);
        GameRegistry.registerItem(chocolate, "Chocolate");
        GameRegistry.addShapelessRecipe(new ItemStack(chocolate), new ItemStack(bitterChocolate), new ItemStack(Items.sugar), new ItemStack(Items.sugar));
        GameRegistry.registerItem(oreoCookie, "Oreo");
        GameRegistry.addShapelessRecipe(new ItemStack(oreoCookie), new ItemStack(Items.cookie), new ItemStack(chocolate), new ItemStack(chocolate), new ItemStack(Items.milk_bucket));
        GameRegistry.registerBlock(lettucecrop, "Lettuce_Block");
        GameRegistry.registerItem(lettuce, "Lettuce");
        GameRegistry.registerItem(lettuceseeds, "Lettuce_Seeds");
    }
}

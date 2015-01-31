package net.alexanders.foodgalore.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;

public class ItemBoiledEgg extends ItemFGFood {
    public ItemBoiledEgg(int hungerAmount, float saturation,boolean isWolfFood )
    {
        super(hungerAmount, saturation, isWolfFood);
        this.setUnlocalizedName("boiledEgg");
    }

}

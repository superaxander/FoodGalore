package net.alexanders.foodgalore.item;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraftforge.common.IPlantable;

public class ItemLettuceSeeds extends ItemFGSeeds implements IPlantable
{
    public ItemLettuceSeeds()
    {
        super(ModItems.lettucecrop);
        this.setUnlocalizedName("LettuceSeeds");
    }
}

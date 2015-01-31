package net.alexanders.foodgalore.item;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraftforge.common.IPlantable;

public class ItemTomatoSeeds extends ItemFGSeeds implements IPlantable
{
    public ItemTomatoSeeds()
    {
        super(ModItems.tomatocrop);
        this.setUnlocalizedName("TomatoSeeds");
    }
}

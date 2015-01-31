package net.alexanders.foodgalore.block;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraft.item.Item;

public class BlockCropTomato extends BlockFGCrop
{
    public BlockCropTomato() {
        super(4);
        this.setBlockName("TomatoCrop");
    }

    @Override
    protected Item func_149866_i()
    {
        return ModItems.tomatoseeds;
    }
    @Override
    protected Item func_149865_P()
    {
        return ModItems.tomato;
    }
}

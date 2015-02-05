package net.alexanders.foodgalore.block;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraft.item.Item;


public class BlockCropTea extends BlockFGCrop {
    public BlockCropTea() {
        super(4);
        this.setBlockName("TeaCrop");
    }

    @Override
    protected Item func_149866_i()
    {
        return ModItems.teaseeds;
    }
    @Override
    protected Item func_149865_P()
    {
        return ModItems.tealeaf;
    }
}

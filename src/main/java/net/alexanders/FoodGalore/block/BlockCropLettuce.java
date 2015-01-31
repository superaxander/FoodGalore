package net.alexanders.foodgalore.block;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraft.item.Item;


public class BlockCropLettuce extends BlockFGCrop {
    public BlockCropLettuce() {
        this.setBlockName("LettuceCrop");

    }

    @Override
    protected Item func_149866_i()
    {
        return ModItems.lettuceseeds;
    }
    @Override
    protected Item func_149865_P()
    {
        return ModItems.lettuce;
    }

}

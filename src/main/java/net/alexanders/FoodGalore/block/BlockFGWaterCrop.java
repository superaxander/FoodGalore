package net.alexanders.foodgalore.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BlockFGWaterCrop extends BlockFGCrop
{
    public BlockFGWaterCrop(int states) {
        super(states);
    }

    @Override
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.water;
    }

}

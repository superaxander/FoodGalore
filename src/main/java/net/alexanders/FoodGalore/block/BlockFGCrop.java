package net.alexanders.foodgalore.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.alexanders.foodgalore.FoodGalore;
import net.alexanders.foodgalore.init.ModItems;
import net.alexanders.foodgalore.reference.Reference;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockFGCrop extends BlockCrops
{
    public BlockFGCrop()
    {

    }
    @SideOnly(Side.CLIENT)
    private IIcon[] iconarray;
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {

        this.iconarray = new IIcon[4];
        for(int i = 0; i < this.iconarray.length; i++)
        {
            this.iconarray[i] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + (i+1));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata < 7)
        {
            if(metadata == 6)
            {
                metadata = 5;
            }
            return this.iconarray[metadata >> 1];
        }
        return this.iconarray[3];
    }
    @Override
    public int quantityDropped(Random random)
    {
      return 1;
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}

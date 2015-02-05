package net.alexanders.foodgalore.item;

import net.alexanders.foodgalore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemFGWaterSeeds extends ItemFG implements IPlantable
{
    private Block field_150925_a;
    public ItemFGWaterSeeds(Block crop)
    {
        this.field_150925_a = crop;
    }
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Water;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (movingobjectposition == null)
        {
            return itemStack;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, i, j, k))
                {
                    return itemStack;
                }

                if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
                {
                    return itemStack;
                }

                if (world.getBlock(i, j, k).getMaterial() == Material.water && world.getBlockMetadata(i, j, k) == 0 && world.isAirBlock(i, j + 1, k))
                {
                    // special case for handling block placement with water lilies
                    net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(world, i, j + 1, k);
                    world.setBlock(i, j + 1, k, ModItems.teacrop);
                    if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace(player, blocksnapshot, net.minecraftforge.common.util.ForgeDirection.UP).isCanceled())
                    {
                        blocksnapshot.restore(true, false);
                        return itemStack;
                    }

                    if (!player.capabilities.isCreativeMode)
                    {
                        --itemStack.stackSize;
                    }
                }
            }

            return itemStack;
        }
    }
    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return field_150925_a;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
}

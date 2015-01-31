package net.alexanders.foodgalore.item;

public class ItemChocolate extends ItemFGFood
{
    public ItemChocolate(int hungerAmount, float saturation,boolean isWolfFood )
    {
        super(hungerAmount, saturation, isWolfFood);
        this.setUnlocalizedName("chocolate");
    }

}

package net.alexanders.foodgalore.item;

public class ItemOreo extends ItemFGFood {
    public ItemOreo(int hungerAmount, float saturation, boolean isWolfFood)
    {
        super(hungerAmount, saturation, isWolfFood);
        this.setUnlocalizedName("oreoCookie");
    }

}

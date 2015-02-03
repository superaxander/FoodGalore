package net.alexanders.foodgalore.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.alexanders.foodgalore.init.ModItems;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class ModLivingDropsEvent {

    public Random r = new Random();

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        if(event.entityLiving instanceof EntityCow && !event.entityLiving.isChild() && ConfigurationHandler.enableCheese) {
            event.entityLiving.dropItem(ModItems.rennet, r.nextInt(3));
        }
    }

}
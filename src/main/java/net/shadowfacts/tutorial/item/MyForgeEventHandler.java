package net.shadowfacts.tutorial.item;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MyForgeEventHandler {
	@SubscribeEvent
	public void pickupItem(EntityItemPickupEvent event) {
		System.out.println("Item picked up!");
	}
}

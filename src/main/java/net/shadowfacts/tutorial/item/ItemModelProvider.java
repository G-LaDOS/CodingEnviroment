package net.shadowfacts.tutorial.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface ItemModelProvider {

	void registerItemModel(Item item);

}
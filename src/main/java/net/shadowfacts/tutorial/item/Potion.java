package net.shadowfacts.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.shadowfacts.tutorial.TutorialMod;

public class Potion extends ItemPotion implements ItemModelProvider{
	private String name;
	
	public Potion(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);

	}
	@Override
	public void registerItemModel(Item item) {
		TutorialMod.proxy.registerItemRenderer(this, 0, name);
		
	}
	@Override
	public Potion setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}

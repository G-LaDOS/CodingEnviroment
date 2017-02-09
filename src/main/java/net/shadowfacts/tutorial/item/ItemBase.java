package net.shadowfacts.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.shadowfacts.tutorial.TutorialMod;

public class ItemBase extends Item implements ItemModelProvider{
 
 protected String name;
 
 public ItemBase(String name) {
 this.name = name;
 setUnlocalizedName(name);
 setRegistryName(name);
 
 //setCreativeTab(TutorialMod.creativeTab); //this is commented out, because we don't have our creative-tab yet.
 }
 
 public static void speak(){
	 System.out.println("HEY THERE BAFFOOOOON CAN YOU READ THIS!?");
 }
 
 public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
 {
 world.spawnEntityInWorld(new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player));
 return item;
 }
 

 @Override
 public void registerItemModel(Item item) {
 TutorialMod.proxy.registerItemRenderer(this, 0, name);
 }
 
 @Override
 public ItemBase setCreativeTab(CreativeTabs tab) {
 super.setCreativeTab(tab);
 return this;
 }

}
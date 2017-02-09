package net.shadowfacts.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModItems {

	public static Food gum;
	public static Food ass;
	public static ItemBase cute_shit;
	public static ItemBase the_item;
	public static ItemWands the_wand;
	public static Potion purplePotion;
	public static Sword bigSword;
	 
	public static void init() {
		bigSword = register(new Sword("bigSword", Item.ToolMaterial.DIAMOND, 40)).setCreativeTab(CreativeTabs.COMBAT);
		purplePotion = register(new Potion("purplePotion")).setCreativeTab(CreativeTabs.FOOD);
		gum = register(new Food("gum", 1, 4, false).setCreativeTab(CreativeTabs.MATERIALS));
		ass = register(new Food("ass", 4, 9, true).setCreativeTab(CreativeTabs.FOOD));
		cute_shit = register(new ItemBase("cute_shit").setCreativeTab(CreativeTabs.FOOD));	
		the_item = register(new ItemBase("the_item").setCreativeTab(CreativeTabs.MATERIALS));
		the_wand = register(new ItemWands("the_wand").setCreativeTab(CreativeTabs.MATERIALS));
		System.out.println("Hi there FAGGOT KILL YOUR SELF IF YOU CANT READ THIS!!!!");
		ItemBase.speak();
		
	}
	
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if(item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}
	
public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
{
world.spawnEntityInWorld(new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player));
return item;
}


}
	

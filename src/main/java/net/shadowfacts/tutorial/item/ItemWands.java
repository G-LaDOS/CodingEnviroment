package net.shadowfacts.tutorial.item;

import ibxm.Player;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.shadowfacts.tutorial.TutorialMod;

public class ItemWands extends Item implements ItemModelProvider {

	protected String name;

	public ItemWands(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
		setMaxDamage(5);
		isDamageable();
		
		
		// setCreativeTab(TutorialMod.creativeTab); //this is commented out,
		// because we don't have our creative-tab yet.
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		itemstack.damageItem(1, entityplayer);
		return itemstack;
	}
	public ActionResult<ItemStack> onItemRightClick2(ItemStack item, World world, EntityPlayer player)
	{
	world.spawnEntityInWorld(new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player));
	return new ActionResult(EnumActionResult.SUCCESS, item);
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
    {
		
		world.createExplosion(player, player.posX, player.posY + 1, player.posZ, 2, true);
		return new ActionResult(EnumActionResult.SUCCESS, item);
        
    }
	
	
	public static void speak() {
		System.out.println("HEY THERE BAFFOOOOON CAN YOU READ THIS!?");
	}

	/*@SubscribeEvent
	public ItemStack onRightClick(ItemStack item, World world, EntityPlayer player) {
		world.spawnEntityInWorld(new EntityTNTPrimed(world, player.posX, player.posY, player.posZ, player));
		return item;
	}*/

	@Override
	public void registerItemModel(Item item) {
		TutorialMod.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemWands setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
/*
 * package net.shadowfacts.tutorial.item; public ActionResult<ItemStack>
 * onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
 * EnumHand hand)
 * 
 * import net.minecraft.creativetab.CreativeTabs; import
 * net.minecraft.item.Item; import net.shadowfacts.tutorial.TutorialMod;
 * 
 * public class ItemWands extends ItemBase implements ItemModelProvider {
 * 
 * protected String name; public ItemWands(String name) { super(name);
 * setUnlocalizedName(name); setRegistryName(name); checkOn();
 * 
 * }
 * 
 * public void checkOn(){ System.out.println(
 * "I am on.  This is actually working woohoo.!!!!"); }
 * 
 * @Override public void registerItemModel(Item item) {
 * TutorialMod.proxy.registerItemRenderer(this, 0, name); }
 * 
 * @Override public ItemWands setCreativeTab(CreativeTabs tab) {
 * super.setCreativeTab(tab); return this; }
 * 
 * }
 */
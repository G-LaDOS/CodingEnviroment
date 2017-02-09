package net.shadowfacts.tutorial.item;

import ibxm.Player;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.shadowfacts.tutorial.TutorialMod;

public class Sword extends ItemSword implements ItemModelProvider {
	private String name;
	private float attackDamage;

	// private int multiplyer;

	public Sword(String name, ToolMaterial material, float damageVsEntity) {
		super(material);
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.attackDamage = damageVsEntity + 120;
		this.attackDamage = 120.0F + material.getDamageVsEntity();
		

	}

	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par3Entity instanceof EntityPlayer) {
			
			if (((EntityLivingBase) par3Entity).getHeldItemMainhand() == par1ItemStack) {
				((EntityLivingBase) par3Entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1));

			}else {
				((EntityLivingBase) par3Entity).clearActivePotions();
			}
		}
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand) {
		item.damageItem(10, player);
		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 15, 2));
		return new ActionResult(EnumActionResult.SUCCESS, item);
	}

	@Override
	public void registerItemModel(Item item) {
		TutorialMod.proxy.registerItemRenderer(this, 0, name);

	}

	@Override
	public Sword setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}

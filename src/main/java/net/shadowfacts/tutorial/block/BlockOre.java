package net.shadowfacts.tutorial.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockOre extends BlockBase {

	public BlockOre(String name) {
		super(Material.ROCK, name);

		setHardness(3f);
		setResistance(5f);
		setLightOpacity(5);
		
		
		
	}
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		 if (par5Entity instanceof EntityLiving) {
		  ((EntityLiving) par5Entity).addPotionEffect(new PotionEffect(Potion.getPotionById(1),50, 1));
		 }
	    }
	
	
	

	@Override
	public BlockOre setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
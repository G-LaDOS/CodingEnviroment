package net.shadowfacts.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.shadowfacts.tutorial.TutorialMod;

public class Food extends ItemFood implements ItemModelProvider {
	protected String name;
	private Potion potionId;
	private float duration;

	public Food(String name, int amount, float saturation, boolean isWolfFood) {
		super(5, 6, true);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setAlwaysEdible();

	}
	
	
	/*public Food setPotionEffect(PotionEffect p_185070_1_, float p_185070_2_)
    {
        this.potionId = p_185070_1_;
        this.duration = p_185070_2_;
        return this;
    }
    */
	
	@Override
	public Food setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public void registerItemModel(Item item) {
		TutorialMod.proxy.registerItemRenderer(this, 0, name);

	}


}

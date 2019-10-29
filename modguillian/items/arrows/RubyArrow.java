package com.guillian.modguillian.items.arrows;

import com.guillian.modguillian.entity.rubyArrow.EntityRubyArrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyArrow extends ArrowBase {

	public RubyArrow(String name) {
		
		super(name);
		
	}
	
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack,EntityLivingBase shooter) {
		EntityRubyArrow entityRubyArrow = new EntityRubyArrow(worldIn,shooter);
		return entityRubyArrow;
	}
	
}

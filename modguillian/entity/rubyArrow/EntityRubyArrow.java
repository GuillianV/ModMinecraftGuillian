package com.guillian.modguillian.entity.rubyArrow;


import java.util.Random;

import com.guillian.modguillian.init.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.model.Models;

public class EntityRubyArrow extends EntityArrow{
	
	public EntityRubyArrow(World worldIn) {
		super(worldIn);
	}
	public EntityRubyArrow(World worldIn, double x,double y,double z) {
			super(worldIn, x, y, z);
	}
	public EntityRubyArrow(World worldIn , EntityLivingBase shooter) {
		super(worldIn, shooter);
	}
	
	

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ModItems.RUBY_ARROW);
	}
	@Override
	protected void arrowHit(EntityLivingBase living) {
		super.arrowHit(living);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if(!this.world.isRemote) {
			
			if(this.inGround) {		
					this.world.createExplosion(this, this.posX,this.posY + (double)(this.height / 16.0F), this.posZ,4.0F, true);
					world.removeEntity(this);
			} else {
				this.spawnParticles(1);
			}
		}
		
		
	}
	
	
	
	private void spawnParticles(int particleCount)
	{
		Random rand = new Random();
		int i = rand.nextInt(15);
		double d0 = (double)(i >> 16 & 255) / 255.0D;
		double d1 = (double)(i >> 8 & 255) / 255.0D;
		double d2 = (double)(i >> 0 & 255) / 255.0D;
		for(int j = 0; j < particleCount; ++j)
		{
			this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, d0, d1, d2);
		}
	}
	
	
	
	
}

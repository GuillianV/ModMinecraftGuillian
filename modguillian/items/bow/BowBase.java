package com.guillian.modguillian.items.bow;

import javax.annotation.Nullable;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BowBase extends ItemBow implements IHasModel{
	
	public BowBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.maxStackSize = 1;
		
		
		ModItems.ITEMS.add(this);
		
		
		
		
		 this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
	        {
	            @SideOnly(Side.CLIENT)
	            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
	            {
	                if (entityIn != null && entityIn.getActiveItemStack().getItem() != Items.BOW)
	                {
	                	float pull =  (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                		return pull;
	                }
	                else
	                {
	                		return 0.0F;   
	                }
	            }
	        });
		
		 this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
	        {
	            @SideOnly(Side.CLIENT)
	            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
	            {
	                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
	            }
	        });

	    
	}
	
	


	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}
	
	
	
	

}

package com.guillian.modguillian.items.tools;

import java.util.concurrent.TimeUnit;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.items.ItemBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToolHammer extends ToolPickaxe{

	public ToolHammer(String name, ToolMaterial material) {
		super(name, material);
		
		
	}
	
	
	
	
	
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}
	
	
	
	
	
	
	
	  @Override
	    public boolean onBlockDestroyed(ItemStack breaker, World world, IBlockState state, BlockPos posBlock, EntityLivingBase e)
	    {
	        if (e instanceof EntityPlayer && !world.isRemote)
	        {
	        		int posBlockX = posBlock.getX();
	    			int posBlockY = posBlock.getY();
	    			int posBlockZ = posBlock.getZ();
	    			int posNewBlockX = 0;
	    			int posNewBlockY = 0;
	    			int posNewBlockZ = 0;
	    			int x;
	    			int y;
	    			int z;
	    			
	    			for(x = 0; x< 3; x++) 
	    			{
	    				posNewBlockX = (posBlockX -1 + x);
	    				for(z=0;  z< 3; z++) 
	    				{
	    					posNewBlockZ = posBlockZ -1 + z;
	    					for(y=0; y<3;y++) 
	    					{
	    						posNewBlockY = posBlockY -1 + y;
	    						posBlock = new BlockPos(posNewBlockX,posNewBlockY,posNewBlockZ);
	    						if(world.getBlockState(posBlock).getBlock() != Blocks.BEDROCK) //Check if the block bronken is bedrock
		    					world.destroyBlock(posBlock, true);
	    						breaker.damageItem(1, e); 
	    					}
	    				}
	    			}
	    		 return true;
	        } else
	        	return false;
	    }

}

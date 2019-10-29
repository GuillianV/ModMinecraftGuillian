package com.guillian.modguillian.items.test;



import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.items.ItemBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemTest extends ItemBase {

public ItemTest(String name) {
		
		super(name);
		
		
		
	}



	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}
	
	
	
	
	/*public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		if(!world.isRemote) {
		
			
			int posPlayerX = (int) player.posX;
			int posPlayerY = (int) player.posY;
			int posPlayerZ = (int) player.posZ;
			int posBlockX = 0;
			int posBlockY = 0;
			int posBlockZ = 0;
			int x;
			int z;
			
			//System.out.println(posPlayerY);
			
			
			BlockPos posPlayer = new BlockPos(posPlayerX,posPlayerY,posPlayerZ);
			BlockPos posBlock = new BlockPos(posBlockX,posPlayerY-1,posBlockZ);

			for(x = 0; x< 3; x++) {
				posBlockX = (posPlayerX -1 + x);
				System.out.println(posBlockX);
				for(z=0;  z< 3; z++) {
					posBlockZ = posPlayerZ -1 + z;
					System.out.println(posBlockZ);
					posBlock = new BlockPos(posBlockX,posPlayerY-1,posBlockZ);
					world.destroyBlock(posBlock, false);
				}
				
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	*/
	
	
	
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
	    					System.out.println(posNewBlockZ);
	    					for(y=0; y<3;y++) 
	    					{
	    						posNewBlockY = posBlockY -1 + y;
	    						posBlock = new BlockPos(posNewBlockX,posNewBlockY,posNewBlockZ);
		    					world.destroyBlock(posBlock, true);
	    					}
	    				}
	    			}
	    		 return true;
	        } else
	        	return false;
	    }
	  
	  
	  
	  
	  
}
	               
	            
	     
	
	 
//	 public RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World w, EntityLivingBase e)
//	    {
//	        Vec3d vec3d = e.getPositionEyes(partialTicks);
//	        Vec3d vec3d1 = e.getLook(partialTicks);
//	        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
//	        return w.rayTraceBlocks(vec3d, vec3d2, false, false, true);
//	    }
//	    @Override
//	    public boolean onBlockDestroyed(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e)
//	    {
//	        if (e instanceof EntityPlayer && !w.isRemote)
//	        {
//	            EntityPlayer p = (EntityPlayer) e;
//	            RayTraceResult r = this.rayTrace(5.0D, 0.0F, w, e);
//	            if (r.typeOfHit == RayTraceResult.Type.BLOCK)
//	            {
//	                int x = pos.getX();
//	                int y = pos.getY();
//	                int z = pos.getZ();
//	                EnumFacing side = r.sideHit;
//	                // Y
//	                // UP - DOWN
//	                if (side == EnumFacing.DOWN || side == EnumFacing.UP)
//	                {
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
//	                    // Middle block
//	                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);
//	                }
//	                // Z
//	                // NORTH - SOUTH
//	                else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
//	                {
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
//	                    // Middle block
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
//	                }
//	                // X
//	                // EAST - WEST
//	                else if (side == EnumFacing.EAST || side == EnumFacing.WEST)
//	                {
//	                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
//	                    // Middle block
//	                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
//	                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
//	                }
//	                return true;
//	            }
//	        }
//	        return super.onBlockDestroyed(breaker, w, state, pos, e);
//	    }
//	    private void destroyAndDropBlock(World w, EntityPlayer p, ItemStack breaker, int x, int y, int z)
//	    {
//	        BlockPos pos = new BlockPos(x, y, z);
//	        w.getBlockState(pos).getBlock().harvestBlock(w, p, pos, w.getBlockState(pos), w.getTileEntity(pos), breaker);
//	        w.setBlockToAir(pos);
//	    }




package com.guillian.modguillian.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{

	public static void init()
	{
		
		//Smelting
		GameRegistry.addSmelting(ModBlocks.RUBY_BLOCK, new ItemStack(ModItems.RUBY_POLISHED, 1), 1.5F);
		
		
	}
	
}

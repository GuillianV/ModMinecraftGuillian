package com.guillian.modguillian.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AmethystBlock extends BlockBase
{

	public AmethystBlock(String name, Material material) 
	
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(8.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0F);
		//setBlockUnbreakable();
		
	}

}

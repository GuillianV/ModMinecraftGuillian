package com.guillian.modguillian.init;

import java.util.ArrayList;
import java.util.List;

import com.guillian.modguillian.blocks.AmethystBlock;
import com.guillian.modguillian.blocks.BlockBase;
import com.guillian.modguillian.blocks.RubyBlock;
import com.guillian.modguillian.blocks.RubyOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);
	public static final Block AMETHYST_BLOCK = new AmethystBlock("amethyst_block", Material.IRON);
	public static final Block RUBY_ORE = new RubyOre("ruby_ore", Material.ROCK);

	
}

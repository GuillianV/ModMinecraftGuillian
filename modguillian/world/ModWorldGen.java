package com.guillian.modguillian.world;

import java.util.Random;

import com.guillian.modguillian.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator 
{
	
	static final int RUBY_ORE_ISGENERATED_BEFORE = 16;
	static final int RUBY_ORE_ISGENERATED_BELOW = 64;
	static final int RUBY_ORE_MAX_SIZE_RANDOMLY_GENERATED = 7;
	static final int RUBY_ORE_MIN_SIZE_GENERATED = 4;
	static final int RUBY_FREQUENCY = 18;
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		
		if(world.provider.getDimension() == 0) 
		{
			generatedOverworld(random, chunkX, chunkZ, world , chunkGenerator, chunkProvider);
		}
		
		
	}
	
	private void generatedOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOre(ModBlocks.RUBY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16,RUBY_ORE_ISGENERATED_BEFORE, RUBY_ORE_ISGENERATED_BELOW ,random.nextInt(RUBY_ORE_MAX_SIZE_RANDOMLY_GENERATED)+ RUBY_ORE_MIN_SIZE_GENERATED, RUBY_FREQUENCY);
		
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		
		for(int i = 0; i< chances; i++) 
		{
			BlockPos pos = new BlockPos(x + random.nextInt(16), + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore , size);
			generator.generate(world, random, pos);
		}
		
	}
	

}

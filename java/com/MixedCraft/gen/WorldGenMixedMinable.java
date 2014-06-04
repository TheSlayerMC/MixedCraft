package com.MixedCraft.gen;

import java.util.Random;

import com.MixedCraft.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMixedMinable implements IWorldGenerator{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1: 
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0: 
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1: 
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}



	private void generateNether(World world, Random random, int i, int j) {

	}



	private void generateEnd(World world, Random random, int i, int j) {


	}



	private void generateSurface(World world, Random rand, int chunkX, int chunkZ){

		for(int i = 0; i < 8; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(50);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHelper.copperOre, 5)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
		
		for(int i = 0; i < 8; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(50);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHelper.tinOre, 5)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(20);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHelper.silverOre, 3)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}
		
		for(int i = 0; i < 7; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.coal_ore, 15)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.iron_ore, 8)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
		
		for(int i = 0; i < 2; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.diamond_ore, 6)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.emerald_ore, 1)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.gold_ore, 6)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.lapis_ore, 5)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}
		
		for(int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(100);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(Blocks.redstone_ore, 5)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}
		
		for(int i = 0; i < 5; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(150);
			int randPosZ = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BlockHelper.slowSand, 25, Blocks.sand)).generate(world, rand, randPosX, randPosY, randPosZ);		
		}	
	}
}
package com.MixedCraft.dimension;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.gen.WorldGenFlylightTree;

public class ChunkGeneratorFlylight implements IChunkProvider
{
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise; 
	private MapGenVillage villageGenerator = new MapGenVillage();
	private World worldObj;
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new FlyLightGenCaves();
	private BiomeGenBase[] biomesForGeneration;
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	float[] field_35388_l;
	int[][] field_914_i = new int[32][32];
    public WorldGenerator coalGen;
    public WorldGenerator emeraldGen;
    public WorldGenerator diamondGen;
    public WorldGenerator ironGen;
    public WorldGenerator lapisGen;
    public WorldGenerator goldGen;
    public WorldGenerator redstoneGen;


	public ChunkGeneratorFlylight(World var1, long var2)
	{
		this.worldObj = var1;
		this.rand = new Random(var2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.coalGen = new WorldGenMinable(BlockHelper.Coal, 16, BlockHelper.FlyLightStone);
		this.ironGen = new WorldGenMinable(BlockHelper.Iron, 8, BlockHelper.FlyLightStone);
		this.goldGen = new WorldGenMinable(BlockHelper.Gold, 8, BlockHelper.FlyLightStone);
		this.redstoneGen = new WorldGenMinable(BlockHelper.Redstone, 7, BlockHelper.FlyLightStone);
		this.diamondGen = new WorldGenMinable(BlockHelper.Diamond, 7, BlockHelper.FlyLightStone);
		this.lapisGen = new WorldGenMinable(BlockHelper.Lapis, 6, BlockHelper.FlyLightStone);
		this.emeraldGen = new WorldGenMinable(BlockHelper.Emerald, 1, BlockHelper.FlyLightStone);
	}

	public void generateTerrain(int var1, int var2, byte[] var3)
	{
		byte var4 = 4;
		byte var5 = 16;
		byte var6 = 63;
		int var7 = var4 + 1;
		byte var8 = 17;
		int var9 = var4 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, var1 * 4 - 2, var2 * 4 - 2, var7 + 5, var9 + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var4, 0, var2 * var4, var7, var8, var9);

		for (int var10 = 0; var10 < var4; ++var10)
		{
			for (int var11 = 0; var11 < var4; ++var11)
			{
				for (int var12 = 0; var12 < var5; ++var12)
				{
					double var13 = 0.125D;
					double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
					double var17 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
					double var19 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
					double var21 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
					double var23 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
					double var25 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
					double var27 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
					double var29 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

					for (int var31 = 0; var31 < 8; ++var31)
					{
						double var32 = 0.25D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for (int var42 = 0; var42 < 4; ++var42)
						{
							int var43 = var42 + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + var31;
							short var44 = 128;
							var43 -= var44;
							double var45 = 0.25D;
							double var47 = (var36 - var34) * var45;
							double var49 = var34 - var47;

							for (int var51 = 0; var51 < 4; ++var51)
							{
								if ((var49 += var47) > 0.0D)
								{
									var3[var43 += var44] = BlockHelper.FlyLightStone;
								}
								else if (var12 * 8 + var31 < var6)
								{
									var3[var43 += var44] = Blocks.flowing_water;
								}
								else
								{
									var3[var43 += var44] = 0;
								}
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}
	}

	public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
	{
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

		for (int var8 = 0; var8 < 16; ++var8)
		{
			for (int var9 = 0; var9 < 16; ++var9)
			{
				BiomeGenBase var10 = var4[var9 + var8 * 16];
				float var11 = var10.getFloatTemperature(var9, var9, var9);
				int var12 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				Block var14 = var10.topBlock;
				Block var15 = var10.fillerBlock;

				for (int var16 = 127; var16 >= 0; --var16)
				{
					int var17 = (var9 * 16 + var8) * 128 + var16;

					if (var16 <= 0 + this.rand.nextInt(5))
					{
						var3[var17] = (byte)Blocks.bedrock;
					}
					else
					{
						byte var18 = var3[var17];

						if (var18 == 0)
						{
							var13 = -1;
						}
						else if (var18 != Blocks.stone)
						{
							if (var13 == -1)
							{
								if (var12 <= 0)
								{
									var14 = 0;
									var15 = (byte)BlockHelper.FlyLightStone;
								}
								else if (var16 >= var5 - 4 && var16 <= var5 + 1)
								{
									var14 = var10.topBlock;
									var15 = var10.fillerBlock;
								}

								if (var16 < var5 && var14 == 0)
								{
									var14 = (byte)Block.waterMoving;
								}

								var13 = var12;

								if (var16 >= var5 - 1)
								{
									var3[var17] = var14;
								}
								else
								{
									var3[var17] = var15;
								}
							}
							else if (var13 > 0)
							{
								--var13;
								var3[var17] = var15;

								if (var13 == 0 && var15 == Block.sand)
								{
									var13 = this.rand.nextInt(4);
									var15 = (byte)Block.sandStone;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	@Override
	public Chunk loadChunk(int var1, int var2)
	{
		return this.provideChunk(var1, var2);
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
	 * specified chunk from the map seed and chunk seed
	 */
	@Override
	public Chunk provideChunk(int var1, int var2)
	{
		this.rand.setSeed(var1 * 341873128712L + var2 * 132897987541L);
		byte[] var3 = new byte[32768];
		this.generateTerrain(var1, var2, var3);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
		this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, var1, var2, var3);
		this.villageGenerator.generate(this, this.worldObj, var1, var2, var3);
		Chunk var4 = new Chunk(this.worldObj, var1, var2);
		byte[] var5 = var4.getBiomeArray();

		for (int var6 = 0; var6 < var5.length; ++var6)
		{
			var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}

	private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		if (var1 == null)
		{
			var1 = new double[var5 * var6 * var7];
		}

		if (this.field_35388_l == null)
		{
			this.field_35388_l = new float[25];

			for (int var8 = -2; var8 <= 2; ++var8)
			{
				for (int var9 = -2; var9 <= 2; ++var9)
				{
					float var10 = 10.0F / MathHelper.sqrt_float(var8 * var8 + var9 * var9 + 0.2F);
					this.field_35388_l[var8 + 2 + (var9 + 2) * 5] = var10;
				}
			}
		}

		double var44 = 684.412D;
		double var45 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var44, var45, var44);
		boolean var12 = false;
		boolean var13 = false;
		int var14 = 0;
		int var15 = 0;

		for (int var16 = 0; var16 < var5; ++var16)
		{
			for (int var17 = 0; var17 < var7; ++var17)
			{
				float var18 = 0.0F;
				float var19 = 0.0F;
				float var20 = 0.0F;
				byte var21 = 2;
				BiomeGenBase var22 = this.biomesForGeneration[var16 + 2 + (var17 + 2) * (var5 + 5)];

				for (int var23 = -var21; var23 <= var21; ++var23)
				{
					for (int var24 = -var21; var24 <= var21; ++var24)
					{
						BiomeGenBase var25 = this.biomesForGeneration[var16 + var23 + 2 + (var17 + var24 + 2) * (var5 + 5)];
						float var26 = this.field_35388_l[var23 + 2 + (var24 + 2) * 5] / (var25.minHeight + 2.0F);

						if (var25.minHeight > var22.minHeight)
						{
							var26 /= 2.0F;
						}

						var18 += var25.maxHeight * var26;
						var19 += var25.minHeight * var26;
						var20 += var26;
					}
				}

				var18 /= var20;
				var19 /= var20;
				var18 = var18 * 0.9F + 0.1F;
				var19 = (var19 * 4.0F - 1.0F) / 8.0F;
				double var47 = this.noise6[var15] / 8000.0D;

				if (var47 < 0.0D)
				{
					var47 = -var47 * 0.3D;
				}

				var47 = var47 * 3.0D - 2.0D;

				if (var47 < 0.0D)
				{
					var47 /= 2.0D;

					if (var47 < -1.0D)
					{
						var47 = -1.0D;
					}

					var47 /= 1.4D;
					var47 /= 2.0D;
				}
				else
				{
					if (var47 > 1.0D)
					{
						var47 = 1.0D;
					}

					var47 /= 8.0D;
				}

				++var15;

				for (int var46 = 0; var46 < var6; ++var46)
				{
					double var48 = var19;
					double var28 = var18;
					var48 += var47 * 0.2D;
					var48 = var48 * var6 / 16.0D;
					double var30 = var6 / 2.0D + var48 * 4.0D;
					double var32 = 0.0D;
					double var34 = (var46 - var30) * 12.0D * 128.0D / 128.0D / var28;

					if (var34 < 0.0D)
					{
						var34 *= 4.0D;
					}

					double var36 = this.noise1[var14] / 512.0D;
					double var38 = this.noise2[var14] / 512.0D;
					double var40 = (this.noise3[var14] / 10.0D + 1.0D) / 2.0D;

					if (var40 < 0.0D)
					{
						var32 = var36;
					}
					else if (var40 > 1.0D)
					{
						var32 = var38;
					}
					else
					{
						var32 = var36 + (var38 - var36) * var40;
					}

					var32 -= var34;

					if (var46 > var6 - 4)
					{
						double var42 = (var46 - (var6 - 4)) / 3.0F;
						var32 = var32 * (1.0D - var42) + -10.0D * var42;
					}

					var1[var14] = var32;
					++var14;
				}
			}
		}

		return var1;
	}

	/**
	 * Checks to see if a chunk exists at x, y
	 */
	@Override
	public boolean chunkExists(int var1, int var2)
	{
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	@Override
	public void populate(IChunkProvider var1, int var2, int var3)
	{
		BlockSand.fallInstantly = true;
		int var4 = var2 * 16;
		int var5 = var3 * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(var2 * var7 + var3 * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(var1, worldObj, rand, var2, var3, var11));

		int var12;
		int var13;
		int var14;

		for(int i = 0; i < 20; i++){
			var12 = var4 + this.rand.nextInt(16);
			var13 = this.rand.nextInt(300);
			var14 = var5 + this.rand.nextInt(16);
			(new WorldGenMinable(BlockHelper.FlyLightOre, 6, BlockHelper.FlyLightStone)).generate(worldObj, rand, var12, var13, var14);
		}
		
		int k, l, i1, j;
		
        for (j = 0; j < 50; ++j)
        {
            k = var4+ this.rand.nextInt(16) + 8;
            l = this.rand.nextInt(this.rand.nextInt(120) + 8);
            i1 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(BlockHelper.Water)).generate(worldObj, rand, k, l, i1);
        }
        
		for(j = 0; j < 13; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(250);
			var14 = var5 + rand.nextInt(16);
			coalGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 8; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(200);
			var14 = var5 + rand.nextInt(16);
			ironGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 6; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(100);
			var14 = var5 + rand.nextInt(16);
			goldGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 5; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			diamondGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 8; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(60);
			var14 = var5 + rand.nextInt(16);
			redstoneGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 5; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			emeraldGen.generate(worldObj, rand, var12, var13, var14);
		}
		
		for(j = 0; j < 4; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			lapisGen.generate(worldObj, rand, var12, var13, var14);
		}


		WorldGenFlylightTree var17 = new WorldGenFlylightTree(true);
		int var19;
		int var18;
		int var21;
		int var20;

		for (var18 = 0; var18 < 1; ++var18)
		{
			var19 = var4 + this.rand.nextInt(16);
			var20 = var5 + this.rand.nextInt(16);
			var21 = this.worldObj.getHeightValue(var19, var20);
			var17.generate(this.worldObj, this.rand, var19, var21, var20);
		}
		
		/*if (rand.nextInt(8) == 0) {
			var18 = var4 + rand.nextInt(16) + 8;
			var19 = rand.nextInt(128);
			var20 = var4 + rand.nextInt(16) + 8;

			if (var19 < 63 || rand.nextInt(10) == 0) {
				(new WorldGenLakes(BlockHelper.Water)).generate(worldObj, rand, var18, var19, var20);
			}
		}*/

		int xMin = var2 << 4;
		int zMin = var3 << 4;

		int startX = xMin + rand.nextInt(16);
		int startZ = zMin + rand.nextInt(16);

		int tries = rand.nextInt(2);

		int x = startX + rand.nextInt(8) - rand.nextInt(8);
		int z = startZ + rand.nextInt(8) - rand.nextInt(8);
		int y = worldObj.getHeightValue(x, z);

		int i;

		for (i = 0; i < 60; i++) {
			if ((worldObj.isAirBlock(x, y, z) || BlockHelper.Flower1.canBlockStay(worldObj, x, y, z))) {
				if (rand.nextInt(50) > 1)
					continue;
				worldObj.setBlock(x, y, z, BlockHelper.Flower1, 0, 0);
			}
		}

		for (i = 0; i < 60; i++) {
			if ((worldObj.isAirBlock(x, y, z) || BlockHelper.Flower2.canBlockStay(worldObj, x, y, z))) {
				if (rand.nextInt(50) > 1)
					continue;

				worldObj.setBlock(x, y, z, BlockHelper.Flower2, 0, 0);
			}
		}

		for (i = 0; i < 70; i++) {

			if ((worldObj.isAirBlock(x, y, z) || BlockHelper.FlylightGrass.canBlockStay(worldObj, x, y, z))) {
				if (rand.nextInt(50) > 1)
					continue;

				worldObj.setBlock(x, y, z, BlockHelper.FlylightGrass, 0, 0);
			}
		}

		for (i = 0; i < 80; i++) {          
			if ((worldObj.isAirBlock(x, y, z) || BlockHelper.FlylightFern.canBlockStay(worldObj, x, y, z))) {
				if (rand.nextInt(50) > 1)
					continue;

				worldObj.setBlock(x, y, z, BlockHelper.FlylightFern, 0, 0);
			}
		}

		Random r = rand;
		World w = this.worldObj;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(var1, worldObj, rand, var2, var3, var11));

		BlockSand.fallInstantly = false;
	}

	/**
	 * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
	 * Return true if all chunks have been saved.
	 */
	@Override
	public boolean saveChunks(boolean var1, IProgressUpdate var2)
	{
		return true;
	}

	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	@Override
	public boolean canSave()
	{
		return true;
	}

	/**
	 * Converts the instance data to a readable string.
	 */
	@Override
	public String makeString()
	{
		return "";
	}

	/**
	 * Returns a list of creatures of the specified type that can spawn at the given location.
	 */
	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(var2, var4);
		return var5 == null ? null : var5.getSpawnableList(var1);
	}

	/**
	 * Returns the location of the closest structure of the specified type. If not found returns null.
	 */
	@Override
	public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5)
	{
		return null;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2) {

	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public void saveExtraData() {

	}
}

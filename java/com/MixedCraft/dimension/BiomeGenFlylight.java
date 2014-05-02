package com.MixedCraft.dimension;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.biome.BiomeGenBase;

import com.MixedCraft.BlockHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenFlylight extends BiomeGenBase{

    protected static final BiomeGenBase.Height flylight = new BiomeGenBase.Height(2.0F, 1.2F);

	
	public BiomeGenFlylight() {
		super(DimensionHelper.FlyLightID);		 
		setBiomeName("Flylight");
		topBlock = BlockHelper.flylightGrass;
		fillerBlock = BlockHelper.flylightDirt;
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 3, 2, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 3, 2, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 3, 2, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 3, 2, 6));
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
        setHeight(flylight);
	}

	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1)
	{
		return 0x00D91D;
	}

}

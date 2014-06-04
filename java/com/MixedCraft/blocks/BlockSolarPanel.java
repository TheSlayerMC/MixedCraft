package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.container.BlockModContainer;
import com.MixedCraft.blocks.tileEntity.TileEntitySolarPanel;

public class BlockSolarPanel extends BlockModContainer
{

	public BlockSolarPanel(String name) {
		super(Material.wood, name);
		this.setCreativeTab(MixedCraft.BlockTab);
		setStepSound(Block.soundTypeMetal);
		registerTexture("SolarPanel_Side", "SolarPanel_Top", "SolarPanel_Bottom");
	}

	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	}


	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {}
	
	public void updateLightLevel(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.provider.hasNoSky)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			int i1 = par1World.getSavedLightValue(EnumSkyBlock.Sky, par2, par3, par4) - par1World.skylightSubtracted;
			float f = par1World.getCelestialAngleRadians(1.0F);

			if (f < (float)Math.PI)
			{
				f += (0.0F - f) * 0.2F;
			}
			else
			{
				f += (((float)Math.PI * 2F) - f) * 0.2F;
			}

			i1 = Math.round((float)i1 * MathHelper.cos(f));

			if (i1 < 0)
			{
				i1 = 0;
			}

			if (i1 > 15)
			{
				i1 = 15;
			}

			if (l != i1)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 3);
			}
		}
	}

	public boolean canProvidePower()
	{
		return true;
	}

	public TileEntity createNewTileEntity(World par1World, int par1)
	{
		return new TileEntitySolarPanel();
	}
}

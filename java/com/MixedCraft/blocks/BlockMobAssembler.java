package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.container.BlockModContainer;
import com.MixedCraft.blocks.tileEntity.TileEntityDNAAssembler;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockMobAssembler extends BlockModContainer {

	private Random furnaceRand = new Random();

	private static boolean keepFurnaceInventory = true;

	private IIcon top, bottom, side;

	public BlockMobAssembler(String name) {
		super(Material.wood, name);
		setHardness(2.0F);
		registerTexture("MobAssembler_Side", "MobAssembler_Top" , "MobAssembler_Bottom");
	}

    public Block setName(String name) {
        GameRegistry.registerBlock(this, name);
        setBlockName(name);
        return this;
    }
    
	public TileEntity createNewTileEntity(World var1, int IDK)
	{
		return new TileEntityDNAAssembler();
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{        
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityDNAAssembler var10 = (TileEntityDNAAssembler)par1World.getTileEntity(par2, par3, par4);

			if (var10 != null)
			{
				par5EntityPlayer.openGui(MixedCraft.instance, 16, par1World, par2, par3, par4);
			}

			return true;
		}
	}

	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4, BlockHelper.assembler);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, BlockHelper.assembler);
		}

		keepFurnaceInventory = true;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);

		if (var6 != null)
		{
			var6.validate();
			par1World.setTileEntity(par2, par3, par4, var6);
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			TileEntityDNAAssembler var7 = (TileEntityDNAAssembler)par1World.getTileEntity(par2, par3, par4);

			if (var7 != null)
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
				{
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null)
					{
						float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0)
						{
							int var13 = this.furnaceRand.nextInt(21) + 10;

							if (var13 > var9.stackSize)
							{
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

							if (var9.hasTagCompound())
							{
								var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
							var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}

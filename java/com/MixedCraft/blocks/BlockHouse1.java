package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MixedCraft.ItemHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.api.MixedAPI;
import com.MixedCraft.gen.House1;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHouse1 extends BlocksBase
{
	private Random rand;
	private EntityPlayer entityplayer;
	private String register;

	public BlockHouse1(String name)
	{
		super(Material.wood, name);
		this.setCreativeTab(MixedCraft.BlockTab);
		GameRegistry.registerBlock(this, getUnlocalizedName());
	}
	public void registerBlockIcons(IIconRegister var1)
	{
		this.blockIcon = var1.registerIcon("MixedCraft:house1");
	}

	public IIcon getBlockTextureFromSideAndMetadata(int var1, int var2)
	{
		return this.blockIcon;
	}
	
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
	{
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null)
		{
			return false;
		}
		ItemStack copper = new ItemStack(ItemHelper.CopperIngot, 1);
		if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem() == copper);
		{
			this.genTreeHouse(world, rand, i, j, k);
			if(!world.isRemote)
			{
				entityplayer.addChatMessage(MixedAPI.addChatMessage(EnumChatFormatting.GREEN + "Building a house!"));
			}
			equipped.stackSize--;
			return true;
		}
	}

	public void genTreeHouse(World world, Random rand, int i, int j, int k)
	{
		world.setBlock(i, j, k, null, 0, k);
		House1 treehouse = new House1();
		if (!treehouse.generate(world, rand, i, j, k))
		{
			world.setBlock(i, j, k, this);
		}
	}
}
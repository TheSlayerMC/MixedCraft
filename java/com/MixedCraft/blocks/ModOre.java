package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.MixedCraft.BlockHelper;

public class ModOre extends ModBlock{

	public ModOre() {
		super();
		setLightLevel(0.6F);
		setHardness(3.0F);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		if(this == BlockHelper.coal){
			return Items.coal;
		}
		if(this == BlockHelper.diamond){
			return Items.diamond;
		}
		if(this == BlockHelper.lapis){
			return Items.dye;
		}
		if(this == BlockHelper.emerald){
			return Items.emerald;
		}
		if(this == BlockHelper.iron){
			return Item.getItemFromBlock(this);
		}
		if(this == BlockHelper.gold){
			return Item.getItemFromBlock(this);
		}
		if(this == BlockHelper.redstone){
			return Items.redstone;
		}
		return null;
	}

	public int quantityDropped(Random par1Random) {
		if(this == BlockHelper.lapis){
			return this == BlockHelper.lapis ? 4 + par1Random.nextInt(5) : 1;
		}
		if(this == BlockHelper.redstone){
			return 4 + par1Random.nextInt(2);
		}
		return 1;
	}

	@Override
	public int getExpDrop(IBlockAccess par1World, int par5, int par7)
	{
		Random rand = new Random();
		if (this.getItemDropped(par5, rand, par7) != Item.getItemFromBlock(this))
		{
			int j1 = 0;

			if (this == BlockHelper.coal)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
			}
			else if (this == BlockHelper.diamond)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if (this == BlockHelper.emerald)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if (this == BlockHelper.lapis)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
			}
			return j1;
		}

		return 0;
	}
	
	public int quantityDroppedWithBonus(int par1, Random par2Random)
	{
		if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
		{
			int j = par2Random.nextInt(par1 + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return this.quantityDropped(par2Random) * (j + 1);
		}
		else
		{
			return this.quantityDropped(par2Random);
		}
	}

	public int damageDropped(int idk)
	{
		return this == BlockHelper.lapis ? 4 : this == BlockHelper.redstone ? 4 : 0;
	}
}

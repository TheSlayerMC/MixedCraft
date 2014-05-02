package com.MixedCraft.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.MixedCraft.helper.ItemsBase;

public class ItemModSeeds extends ItemsBase implements IPlantable {

	private Block crop;
	private Block soilBlockID;

	public ItemModSeeds(Block crop, Block soil) {
		this.crop = crop;
		this.soilBlockID = soil;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par7 != 1) {
			return false;
		}
		else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)) {
			if (par3World.getBlock(par4, par5, par6).canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) && par3World.isAirBlock(par4, par5 + 1, par6)) {
				par3World.setBlock(par4, par5 + 1, par6, this.crop);
				par1ItemStack.stackSize--;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return crop == Blocks.nether_wart ? EnumPlantType.Nether : EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return crop;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
}
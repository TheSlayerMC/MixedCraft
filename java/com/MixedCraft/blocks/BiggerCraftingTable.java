package com.MixedCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.BlocksBase;
import com.MixedCraft.helper.GuiHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiggerCraftingTable extends BlocksBase{

	@SideOnly(Side.CLIENT)
	private IIcon workbenchIIconTop;
	@SideOnly(Side.CLIENT)
	private IIcon workbenchIIconFront;

	public BiggerCraftingTable(String name) {
		super(Material.wood, name);
		setStepSound(Block.soundTypeWood);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.workbenchIIconTop : (par1 == 0 ? Blocks.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIIconFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.blockIcon = par1IIconRegister.registerIcon("MixedCraft:bigSide");
		this.workbenchIIconTop = par1IIconRegister.registerIcon("MixedCraft:bigTop");
		this.workbenchIIconFront = par1IIconRegister.registerIcon("MixedCraft:bigFront");
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if (!player.isSneaking()) {
			player.openGui(MixedCraft.instance, GuiHandler.craftingTable, var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}
}
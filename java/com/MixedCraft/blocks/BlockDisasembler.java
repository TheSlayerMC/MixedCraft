package com.MixedCraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.tileEntity.TileEntityDisasembler;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDisasembler extends BlockContainer {
	private IIcon[] texture;

	public BlockDisasembler()  {
		super(Material.rock);	
	}

	@Override
	public TileEntity createNewTileEntity(World world, int idk) {
		return new TileEntityDisasembler();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c){
		TileEntity te = world.getTileEntity(x, y, z);
		
		if(te == null || player.isSneaking()){
			return false;
		}
		
		player.openGui(MixedCraft.instance, 0, world, x, y, z);
		
		return true;
  }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("MixedCraft:Disasembler");
    }
}

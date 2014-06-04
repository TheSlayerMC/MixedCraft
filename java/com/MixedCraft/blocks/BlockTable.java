package com.MixedCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.container.BlockModContainer;
import com.MixedCraft.blocks.tileEntity.TileEntityTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTable extends BlockModContainer {
	
    public BlockTable(String name) {
        super(Material.rock, name);   
        setStepSound(Block.soundTypeWood);
        setCreativeTab(MixedCraft.BlockTab);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("plank_oak");
    }
    
    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
    	return new TileEntityTable();
    }
}

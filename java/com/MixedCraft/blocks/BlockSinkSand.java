package com.MixedCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.LangRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockSinkSand extends BlockFalling{

	public BlockSinkSand() {
        this.setCreativeTab(MixedCraft.BlockTab);
        setHardness(1.0F);
        setStepSound(Block.soundTypeSand);
        LangRegistry.addBlock(this);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        par5Entity.setInWeb();
    }
    
    public Block setName(String name) {
        GameRegistry.registerBlock(this, name);
        setBlockName(name);
        setBlockTextureName("sand");
        return this;
    }
    
    @Override
    public boolean isOpaqueCube() {
    	return true;
    }
}
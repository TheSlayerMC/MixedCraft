package com.MixedCraft.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModDirt extends BlocksBase {

	public BlockModDirt(String name) {
		super(Material.ground, name);
		setCreativeTab(MixedCraft.BlockTab);
		setStepSound(Block.soundTypeGravel);
		GameRegistry.registerBlock(this, name);
        setBlockName(name);                 
        registerTexture("flylightGrass_Bottom");
	} 
}
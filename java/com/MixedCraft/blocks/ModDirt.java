package com.MixedCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModDirt extends BlocksBase {

	public ModDirt() {
		super(Material.ground);
		setCreativeTab(MixedCraft.BlockTab);
		setStepSound(Block.soundTypeGravel);
	}

	@Override
	public Block setName(String name) {
		GameRegistry.registerBlock(this, name);
        setBlockName(name);                 
        registerTexture("flylightGrass_Bottom");
		return this;
	}   

}
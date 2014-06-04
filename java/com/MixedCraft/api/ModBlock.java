package com.MixedCraft.api;

import net.minecraft.block.material.Material;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.helper.BlocksBase;

public class ModBlock extends BlocksBase{

	public ModBlock(String name) {
		super(Material.rock, name);
	}
	
	@Override
	public void setHarvestLevel(String toolClass, int level) {
		if(isOre()){
			setHarvestLevel("pickaxe", 3);
		}
	}
	
	public boolean isOre(){
		if(this == BlockHelper.copperOre)
			return true;
		if(this == BlockHelper.silverOre)
			return true;
		if(this == BlockHelper.tinOre)
			return true;
		else
			return false;
	}
}
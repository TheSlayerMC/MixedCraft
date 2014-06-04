package com.MixedCraft.api;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.ItemHelper;
import com.MixedCraft.handler.*;
import com.MixedCraft.helper.*;

import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraftforge.common.*;

public class Achievements extends HelperHandler {

	public static final Achievement copperOre 	= addAchievement("CopperOre", 0, 1, BlockHelper.copperOre, null, false);
	public static final Achievement tinOre 		= addAchievement("TinOre", 	4, 1, BlockHelper.tinOre, 	 null, false);

	public static final Achievement copper  	= addAchievement("Copper", 0, 3, ItemHelper.CopperIngot, copperOre, false);
	public static final Achievement tin 		= addAchievement("Tin", 4, 3, ItemHelper.TinIngot, tinOre, false);

	public static final Achievement extractor 	= addAchievement("Extractor", 0, 5, BlockHelper.extractor, copper, true);
	public static final Achievement mixer 		= addAchievement("Mixer",  1, 6, BlockHelper.mixer, extractor, true);
	public static final Achievement assembler 	= addAchievement("Assembler", 2, 7, BlockHelper.assembler, mixer, true); 

	private static Achievement addAchievement(String name, int x, int y, Block image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, haveFirst).registerStat() : new Achievement(name, name, x, y, image, haveFirst).registerStat().setSpecial();
	}
	
	private static Achievement addAchievement(String name, int x, int y, Item image, Achievement haveFirst, boolean isSpecial){
		return isSpecial ? new Achievement(name, name, x, y, image, haveFirst).registerStat() : new Achievement(name, name, x, y, image, haveFirst).registerStat().setSpecial();
	}
	
	public static final AchievementPage MixedPage = new AchievementPage("MixedCraft", 
			copperOre, tinOre, copper, tin, extractor, mixer, assembler
	);

	public static void init(){
		AchievementPage.registerAchievementPage(MixedPage);
	}
}
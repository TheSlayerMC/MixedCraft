package com.MixedCraft;

import com.MixedCraft.handler.HelperHandler;
import com.MixedCraft.helper.CraftingHandler;
import com.MixedCraft.helper.LangRegistry;
import com.MixedCraft.helper.PickupHandler;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements extends HelperHandler{

	public static final Achievement CopperOre 	= new Achievement("CopperOre", "CopperOre", 0, 1, BlockHelper.CopperOre, (Achievement)null).registerStat(); 
	public static final Achievement TinOre 		= new Achievement("TinOre", 	"TinOre", 	4, 1, BlockHelper.TinOre, 	 (Achievement)null).registerStat(); 

	public static final Achievement Copper  	= new Achievement("Copper", 	"Copper", 	0, 3, ItemHelper.CopperIngot, 		 CopperOre).registerStat(); 
	public static final Achievement Tin 		= new Achievement("Tin", 		"Tin", 		4, 3, ItemHelper.TinIngot, 				TinOre).registerStat(); 

	public static final Achievement Extractor 	= new Achievement("Extractor", "Extractor", 0, 5, BlockHelper.Extractor, 			Copper).registerStat().setSpecial(); 
	public static final Achievement Mixer 		= new Achievement("Mixer", 	   "Mixer", 	1, 6, BlockHelper.Mixer, 			 Extractor).registerStat().setSpecial(); 
	public static final Achievement Assembler 	= new Achievement("Assembler", "Assembler", 2, 7, BlockHelper.Assembler, 			 Mixer).registerStat().setSpecial(); 

	public static final AchievementPage MixedPage = new AchievementPage("MixedCraft", CopperOre, TinOre, Copper, Tin, Extractor, Mixer, Assembler);

	public static void init(){
		AchievementPage.registerAchievementPage(MixedPage);
	}
}
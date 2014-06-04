package com.MixedCraft;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.MixedCraft.api.ModBlock;
import com.MixedCraft.api.blocks.BlockModDirt;
import com.MixedCraft.api.blocks.BlockModFire;
import com.MixedCraft.api.blocks.BlockModFlower;
import com.MixedCraft.api.blocks.BlockModLeaves;
import com.MixedCraft.api.blocks.BlockModLog;
import com.MixedCraft.api.blocks.BlockModOre;
import com.MixedCraft.api.blocks.BlockModTallGrass;
import com.MixedCraft.api.blocks.BlockModVine;
import com.MixedCraft.api.blocks.BlockModWater;
import com.MixedCraft.blocks.*;
import com.MixedCraft.blocks.tileEntity.TileEntityDiamondFurnace;
import com.MixedCraft.handler.HelperHandler;
import com.MixedCraft.helper.BlocksBase;
import com.MixedCraft.helper.ConfigHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHelper {

	public static final Block extractor 						= new BlockDNAExtractor("extractor");
	public static final Block mixer 							= new BlockDNAMixer("mixer");
	public static final Block assembler 						= new BlockMobAssembler("assembler");

	public static final Block copperOre 						= new ModBlock("copperOre").setHardness(7.0F);
	public static final Block tinOre 							= new ModBlock("tinOre").setHardness(7.0F);
	public static final Block silverOre 						= new ModBlock("silverOre").setHardness(7.0F);	

	public static final Block copperBlock 						= new ModBlock("copperBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);
	public static final Block tinBlock 							= new ModBlock("tinBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);	
	public static final Block silverBlock 						= new ModBlock("silverBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);
	
	public static final Block solarPanel 						= new BlockSolarPanel("solarPanel").setHardness(2.0F);
	public static final Block goldDoor 							= new BlockGoldDoor(Material.wood, "goldDoor").setCreativeTab(null);
	public static final Block table 							= new BlockTable("table");

	public static final BlockFlylightPortal flylightPortal 		= (BlockFlylightPortal)new BlockFlylightPortal("flylightPortal").setBlockUnbreakable();
	public static final Block flylightGrass 					= new BlockFlylightGrass("flylightGrass").setStepSound(Block.soundTypeGrass);
	public static final Block flylightDirt 						= new BlockModDirt("flylightDirt").setLightLevel(0.1F).setHardness(1.0F).setStepSound(Block.soundTypeGravel);
	public static final Block flylightStone 					= new ModBlock("flylightStone").setHardness(3.0F).setLightLevel(0.1F).setStepSound(Block.soundTypeStone);
	public static final Block flylightOre 						= new ModBlock("flylightOre").setLightLevel(0.1F).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static final Block modFire						    = new BlockModFire("modFire");

	public static final Block flashing 							= new ModBlock("flashing").setHardness(3.5F).setStepSound(Block.soundTypeMetal).setLightLevel(0.875F);
	//public static final Block House1 							= new BlockHouse1().setHardness(3.5F).setStepSound(Block.soundTypeMetal"House1").setLightLevel(0.875F);
	public static final Block slowSand 							= new BlockSinkSand("slowSand");

	public static final Block chocolateCake 					= new BlockChocolateCake("chocolateCakeBlock");
	public static final Block chocolateCrop 					= new BlockChocolateCrop("ChocolateCrop");

	public static final Block poweredFurnace 					= new BlockPoweredFurnace(false, "powerFurnace");
	public static final Block goldFurnace	 					= new BlockGoldFurnace(false, "goldFurnace"); 
	public static final Block ironFurnace 						= new BlockIronFurnace(false, "ironFurnace");
	public static final Block diamondFurnace 					= new BlockDiamondFurnace(false, "diamondFurnace");

	public static final Block ironFurnaceOn 					= new BlockIronFurnace(true, "ironFurnaceOn").setLightLevel(0.875F);
	public static final Block goldFurnaceOn 					= new BlockGoldFurnace(true, "goldFurnaceOn");
	public static final Block poweredFurnaceOn				    = new BlockPoweredFurnace(true, "powerFurnaceOn");
	public static final Block diamondFurnaceOn 					= new BlockDiamondFurnace(true, "diamondFurnaceOn").setLightLevel(0.875F);

	public static final Block flower1 							= new BlockModFlower("cyanFlylightFlower");
	public static final Block flower2 							= new BlockModFlower("blueFlylightFlower");
	public static final Block flylightLog 						= new BlockModLog("flylightLog");
	public static final Block flylightLeaves 					= new BlockModLeaves("flylightLeaves");
	public static final Block flylightFern 						= new BlockModTallGrass("flylightFern");
	public static final Block FlylightTallGrass 				= new BlockModTallGrass("flylightTallGrass");
	public static final Block flylightCane 						= new BlockFlylightSugarCane("flylightSugarCane");
	public static final Block flylightSapling 					= new BlockFlylightSapling("flylightSapling");
	public static final Block water 							= new BlockModWater("flylightWater");
	public static final Block vine 								= new BlockModVine("flylightVine");

	public static final Block iron 								= new BlockModOre("ironOre");
	public static final Block gold 								= new BlockModOre("goldOre");
	public static final Block lapis 							= new BlockModOre("lapisOre");
	public static final Block redstone 							= new BlockModOre("redstoneOre");
	public static final Block diamond 							= new BlockModOre("diamondOre");
	public static final Block coal 								= new BlockModOre("coalOre");
	public static final Block emerald 							= new BlockModOre("emeraldOre"); 

	public static final Block cowSheepWool 						= new ModBlock("cowSheepWool").setHardness(0.2F).setStepSound(Block.soundTypeCloth);
	//public static final Block Disassembler 					= new Disassembler("Disasembler");	
	public static final Block bigCrafting 						= new BiggerCraftingTable("bigCraftingTable");

	public static void addOres(){
		OreDictionary.registerOre("oreCopper", copperOre);
		OreDictionary.registerOre("oreTin", tinOre);
		OreDictionary.registerOre("oreSilver", silverOre);
		OreDictionary.registerOre("oreFlylightIron", iron);
		OreDictionary.registerOre("oreFlylightGold", gold);
		OreDictionary.registerOre("oreFlylightLapis", lapis);
		OreDictionary.registerOre("oreFlylightRedstone", redstone);
		OreDictionary.registerOre("oreFlylightDiamond", diamond);
		OreDictionary.registerOre("oreFlylightCoal", coal);
		OreDictionary.registerOre("oreFlylightEmerald", emerald);
	}
}
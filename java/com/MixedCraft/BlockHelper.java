package com.MixedCraft;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.MixedCraft.blocks.*;
import com.MixedCraft.blocks.tileEntity.TileEntityDiamondFurnace;
import com.MixedCraft.handler.HelperHandler;
import com.MixedCraft.helper.BlocksBase;
import com.MixedCraft.helper.ConfigHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHelper extends HelperHandler{



	public static final Block Extractor 						= new BlockDNAExtractor().setName("Extractor");
	public static final Block Mixer 							= new BlockDNAMixer().setName("Mixer");
	public static final Block Assembler 						= new BlockMobAssembler().setName("Assembler");

	public static final Block CopperOre 						= new ModBlock().setName("CopperOre").setHardness(7.0F);
	public static final Block BigCrafting 						= new BiggerCraftingTable().setName("BigCraftingTable");
	public static final Block TinOre 							= new ModBlock().setName("TinOre").setHardness(7.0F);
	public static final Block CopperBlock 						= new ModBlock().setName("CopperBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);
	public static final Block TinBlock 							= new ModBlock().setName("TinBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);	
	public static final Block SilverBlock 						= new ModBlock().setName("SilverBlock").setHardness(7.0F).setStepSound(Block.soundTypeMetal);
	public static final Block SilverOre 						= new ModBlock().setName("SilverOre").setHardness(7.0F);	
	public static final Block SolarPanel 						= new BlockSolarPanel().setName("SolarPanel").setHardness(2.0F);
	public static final Block CowSheepWool 						= new ModBlock().setName("CowSheepWool").setHardness(0.2F).setStepSound(Block.soundTypeCloth);
	//public static final Block Disassembler 					 	= new Disassembler().setName("Disasembler");	
	public static final Block IronFurnaceOff 					= new BlockIronFurnace(false).setName("IronFurnaceOff");
	public static final Block IronFurnaceOn 					= new BlockIronFurnace(true).setName("IronFurnaceOn").setLightLevel(0.875F);
	public static final Block GoldDoor 							= new BlockGoldDoor(Material.wood).setName("GoldDoor").setCreativeTab(null);
	public static final Block Table 							= new BlockTable().setName("Table");
	public static final Block DiamondFurnaceOff 				= new BlockDiamondFurnace(false).setName("DiamondFurnaceOff");
	public static final Block DiamondFurnaceOn 					= new BlockDiamondFurnace(true).setName("DiamondFurnaceOn").setLightLevel(0.875F);

	public static final BlockFlylightPortal flylightPortal 		= (BlockFlylightPortal) new BlockFlylightPortal().setName("flylightPortal").setBlockUnbreakable();
	public static final Block flylightGrass 					= new BlockFlylightGrass().setName("flylightGrass").setStepSound(Block.soundTypeGrass);
	public static final Block flylightDirt 						= new ModDirt().setName("flylightDirt").setLightLevel(0.8F).setHardness(1.0F).setStepSound(Block.soundTypeGravel);
	public static final Block flylightStone 					= new ModBlock().setName("flylightStone").setHardness(3.0F).setLightLevel(0.6F).setStepSound(Block.soundTypeStone);
	public static final Block flylightOre 						= new ModBlock().setName("flylightOre").setLightLevel(0.6F).setHardness(3.0F).setStepSound(Block.soundTypeStone);
	public static final Block ModFire						    = new ModFire().setName("modFire");

	public static final Block flashing 							= new ModBlock().setName("flashing").setHardness(3.5F).setStepSound(Block.soundTypeMetal).setLightLevel(0.875F);
	//public static final Block House1 								= new BlockHouse1().setHardness(3.5F).setStepSound(Block.soundTypeMetal).setName("House1").setLightLevel(0.875F);
	public static final Block slowSand 							= new BlockSinkSand().setName("slowSand");

	public static final Block chocolateCake 					= new BlockChocolateCake().setName("chocolateCakeBlock");
	public static final Block chocolateCrop 					= new BlockChocolateCrop().setName("ChocolateCrop");

	public static final Block goldFurnaceOff 					= new GoldFurnace(false).setName("goldFurnace");
	public static final Block goldFurnaceOn 					= new GoldFurnace(true).setName("goldFurnaceOn");

	public static final Block flower1 							= new ModFlower().setName("cyanFlylightFlower");
	public static final Block flower2 							= new ModFlower().setName("blueFlylightFlower");
	public static final Block flylightLog 						= new ModLog().setName("flylightLog");
	public static final Block flylightLeaves 					= new ModLeaves().setName("flylightLeaves");
	public static final Block flylightFern 						= new ModTallGrass().setName("flylightFern");
	public static final Block FlylightTallGrass 				= new ModTallGrass().setName("flylightTallGrass");
	public static final Block flylightCane 						= new FlylightSugarCane().setName("flylightSugarCane");
	public static final Block flylightSapling 					= new FlylightSapling().setName("flylightSapling");
	public static final Block water 							= new ModWater().setName("flylightWater");
	public static final Block vine 								= new ModVine().setName("flylightVine");

	public static final Block iron 								= new ModOre().setName("ironOre");
	public static final Block gold 								= new ModOre().setName("goldOre");
	public static final Block lapis 							= new ModOre().setName("lapisOre");
	public static final Block redstone 							= new ModOre().setName("redstoneOre");
	public static final Block diamond 							= new ModOre().setName("diamondOre");
	public static final Block coal 								= new ModOre().setName("coalOre");
	public static final Block emerald 							= new ModOre().setName("emeraldOre"); 

	public static final Block poweredFurnace 					= new BlockPoweredFurnace(false).setName("powerFurnace");
	public static final Block poweredFurnaceOn				    = new BlockPoweredFurnace(true).setName("powerFurnaceOn");

	public static void addOres(){
		OreDictionary.registerOre("oreCopper", CopperOre);
		OreDictionary.registerOre("oreTin", TinOre);
		OreDictionary.registerOre("oreSilver", SilverOre);
		OreDictionary.registerOre("oreFlylightIron", iron);
		OreDictionary.registerOre("oreFlylightGold", gold);
		OreDictionary.registerOre("oreFlylightLapis", lapis);
		OreDictionary.registerOre("oreFlylightRedstone", redstone);
		OreDictionary.registerOre("oreFlylightDiamond", diamond);
		OreDictionary.registerOre("oreFlylightCoal", coal);
		OreDictionary.registerOre("oreFlylightEmerald", emerald);
	}
}
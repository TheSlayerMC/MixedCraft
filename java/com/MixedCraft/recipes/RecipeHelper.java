package com.MixedCraft.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.ItemHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {
	 
	public static void init(){
		Shaped();
		Shapeless();
		Smelting();
		BigShapedCrafting();
		BigShapelessCrafting();
	}
	
	private static ItemStack s;
	private static ItemStack b;
	
	public static void Shaped(){
		GameRegistry.addRecipe(new ItemStack(ItemHelper.FlashDrive, 1), new Object[] {" TT", "ICT", "II ", 'T', ItemHelper.TinIngot,'C', ItemHelper.CopperIngot, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.SolarPanel, 1), new Object[] {"TCT", "IRI", "III", 'T', ItemHelper.TinIngot,'C', ItemHelper.CopperIngot, 'I', Blocks.iron_block, 'R', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.GoldHandsaw, 1), new Object[] {"SSS", "GGS", "   ", 'S', Items.stick, 'G', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.DiamondHandsaw, 1), new Object[] {"SSS", "GGS", "   ", 'S', Items.stick, 'G', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.Extractor, 1), new Object[] {"CGC", "TWT", "CTC", 'T', ItemHelper.TinIngot, 'C', ItemHelper.CopperIngot, 'W', Blocks.crafting_table, 'G', ItemHelper.GoldHandsaw});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.Mixer, 1), new Object[] {"CEC", "TDT", "TET", 'T', Blocks.end_stone, 'C', ItemHelper.CopperIngot, 'D', Items.diamond, 'E', Items.ender_eye});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.Assembler, 1), new Object[] {"GDG", "IEI", "GIG", 'D', ItemHelper.DiamondHandsaw, 'G', Items.gold_ingot, 'E', Items.ender_pearl, 'I', Items.iron_ingot});

		GameRegistry.addRecipe(new ItemStack(ItemHelper.SilverAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.SilverHoe, 1), new Object[] {"II ", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.SilverPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.SilverShovel, 1), new Object[] {" I ", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.SilverSword, 1), new Object[] {" I ", " I ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.LightningArrow, 20), new Object[] {"D", "S", "F", 'D', Items.diamond,'S', Items.stick, 'F', Items.feather});

		GameRegistry.addRecipe(new ItemStack(ItemHelper.TNTArrow, 10), new Object[] {"D", "S", "F", 'D', Blocks.tnt,'S', Items.stick, 'F', Items.feather});
		
		GameRegistry.addRecipe(new ItemStack(BlockHelper.SilverBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.SilverIngot});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.TinBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.TinIngot});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.CopperBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.CopperIngot});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.BigCrafting, 1), new Object[] {"III", "III", "III", 'I', Blocks.crafting_table});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.IronFurnaceOff, 1), new Object[] {"III", "I I", "III", 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.DiamondFurnaceOff, 1), new Object[] {"III", "I I", "III", 'I', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.GoldDoor, 1), new Object[] {"II", "II", "II", 'I', Items.gold_ingot});

		GameRegistry.addRecipe(new ItemStack(ItemHelper.ChocolateCake, 1), new Object[] {"CCC", "ESE", "MMM", 'C', ItemHelper.ChocolateBean, 'E', Items.egg, 'M', Items.milk_bucket, 'S', Items.sugar});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.DiamondBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.IronBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.GoldBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.StoneBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.WoodBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Blocks.planks});

		s = new ItemStack(Items.skull);
		s.setItemDamage(1);
		
		b = new ItemStack(Items.dye);
		b.setItemDamage(15);
		
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandDeath, 1), new Object[] {"S", "I", "I", 'S', s, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandFire, 1), new Object[] {"S", "I", "I", 'S', Items.blaze_rod, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandGrowth, 1), new Object[] {"S", "I", "I", 'S', b, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandHarming, 1), new Object[] {"S", "I", "I", 'S', Items.redstone, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandHarvest, 1), new Object[] {"S", "I", "I", 'S', Items.diamond_hoe, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandHealing, 1), new Object[] {"S", "I", "I", 'S', Items.ghast_tear, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandIce, 1), new Object[] {"S", "I", "I", 'S', Blocks.ice, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandMissile, 1), new Object[] {"S", "B", "I", 'S', Items.arrow, 'B', Items.bow, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandMining, 1), new Object[] {"S", "I", "I", 'S', Items.diamond_pickaxe, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.wandTeleport, 1), new Object[] {"S", "I", "I", 'S', Items.ender_eye, 'I', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.Wand, 1), new Object[] {"S", "G", "I", 'S', Items.feather, 'I', Blocks.diamond_block, 'G', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(Blocks.furnace, 1), new Object[] {"SSS", "S S", "SSS", 'S', BlockHelper.flylightStone});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 16), new Object[] {"L", "L", 'L', BlockHelper.flylightLog});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.battery, 1, ItemHelper.battery.getMaxDamage()), new Object[] {"IRI", "IRI", "IRI", 'I', Items.iron_ingot, 'R', Items.redstone});

	}

	public static void BigShapedCrafting(){
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Items.bow, 1), new Object[] {" II", "I S", "I S", "I S", " II", 'I', Items.stick, 'S', Items.string});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.TNTBow, 1), new Object[] {" II", "I S", "I S", "I S", " II", 'I', Blocks.tnt, 'S', Items.string});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.LightningBow, 1), new Object[] {" II", "I S", "I S", "I S", " II", 'I', Items.diamond, 'S', Items.string});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.CopperBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.CopperIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.SilverBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.SilverIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.TinBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.TinIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.Table, 1), new Object[] {"III", "III", "I I", "I I", "I I", 'I',  Blocks.planks});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.LightningRod, 1), new Object[] {"DBD", "DBD", "DBD", "DBD", "DBD", 'B',  Items.blaze_rod, 'D', Items.diamond});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.FlameSword, 1), new Object[] {"PRP", "PRP", "PRP", "DBD", "PBP", 'B',  Items.blaze_rod, 'D', Items.diamond, 'P', Items.blaze_powder, 'R', Items.redstone});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Items.saddle, 1), new Object[] {" S ", "LLL", "LLL", "LLL", " S ", 'L', Items.leather, 'S', Items.string});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.ChocolateCake, 1), new Object[] {"CCC", "ESE", "MMM", 'C', ItemHelper.ChocolateBean, 'E', Items.egg, 'M', Items.milk_bucket, 'S', Items.sugar});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Blocks.diamond_block, 1), new Object[] {"III", "III", "III", 'I', Items.diamond});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Blocks.iron_block, 1), new Object[] {"III", "III", "III", 'I', Items.iron_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Blocks.gold_block, 1), new Object[] {"III", "III", "III", 'I', Items.gold_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Blocks.emerald_block, 1), new Object[] {"III", "III", "III", 'I', Items.emerald});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.DiamondBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.diamond});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.IronBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.iron_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.GoldBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Items.gold_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.StoneBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Blocks.cobblestone});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.WoodBigSword, 1), new Object[] {" DD", "DDD", "SD ", 'S', Items.stick, 'D', Blocks.planks});
	
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.FlashDrive, 1), new Object[] {" TT", "ICT", "II ", 'T', ItemHelper.TinIngot,'C', ItemHelper.CopperIngot, 'I', Items.iron_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.SolarPanel, 1), new Object[] {"TCT", "IRI", "III", 'T', ItemHelper.TinIngot,'C', ItemHelper.CopperIngot, 'I', Blocks.iron_block, 'R', Items.redstone});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.GoldHandsaw, 1), new Object[] {"SSS", "GGS", 'S', Items.stick, 'G', Items.gold_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.DiamondHandsaw, 1), new Object[] {"SSS", "GGS", 'S', Items.stick, 'G', Items.diamond});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.Extractor, 1), new Object[] {"CGC", "TWT", "CTC", 'T', ItemHelper.TinIngot, 'C', ItemHelper.CopperIngot, 'W', Blocks.crafting_table, 'G', ItemHelper.GoldHandsaw});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.Mixer, 1), new Object[] {"CEC", "TDT", "TET", 'T', Blocks.end_stone, 'C', ItemHelper.CopperIngot, 'D', Items.diamond, 'E', Items.ender_eye});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.Assembler, 1), new Object[] {"GDG", "IEI", "GIG", 'D', ItemHelper.DiamondHandsaw, 'G', Items.gold_ingot, 'E', Items.ender_pearl, 'I', Items.iron_ingot});

		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.SilverAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.SilverHoe, 1), new Object[] {"II ", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.SilverPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.SilverShovel, 1), new Object[] {" I ", " S ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.SilverSword, 1), new Object[] {" I ", " I ", " S ", 'I', ItemHelper.SilverIngot,'S', Items.stick});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.LightningArrow, 20), new Object[] {"D", "S", "F", 'D', Items.diamond,'S', Items.stick, 'F', Items.feather});
		
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.TNTArrow, 10), new Object[] {"D", "S", "F", 'D', Blocks.tnt,'S', Items.stick, 'F', Items.feather});
		
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.SilverBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.SilverIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.TinBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.TinIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.CopperBlock, 1), new Object[] {"III", "III", "III", 'I', ItemHelper.CopperIngot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.BigCrafting, 1), new Object[] {"III", "III", "III", 'I', Blocks.crafting_table});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.IronFurnaceOff, 1), new Object[] {"III", "I I", "III", 'I', Items.iron_ingot});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(BlockHelper.DiamondFurnaceOff, 1), new Object[] {"III", "I I", "III", 'I', Items.diamond});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.GoldDoor, 1), new Object[] {"II", "II", "II", 'I', Items.gold_ingot});
	
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandDeath, 1), new Object[] {"S", "I", "I", 'S', new ItemStack(Items.skull, 1, 1), 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandFire, 1), new Object[] {"S", "I", "I", 'S', Items.blaze_rod, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandGrowth, 1), new Object[] {"S", "I", "I", 'S', new ItemStack(Items.dye, 1, 15), 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandHarming, 1), new Object[] {"S", "I", "I", 'S', Items.redstone, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandHarvest, 1), new Object[] {"S", "I", "I", 'S', Items.diamond_hoe, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandHealing, 1), new Object[] {"S", "I", "I", 'S', Items.ghast_tear, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandIce, 1), new Object[] {"S", "I", "I", 'S', Blocks.ice, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandMissile, 1), new Object[] {"S", "B", "I", 'S', Items.arrow, 'B', Items.bow, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandMining, 1), new Object[] {"S", "I", "I", 'S', Items.diamond_pickaxe, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(ItemHelper.wandTeleport, 1), new Object[] {"S", "I", "I", 'S', Items.ender_eye, 'I', Blocks.gold_block});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Blocks.furnace, 1), new Object[] {"SSS", "S S", "SSS", 'S', BlockHelper.flylightStone});
		CraftingBigManager.getInstance().addShapedRecipe(new ItemStack(Items.stick, 16), new Object[] {"L", "L", 'L', BlockHelper.flylightLog});
	}

	public static void BigShapelessCrafting(){
		CraftingBigManager.getInstance().addShapelessRecipe(new ItemStack(Blocks.ice, 1), new Object[] {Items.water_bucket, Items.water_bucket, Items.water_bucket, Items.water_bucket});
		CraftingBigManager.getInstance().addShapelessRecipe(new ItemStack(ItemHelper.CopperIngot, 9), new Object[] {BlockHelper.CopperBlock});
		CraftingBigManager.getInstance().addShapelessRecipe(new ItemStack(ItemHelper.SilverIngot, 9), new Object[] {BlockHelper.SilverBlock});
		CraftingBigManager.getInstance().addShapelessRecipe(new ItemStack(ItemHelper.TinIngot, 9), new Object[] {BlockHelper.TinBlock});
		CraftingBigManager.getInstance().addShapelessRecipe(new ItemStack(ItemHelper.SilverShickaxe, 1), new Object[] {ItemHelper.SilverAxe, ItemHelper.SilverHoe, ItemHelper.SilverPickaxe, ItemHelper.SilverShovel, ItemHelper.SilverSword, Blocks.diamond_block});
	}

	public static void Shapeless(){
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ice, 1), new Object[] {Items.water_bucket, Items.water_bucket, Items.water_bucket, Items.water_bucket});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHelper.CopperIngot, 9), new Object[] {BlockHelper.CopperBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHelper.TinIngot, 9), new Object[] {BlockHelper.TinBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHelper.SilverIngot, 9), new Object[] {BlockHelper.SilverBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHelper.SilverShickaxe, 1), new Object[] {ItemHelper.SilverAxe, ItemHelper.SilverHoe, ItemHelper.SilverPickaxe, ItemHelper.SilverShovel, ItemHelper.SilverSword ,Blocks.diamond_block});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHelper.ChocolateBean, 1), new Object[] {new ItemStack(Items.wheat_seeds, 1), new ItemStack(Items.dye, 1, 3)});

	}

	public static void Smelting(){
		GameRegistry.addSmelting(BlockHelper.SilverOre, new ItemStack(ItemHelper.SilverIngot, 1), 0);
		GameRegistry.addSmelting(BlockHelper.TinOre, new ItemStack(ItemHelper.TinIngot, 1), 0);
		GameRegistry.addSmelting(BlockHelper.CopperOre, new ItemStack(ItemHelper.CopperIngot, 1), 0);
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather, 1), 0);
		GameRegistry.addSmelting(BlockHelper.iron, new ItemStack(Items.iron_ingot, 1), 0);
		GameRegistry.addSmelting(BlockHelper.flylightLog, new ItemStack(Items.coal, 1), 0);
	}
}
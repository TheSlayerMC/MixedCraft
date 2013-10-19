package com.MixedCraft.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.MixedCraft.recipes.modded.RecipeFireworks;
import com.MixedCraft.recipes.modded.RecipesArmor;
import com.MixedCraft.recipes.modded.RecipesArmorDyes;
import com.MixedCraft.recipes.modded.RecipesCrafting;
import com.MixedCraft.recipes.modded.RecipesDyes;
import com.MixedCraft.recipes.modded.RecipesFood;
import com.MixedCraft.recipes.modded.RecipesIngots;
import com.MixedCraft.recipes.modded.RecipesMapCloning;
import com.MixedCraft.recipes.modded.RecipesMapExtending;
import com.MixedCraft.recipes.modded.RecipesTools;
import com.MixedCraft.recipes.modded.RecipesWeapons;

public class CraftingBigManager
{
	private static final CraftingBigManager instance = new CraftingBigManager();

	private List recipes = new ArrayList();

	public static final CraftingBigManager getInstance()
	{
	         return instance;
	}

	private CraftingBigManager()
	{
		(new RecipesTools()).addRecipes(this);
        (new RecipesWeapons()).addRecipes(this);
        (new RecipesIngots()).addRecipes(this);
        (new RecipesFood()).addRecipes(this);
        (new RecipesCrafting()).addRecipes(this);
        (new RecipesArmor()).addRecipes(this);
        (new RecipesDyes()).addRecipes(this);
        this.recipes.add(new RecipesArmorDyes());
        this.recipes.add(new RecipesMapCloning());
        this.recipes.add(new RecipesMapExtending());
        this.recipes.add(new RecipeFireworks());
        this.addShapedRecipe(new ItemStack(Item.paper, 3), new Object[] {"###", '#', Item.reed});
        this.addShapelessRecipe(new ItemStack(Item.book, 1), new Object[] {Item.paper, Item.paper, Item.paper, Item.leather});
        this.addShapelessRecipe(new ItemStack(Item.writableBook, 1), new Object[] {Item.book, new ItemStack(Item.dyePowder, 1, 0), Item.feather});
        this.addShapedRecipe(new ItemStack(Block.fence, 2), new Object[] {"###", "###", '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.cobblestoneWall, 6, 0), new Object[] {"###", "###", '#', Block.cobblestone});
        this.addShapedRecipe(new ItemStack(Block.cobblestoneWall, 6, 1), new Object[] {"###", "###", '#', Block.cobblestoneMossy});
        this.addShapedRecipe(new ItemStack(Block.netherFence, 6), new Object[] {"###", "###", '#', Block.netherBrick});
        this.addShapedRecipe(new ItemStack(Block.fenceGate, 1), new Object[] {"#W#", "#W#", '#', Item.stick, 'W', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.jukebox, 1), new Object[] {"###", "#X#", "###", '#', Block.planks, 'X', Item.diamond});
        this.addShapedRecipe(new ItemStack(Item.leash, 2), new Object[] {"~~ ", "~O ", "  ~", '~', Item.silk, 'O', Item.slimeBall});
        this.addShapedRecipe(new ItemStack(Block.music, 1), new Object[] {"###", "#X#", "###", '#', Block.planks, 'X', Item.redstone});
        this.addShapedRecipe(new ItemStack(Block.bookShelf, 1), new Object[] {"###", "XXX", "###", '#', Block.planks, 'X', Item.book});
        this.addShapedRecipe(new ItemStack(Block.blockSnow, 1), new Object[] {"##", "##", '#', Item.snowball});
        this.addShapedRecipe(new ItemStack(Block.snow, 6), new Object[] {"###", '#', Block.blockSnow});
        this.addShapedRecipe(new ItemStack(Block.blockClay, 1), new Object[] {"##", "##", '#', Item.clay});
        this.addShapedRecipe(new ItemStack(Block.brick, 1), new Object[] {"##", "##", '#', Item.brick});
        this.addShapedRecipe(new ItemStack(Block.glowStone, 1), new Object[] {"##", "##", '#', Item.glowstone});
        this.addShapedRecipe(new ItemStack(Block.blockNetherQuartz, 1), new Object[] {"##", "##", '#', Item.netherQuartz});
        this.addShapedRecipe(new ItemStack(Block.cloth, 1), new Object[] {"##", "##", '#', Item.silk});
        this.addShapedRecipe(new ItemStack(Block.tnt, 1), new Object[] {"X#X", "#X#", "X#X", 'X', Item.gunpowder, '#', Block.sand});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 3), new Object[] {"###", '#', Block.cobblestone});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 0), new Object[] {"###", '#', Block.stone});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 1), new Object[] {"###", '#', Block.sandStone});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 4), new Object[] {"###", '#', Block.brick});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 5), new Object[] {"###", '#', Block.stoneBrick});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 6), new Object[] {"###", '#', Block.netherBrick});
        this.addShapedRecipe(new ItemStack(Block.stoneSingleSlab, 6, 7), new Object[] {"###", '#', Block.blockNetherQuartz});
        this.addShapedRecipe(new ItemStack(Block.woodSingleSlab, 6, 0), new Object[] {"###", '#', new ItemStack(Block.planks, 1, 0)});
        this.addShapedRecipe(new ItemStack(Block.woodSingleSlab, 6, 2), new Object[] {"###", '#', new ItemStack(Block.planks, 1, 2)});
        this.addShapedRecipe(new ItemStack(Block.woodSingleSlab, 6, 1), new Object[] {"###", '#', new ItemStack(Block.planks, 1, 1)});
        this.addShapedRecipe(new ItemStack(Block.woodSingleSlab, 6, 3), new Object[] {"###", '#', new ItemStack(Block.planks, 1, 3)});
        this.addShapedRecipe(new ItemStack(Block.ladder, 3), new Object[] {"# #", "###", "# #", '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Item.doorWood, 1), new Object[] {"##", "##", "##", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.trapdoor, 2), new Object[] {"###", "###", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Item.doorIron, 1), new Object[] {"##", "##", "##", '#', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Item.sign, 3), new Object[] {"###", "###", " X ", '#', Block.planks, 'X', Item.stick});
        this.addShapedRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', Item.egg});
        this.addShapedRecipe(new ItemStack(Item.sugar, 1), new Object[] {"#", '#', Item.reed});
        this.addShapedRecipe(new ItemStack(Block.planks, 4, 0), new Object[] {"#", '#', new ItemStack(Block.wood, 1, 0)});
        this.addShapedRecipe(new ItemStack(Block.planks, 4, 1), new Object[] {"#", '#', new ItemStack(Block.wood, 1, 1)});
        this.addShapedRecipe(new ItemStack(Block.planks, 4, 2), new Object[] {"#", '#', new ItemStack(Block.wood, 1, 2)});
        this.addShapedRecipe(new ItemStack(Block.planks, 4, 3), new Object[] {"#", '#', new ItemStack(Block.wood, 1, 3)});
        this.addShapedRecipe(new ItemStack(Item.stick, 4), new Object[] {"#", "#", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.torchWood, 4), new Object[] {"X", "#", 'X', Item.coal, '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.torchWood, 4), new Object[] {"X", "#", 'X', new ItemStack(Item.coal, 1, 1), '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Item.bowlEmpty, 4), new Object[] {"# #", " # ", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Item.glassBottle, 3), new Object[] {"# #", " # ", '#', Block.glass});
        this.addShapedRecipe(new ItemStack(Block.rail, 16), new Object[] {"X X", "X#X", "X X", 'X', Item.ingotIron, '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.railPowered, 6), new Object[] {"X X", "X#X", "XRX", 'X', Item.ingotGold, 'R', Item.redstone, '#', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.railActivator, 6), new Object[] {"XSX", "X#X", "XSX", 'X', Item.ingotIron, '#', Block.torchRedstoneActive, 'S', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.railDetector, 6), new Object[] {"X X", "X#X", "XRX", 'X', Item.ingotIron, 'R', Item.redstone, '#', Block.pressurePlateStone});
        this.addShapedRecipe(new ItemStack(Item.minecartEmpty, 1), new Object[] {"# #", "###", '#', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Item.cauldron, 1), new Object[] {"# #", "# #", "###", '#', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Item.brewingStand, 1), new Object[] {" B ", "###", '#', Block.cobblestone, 'B', Item.blazeRod});
        this.addShapedRecipe(new ItemStack(Block.pumpkinLantern, 1), new Object[] {"A", "B", 'A', Block.pumpkin, 'B', Block.torchWood});
        this.addShapedRecipe(new ItemStack(Item.minecartCrate, 1), new Object[] {"A", "B", 'A', Block.chest, 'B', Item.minecartEmpty});
        this.addShapedRecipe(new ItemStack(Item.minecartPowered, 1), new Object[] {"A", "B", 'A', Block.furnaceIdle, 'B', Item.minecartEmpty});
        this.addShapedRecipe(new ItemStack(Item.minecartTnt, 1), new Object[] {"A", "B", 'A', Block.tnt, 'B', Item.minecartEmpty});
        this.addShapedRecipe(new ItemStack(Item.minecartHopper, 1), new Object[] {"A", "B", 'A', Block.hopperBlock, 'B', Item.minecartEmpty});
        this.addShapedRecipe(new ItemStack(Item.boat, 1), new Object[] {"# #", "###", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Item.bucketEmpty, 1), new Object[] {"# #", " # ", '#', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Item.flowerPot, 1), new Object[] {"# #", " # ", '#', Item.brick});
        this.addShapedRecipe(new ItemStack(Item.flintAndSteel, 1), new Object[] {"A ", " B", 'A', Item.ingotIron, 'B', Item.flint});
        this.addShapedRecipe(new ItemStack(Item.bread, 1), new Object[] {"###", '#', Item.wheat});
        this.addShapedRecipe(new ItemStack(Block.stairsWoodOak, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Block.planks, 1, 0)});
        this.addShapedRecipe(new ItemStack(Block.stairsWoodBirch, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Block.planks, 1, 2)});
        this.addShapedRecipe(new ItemStack(Block.stairsWoodSpruce, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Block.planks, 1, 1)});
        this.addShapedRecipe(new ItemStack(Block.stairsWoodJungle, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Block.planks, 1, 3)});
        this.addShapedRecipe(new ItemStack(Item.fishingRod, 1), new Object[] {"  #", " #X", "# X", '#', Item.stick, 'X', Item.silk});
        this.addShapedRecipe(new ItemStack(Item.carrotOnAStick, 1), new Object[] {"# ", " X", '#', Item.fishingRod, 'X', Item.carrot}).func_92100_c();
        this.addShapedRecipe(new ItemStack(Block.stairsCobblestone, 4), new Object[] {"#  ", "## ", "###", '#', Block.cobblestone});
        this.addShapedRecipe(new ItemStack(Block.stairsBrick, 4), new Object[] {"#  ", "## ", "###", '#', Block.brick});
        this.addShapedRecipe(new ItemStack(Block.stairsStoneBrick, 4), new Object[] {"#  ", "## ", "###", '#', Block.stoneBrick});
        this.addShapedRecipe(new ItemStack(Block.stairsNetherBrick, 4), new Object[] {"#  ", "## ", "###", '#', Block.netherBrick});
        this.addShapedRecipe(new ItemStack(Block.stairsSandStone, 4), new Object[] {"#  ", "## ", "###", '#', Block.sandStone});
        this.addShapedRecipe(new ItemStack(Block.stairsNetherQuartz, 4), new Object[] {"#  ", "## ", "###", '#', Block.blockNetherQuartz});
        this.addShapedRecipe(new ItemStack(Item.painting, 1), new Object[] {"###", "#X#", "###", '#', Item.stick, 'X', Block.cloth});
        this.addShapedRecipe(new ItemStack(Item.itemFrame, 1), new Object[] {"###", "#X#", "###", '#', Item.stick, 'X', Item.leather});
        this.addShapedRecipe(new ItemStack(Item.appleGold, 1, 0), new Object[] {"###", "#X#", "###", '#', Item.ingotGold, 'X', Item.appleRed});
        this.addShapedRecipe(new ItemStack(Item.appleGold, 1, 1), new Object[] {"###", "#X#", "###", '#', Block.blockGold, 'X', Item.appleRed});
        this.addShapedRecipe(new ItemStack(Item.goldenCarrot, 1, 0), new Object[] {"###", "#X#", "###", '#', Item.goldNugget, 'X', Item.carrot});
        this.addShapedRecipe(new ItemStack(Item.speckledMelon, 1), new Object[] {"###", "#X#", "###", '#', Item.goldNugget, 'X', Item.melon});
        this.addShapedRecipe(new ItemStack(Block.lever, 1), new Object[] {"X", "#", '#', Block.cobblestone, 'X', Item.stick});
        this.addShapedRecipe(new ItemStack(Block.tripWireSource, 2), new Object[] {"I", "S", "#", '#', Block.planks, 'S', Item.stick, 'I', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Block.torchRedstoneActive, 1), new Object[] {"X", "#", '#', Item.stick, 'X', Item.redstone});
        this.addShapedRecipe(new ItemStack(Item.redstoneRepeater, 1), new Object[] {"#X#", "III", '#', Block.torchRedstoneActive, 'X', Item.redstone, 'I', Block.stone});
        this.addShapedRecipe(new ItemStack(Item.comparator, 1), new Object[] {" # ", "#X#", "III", '#', Block.torchRedstoneActive, 'X', Item.netherQuartz, 'I', Block.stone});
        this.addShapedRecipe(new ItemStack(Item.pocketSundial, 1), new Object[] {" # ", "#X#", " # ", '#', Item.ingotGold, 'X', Item.redstone});
        this.addShapedRecipe(new ItemStack(Item.compass, 1), new Object[] {" # ", "#X#", " # ", '#', Item.ingotIron, 'X', Item.redstone});
        this.addShapedRecipe(new ItemStack(Item.emptyMap, 1), new Object[] {"###", "#X#", "###", '#', Item.paper, 'X', Item.compass});
        this.addShapedRecipe(new ItemStack(Block.stoneButton, 1), new Object[] {"#", '#', Block.stone});
        this.addShapedRecipe(new ItemStack(Block.woodenButton, 1), new Object[] {"#", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.pressurePlateStone, 1), new Object[] {"##", '#', Block.stone});
        this.addShapedRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] {"##", '#', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.pressurePlateIron, 1), new Object[] {"##", '#', Item.ingotIron});
        this.addShapedRecipe(new ItemStack(Block.pressurePlateGold, 1), new Object[] {"##", '#', Item.ingotGold});
        this.addShapedRecipe(new ItemStack(Block.dispenser, 1), new Object[] {"###", "#X#", "#R#", '#', Block.cobblestone, 'X', Item.bow, 'R', Item.redstone});
        this.addShapedRecipe(new ItemStack(Block.dropper, 1), new Object[] {"###", "# #", "#R#", '#', Block.cobblestone, 'R', Item.redstone});
        this.addShapedRecipe(new ItemStack(Block.pistonBase, 1), new Object[] {"TTT", "#X#", "#R#", '#', Block.cobblestone, 'X', Item.ingotIron, 'R', Item.redstone, 'T', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.pistonStickyBase, 1), new Object[] {"S", "P", 'S', Item.slimeBall, 'P', Block.pistonBase});
        this.addShapedRecipe(new ItemStack(Item.bed, 1), new Object[] {"###", "XXX", '#', Block.cloth, 'X', Block.planks});
        this.addShapedRecipe(new ItemStack(Block.enchantmentTable, 1), new Object[] {" B ", "D#D", "###", '#', Block.obsidian, 'B', Item.book, 'D', Item.diamond});
        this.addShapedRecipe(new ItemStack(Block.anvil, 1), new Object[] {"III", " i ", "iii", 'I', Block.blockIron, 'i', Item.ingotIron});
        this.addShapelessRecipe(new ItemStack(Item.eyeOfEnder, 1), new Object[] {Item.enderPearl, Item.blazePowder});
        this.addShapelessRecipe(new ItemStack(Item.fireballCharge, 3), new Object[] {Item.gunpowder, Item.blazePowder, Item.coal});
        this.addShapelessRecipe(new ItemStack(Item.fireballCharge, 3), new Object[] {Item.gunpowder, Item.blazePowder, new ItemStack(Item.coal, 1, 1)});
        this.addShapedRecipe(new ItemStack(Block.daylightSensor), new Object[] {"GGG", "QQQ", "WWW", 'G', Block.glass, 'Q', Item.netherQuartz, 'W', Block.woodSingleSlab});
        this.addShapedRecipe(new ItemStack(Block.hopperBlock), new Object[] {"I I", "ICI", " I ", 'I', Item.ingotIron, 'C', Block.chest});
		
		Collections.sort(this.recipes, new RecipeSorterBig(this));
		
		System.out.println(this.recipes.size() + " recipes");
	}

	public BigShapedRecipes addShapedRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;

		if (par2ArrayOfObj[var4] instanceof String[])
		{
			String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

			for (int var8 = 0; var8 < var7.length; ++var8)
			{
				String var9 = var7[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		}
		else
		{
			while (par2ArrayOfObj[var4] instanceof String)
			{
				String var11 = (String)par2ArrayOfObj[var4++];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}

		HashMap var12;

		for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
		{
			Character var13 = (Character)par2ArrayOfObj[var4];
			ItemStack var14 = null;

			if (par2ArrayOfObj[var4 + 1] instanceof Item)
			{
				var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof Block)
			{
				var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
			{
				var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
			}

			var12.put(var13, var14);
		}

		ItemStack[] var15 = new ItemStack[var5 * var6];

		for (int var16 = 0; var16 < var5 * var6; ++var16)
		{
			char var10 = var3.charAt(var16);

			if (var12.containsKey(Character.valueOf(var10)))
			{
				var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
			}
			else
			{
				var15[var16] = null;
			}
		}

		BigShapedRecipes var17 = new BigShapedRecipes(var5, var6, var15, par1ItemStack);
		this.recipes.add(var17);
		return var17;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		ArrayList var3 = new ArrayList();
		Object[] var4 = par2ArrayOfObj;
		int var5 = par2ArrayOfObj.length;

		for (int var6 = 0; var6 < var5; ++var6)
		{
			Object var7 = var4[var6];

			if (var7 instanceof ItemStack)
			{
				var3.add(((ItemStack)var7).copy());
			}
			else if (var7 instanceof Item)
			{
				var3.add(new ItemStack((Item)var7));
			}
			else
			{
				if (!(var7 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				var3.add(new ItemStack((Block)var7));
			}
		}

		this.recipes.add(new BigShapelessRecipes(par1ItemStack, var3));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
	{
		int var3 = 0;
		ItemStack var4 = null;
		ItemStack var5 = null;
		int var6;

		for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
		{
			ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

			if (var7 != null)
			{
				if (var3 == 0)
				{
					var4 = var7;
				}

				if (var3 == 1)
				{
					var5 = var7;
				}

				++var3;
			}
		}

		if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
		{
			Item var11 = Item.itemsList[var4.itemID];
			int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
			int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
			int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
			int var10 = var11.getMaxDamage() - var9;

			if (var10 < 0)
			{
				var10 = 0;
			}

			return new ItemStack(var4.itemID, 1, var10);
		}
		else
		{
			for (var6 = 0; var6 < this.recipes.size(); ++var6)
			{
				IRecipe var12 = (IRecipe)this.recipes.get(var6);

				if (var12.matches(par1InventoryCrafting, par2World))
				{
					return var12.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	public List getRecipeList()
	{
		return this.recipes;
	}
}
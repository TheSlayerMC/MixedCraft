package com.MixedCraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WandOfMining extends ItemBaseWand {

	public static int defaultCharges = 64;

	public WandOfMining() {
		this.setMaxDamage(defaultCharges + 1);
	}

	@Override 
	public int getUseCost() {
		return 1;
	}

	@Override 
	public int getBaseRepairCost() {
		return 5;
	}
	
	@Override 
	public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int targetX, int targetY, int targetZ, int par7, float par8, float par9, float par10) {
		if (!playerEntity.capabilities.isCreativeMode) {
			if (isOutOfCharge(srcItemStack)) {
				playSound(noChargeAttackSound, world, playerEntity);
				return true;
			}
		}

		boolean success = mineBlock(playerEntity, world, targetX, targetY,
				targetZ);
		if (success) {
			if (!playerEntity.capabilities.isCreativeMode) {
				srcItemStack.damageItem(getUseCost(), playerEntity);
			}
		}

		for (int y = targetY + 1; y >= targetY - 1; y--) {
			if (y < 0)
				continue;
			for (int x = targetX - 1; x <= targetX + 1; x++) {
				for (int z = targetZ - 1; z <= targetZ + 1; z++) {
					canHarvest(world, x, y, z);
				}
			}
		}
		return true;

	}

	protected boolean mineBlock(EntityPlayer playerEntity, World world, int targetX, int targetY, int targetZ) {
		Block target = world.getBlock(targetX, targetY, targetZ);
		if (target == Blocks.bedrock) {
			return false;
		}
		int targetMeta = world.getBlockMetadata(targetX, targetY, targetZ);
		Block target2;

		/*if (target > 0) {
			target = Block.blocksList[target];
		} else {
			return false;
		}*/

		if (Items.diamond_pickaxe.canHarvestBlock(target, null)
				|| target.getBlockHardness(world, targetX, targetY, targetZ) < 0.0F
				|| Items.diamond_shovel.canHarvestBlock(target, null)
				|| Items.diamond_axe.canHarvestBlock(target, null)) {

			world.func_147480_a(targetX, targetY, targetZ, true);
			return true;
		}
		return false;

	}

	protected void canHarvest(World world, int x, int y, int z) {
		if (isHarvestable(world, x, y, z)) {
			world.func_147480_a(y, x, z, true);
		}
	}

	protected boolean isHarvestable(World w, int x, int y, int z) {
		Material mat = w.getBlock(x, y, z).getMaterial();
		return mat == Material.rock;
	}
}

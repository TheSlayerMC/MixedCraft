package com.MixedCraft.blocks;

import java.util.Random;

import com.MixedCraft.api.blocks.BlockModFlower;
import com.MixedCraft.gen.WorldGenFlylightTree;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockFlylightSapling extends BlockModFlower {

	public BlockFlylightSapling(String name) {
		super(name);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.isRemote) {
			return;
		}
		super.updateTick(world, i, j, k, random);
		if (world.getBlockLightValue(i, j + 1, k) >= 9
				&& random.nextInt(7) == 0) {
			growTree(world, i, j, k, random);
		}
	}

	public void growTree(World world, int i, int j, int k, Random random) {
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, null);
		Object obj = null;
		if (l == 1) {
			obj = new WorldGenFlylightTree(true);
		} else if (l == 2) {
			obj = new WorldGenFlylightTree(true);
		} else {
			obj = new WorldGenFlylightTree(true);
			if (random.nextInt(10) == 0) {
				obj = new WorldGenFlylightTree(false);
			}
		}
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
			world.setBlock(i, j, k, this, l, 4);
			;
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5) {
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null) {
			return false;
		}
		return false;
	}
}
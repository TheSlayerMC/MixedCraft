package com.MixedCraft.api.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.IdentityHashMap;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.helper.Utils;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFire extends BlockFire {
	
	public BlockModFire(String name) {
		GameRegistry.registerBlock(this, name);
        setBlockName(name);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		if(world.provider.dimensionId > 0 || !BlockHelper.flylightPortal.func_150000_e(world, x, y, z)) {
			if(!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
				world.setBlockToAir(x, y, z);
			} else {
				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
			}
		}
	}
}
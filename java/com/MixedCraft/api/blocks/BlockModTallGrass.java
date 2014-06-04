package com.MixedCraft.api.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class BlockModTallGrass extends BlockModFlower implements IShearable {

    public BlockModTallGrass(String name) {
    	super(name);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 1 + par2Random.nextInt(par1 * 2 + 1);
    }

    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if (world.rand.nextInt(8) != 0)
        {
            return ret;
        }

        ItemStack item = ForgeHooks.getGrassSeed(world);
        if (item != null)
        {
            ret.add(item);
        }
        return ret;
    }

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
        return ret;
	}
}

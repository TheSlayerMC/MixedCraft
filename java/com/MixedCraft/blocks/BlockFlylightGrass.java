package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockFlylightGrass extends BlocksBase {

    public BlockFlylightGrass() {
        super(Material.grass);
        this.setTickRandomly(true);
        this.registerTexture("flylightGrass_Side", "flylightGrass_Top", "flylightGrass_Bottom");
        setHardness(1.5F); setLightLevel(0.7F);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, BlockHelper.flylightDirt);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;

                    if (par1World.getBlock(i1, j1, k1) == BlockHelper.flylightDirt && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, BlockHelper.flylightGrass);
                    }
                }
            }
        }
    }
    
    public Block setName(String name) {
        GameRegistry.registerBlock(this, name);
        setBlockName(name);                 
        return this;
    }

    
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
    	return true;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return BlockHelper.flylightDirt.getItemDropped(par1, par2Random, par3);
    }
    
}

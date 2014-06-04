package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlylightSugarCane extends BlocksBase implements IPlantable {
	
    public BlockFlylightSugarCane(String name) {
        super(Material.plants, name);
        float f = 0.375F;
        setCreativeTab(MixedCraft.BlockTab);
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.isAirBlock(par2, par3 + 1, par4))
        {
            int l;

            for (l = 1; par1World.getBlock(par2, par3 - l, par4) == this; ++l)
            {
                ;
            }

            if (l < 3)
            {
                int i1 = par1World.getBlockMetadata(par2, par3, par4);

                if (i1 == 15)
                {
                    par1World.setBlock(par2, par3 + 1, par4, this);
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
                }
                else
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 + 1, 4);
                }
            }
        }
    }
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        Block block = par1World.getBlock(par2, par3 - 1, par4);
        return (block != null && block.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        this.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Items.reeds;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public Item getItem(World par1World, int par2, int par3, int par4)
    {
        return Items.reeds;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Beach;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return this;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
}

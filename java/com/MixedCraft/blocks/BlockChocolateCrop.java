package com.MixedCraft.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.MixedCraft.ItemHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.api.blocks.BlockModFlower;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChocolateCrop extends BlockModFlower implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon[] IIconArray;

    public BlockChocolateCrop(String name) {
        super(name);
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab(null);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
    }

    protected boolean canPlaceBlockOn(Block par1)
    {
        return par1 == Blocks.farmland;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 7)
            {
                float f = this.getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float f = 1.0F;
        Block block = par1World.getBlock(par2, par3, par4 - 1);
        Block block1 = par1World.getBlock(par2, par3, par4 + 1);
        Block block2 = par1World.getBlock(par2 - 1, par3, par4);
        Block block3 = par1World.getBlock(par2 + 1, par3, par4);
        Block block4 = par1World.getBlock(par2 - 1, par3, par4 - 1);
        Block block5 = par1World.getBlock(par2 + 1, par3, par4 - 1);
        Block block6 = par1World.getBlock(par2 + 1, par3, par4 + 1);
        Block block7 = par1World.getBlock(par2 - 1, par3, par4 + 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

        for (int l = par2 - 1; l <= par2 + 1; ++l)
        {
            for (int i1 = par4 - 1; i1 <= par4 + 1; ++i1)
            {
                float f1 = 0.0F;

                if (par1World.getBlock(l, par3 - 1, i1).canSustainPlant(par1World, l, par3 - 1, i1, ForgeDirection.UP, this))
                {
                    f1 = 1.0F;

                    if (par1World.getBlock(l, par3 - 1, i1).isFertile(par1World, l, par3 - 1, i1))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l != par2 || i1 != par4)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 7)
        {
            par2 = 7;
        }

        return this.IIconArray[par2];
    }

    protected Item getSeedItem() {
        return ItemHelper.ChocolateBean;
    }

    protected Item getCropItem() {
    	return ItemHelper.ChocolateBean;
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override 
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

        if (metadata >= 7)
        {
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(this.getSeedItem(), 1, 0));
                }
            }
        }

        return ret;
    }

    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return par1 == 7 ? this.getCropItem() : this.getSeedItem();
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World par1World, int par2, int par3, int par4)
    {
        return this.getSeedItem();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IIconRegister)
    {
        this.IIconArray = new IIcon[8];

        for (int i = 0; i < this.IIconArray.length; ++i)
        {
            this.IIconArray[i] = par1IIconRegister.registerIcon(Utils.MOD_ID + ":" + "ChocolateCrop_" + i);
        }
    }

	@Override
	public boolean func_149851_a(World var1, int var2, int var3, int var4, boolean var5) {
		 return var1.getBlockMetadata(var2, var3, var4) != 7;
	}

	@Override
	public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5) {
		return true;
	}

	@Override
	public void func_149853_b(World var1, Random var2, int var3, int var4, int var5) {
		this.fertilize(var1, var3, var4, var5);
	}
}

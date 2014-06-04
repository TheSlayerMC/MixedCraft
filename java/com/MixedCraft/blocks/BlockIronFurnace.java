package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.container.BlockModContainer;
import com.MixedCraft.blocks.tileEntity.TileEntityIronFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIronFurnace extends BlockModContainer
{
    /**
     * Is the random generator used by IronFurnace to drop the inventory contents in random directions.
     */
    private final Random IronFurnaceRand = new Random();

    /** True if this is an active IronFurnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the IronFurnace inventory to be dropped upon block removal, is used internally when the
     * IronFurnace block changes from idle to active and vice-versa.
     */
    private static boolean keepIronFurnaceInventory;
    @SideOnly(Side.CLIENT)
    private IIcon IronFurnaceIIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon IronFurnaceIIconFront;

    public BlockIronFurnace(boolean par2, String name)
    {
        super(Material.rock, name);
        this.isActive = par2;
        setHardness(3.5F);
        setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(BlockHelper.ironFurnace);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			Block block = par1World.getBlock(par2, par3, par4 - 1);
            Block block1 = par1World.getBlock(par2, par3, par4 + 1);
            Block block2 = par1World.getBlock(par2 - 1, par3, par4);
            Block block3 = par1World.getBlock(par2 + 1, par3, par4);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.IronFurnaceIIconTop : (par1 == 0 ? this.IronFurnaceIIconTop : (par1 != par2 ? this.blockIcon : this.IronFurnaceIIconFront));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the IIcons it needs with the given IIconRegister. This
     * is the only chance you get to register IIcons.
     */
    public void registerBlockIcons(IIconRegister par1IIconRegister)
    {
        this.blockIcon = par1IIconRegister.registerIcon("MixedCraft:IronFurnace");
        this.IronFurnaceIIconFront = par1IIconRegister.registerIcon(this.isActive ? "MixedCraft:IronFurnaceFront_On" : "MixedCraft:IronFurnaceFront_Off");
        this.IronFurnaceIIconTop = par1IIconRegister.registerIcon("MixedCraft:IronFurnace");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
    {
            if (!player.isSneaking())
            { 
                    player.openGui(MixedCraft.instance, 1, var1, var2, var3, var4);
                    return true;
            }
            else
            {
                    return false;
            }
    }

    /**
     * Update which block ID the IronFurnace is using depending on whether or not it is burning
     */
    public static void updateIronFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepIronFurnaceInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, BlockHelper.ironFurnaceOn);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, BlockHelper.ironFurnace);
        }

        keepIronFurnaceInventory = true;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.isActive)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World, int i) {
        return new TileEntityIronFurnace();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityIronFurnace)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        if (!keepIronFurnaceInventory)
        {
            TileEntityIronFurnace tileentityIronFurnace = (TileEntityIronFurnace)par1World.getTileEntity(par2, par3, par4);

            if (tileentityIronFurnace != null)
            {
                for (int j1 = 0; j1 < tileentityIronFurnace.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityIronFurnace.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.IronFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.IronFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.IronFurnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.IronFurnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.IronFurnaceRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.IronFurnaceRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.IronFurnaceRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public Item getItem(World par1World, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(BlockHelper.ironFurnace);
    }
}

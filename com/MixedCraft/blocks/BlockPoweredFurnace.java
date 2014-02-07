package com.MixedCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.blocks.tileEntity.TileEntityPowerFurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPoweredFurnace extends BlockContainer
{
    /**
     * Is the random generator used by PowerFurnace to drop the inventory contents in random directions.
     */
    private final Random PowerFurnaceRand = new Random();

    /** True if this is an active PowerFurnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the PowerFurnace inventory to be dropped upon block removal, is used internally when the
     * PowerFurnace block changes from idle to active and vice-versa.
     */
    private static boolean keepPowerFurnaceInventory;
    @SideOnly(Side.CLIENT)
    private IIcon PowerFurnaceIIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon PowerFurnaceIIconFront;

    public BlockPoweredFurnace(int par1, boolean par2)
    {
        super(Material.rock);
        this.isActive = par2;
        if(!par2){
        	setCreativeTab(MixedCraft.BlockTab);
        	setUnlocalizedName("Power Furnace");
        }else{
        	setCreativeTab(null);
        	setUnlocalizedName("Power Furnace On");
        }
    }
    
    public int idDropped(int par1, Random par2Random, int par3) {
        return BlockHelper.PoweredFurnace;
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
    
    private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote) {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIIcon(int par1, int par2)  {
        return par1 == 1 ? this.PowerFurnaceIIconTop : (par1 == 0 ? this.PowerFurnaceIIconTop : (par1 != par2 ? this.blockIcon : this.PowerFurnaceIIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("MixedCraft:PowerFurnace");
        this.PowerFurnaceIIconFront = par1IIconRegister.registerIcon(this.isActive ? "MixedCraft:PowerFurnaceFront_On" : "MixedCraft:PowerFurnaceFront_Off");
        this.PowerFurnaceIIconTop = par1IIconRegister.registerIcon("MixedCraft:PowerFurnace");
    }

    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
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

    public static void updatePowerFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
        keepPowerFurnaceInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, BlockHelper.PoweredFurnaceOn);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, BlockHelper.PoweredFurnace);
        }

        keepPowerFurnaceInventory = true;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }

   /* @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
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
    }*/

    public TileEntity createNewTileEntity(World par1World) {
        return new TileEntityPowerFurnace();
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName()) {
            ((TileEntityPowerFurnace)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        if (!keepPowerFurnaceInventory)
        {
            TileEntityPowerFurnace tileentityPowerFurnace = (TileEntityPowerFurnace)par1World.getBlockTileEntity(par2, par3, par4);

            if (tileentityPowerFurnace != null)
            {
                for (int j1 = 0; j1 < tileentityPowerFurnace.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityPowerFurnace.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.PowerFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.PowerFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.PowerFurnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.PowerFurnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.PowerFurnaceRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.PowerFurnaceRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.PowerFurnaceRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_96440_m(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return BlockHelper.PoweredFurnace;
    }
}

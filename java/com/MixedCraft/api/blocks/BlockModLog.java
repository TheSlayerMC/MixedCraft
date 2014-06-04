package com.MixedCraft.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.BlocksBase;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLog extends BlocksBase{

	private IIcon top;
	private IIcon side;
    protected IIcon[] sideChange;
    protected IIcon[] topChange;
	
	public BlockModLog(String name) {
		super(Material.wood, name);
		setStepSound(soundTypeWood);
		setHardness(1.5F);
		setCreativeTab(MixedCraft.BlockTab);
	}
	
	public Block setName(String name){
		GameRegistry.registerBlock(this, name);
		setBlockName(name);
		registerTexture(name + "_Side", name + "_Top", name + "_Top");
		return this;
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int var1) {
		return this.sideChange[var1 % this.sideChange.length];
	}
	
	@SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int var1)
    {
        return this.topChange[var1 % this.topChange.length];
    }
	
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int var10 = par9 & 3;
        byte var11 = 0;

        switch (par5) {
            case 0:
            case 1:
                var11 = 0;
                break;
            case 2:
            case 3:
                var11 = 8;
                break;
            case 4:
            case 5:
                var11 = 4;
        }

        return var10 | var11;
    }
    
    public IIcon getIcon(int par1, int par2) {
        int var3 = par2 & 12;
        return var3 == 0 && (par1 == 1 || par1 == 0) ? this.top : (var3 == 4 && (par1 == 5 || par1 == 4) ? this.top  : (var3 == 8 && (par1 == 2 || par1 == 3) ? top  : this.side ));
    }
}

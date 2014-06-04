package com.MixedCraft.helper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BreakableBase extends BlocksBase {
	
    private boolean localFlag;
    private String breakableBlockIcon;
    protected IIcon tileSide;
    protected String tileSideName;
    protected IIcon tileTop;
    protected String tileTopName;
    protected IIcon tileBottom;
    protected String tileBottomName;

    protected BreakableBase(Material par3Material, String name) {
        super(par3Material, name);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return !this.localFlag && i1 == this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
}

package com.MixedCraft.helper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.MixedCraft.MixedCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlocksBase extends Block {
	
    protected IIcon tileSide;
    protected String tileSideName;
    protected IIcon tileTop;
    protected String tileTopName;
    protected IIcon tileBottom;
    protected String tileBottomName;
    protected boolean enableStats = true;
    
    public BlocksBase(Material material, String name) {
        super(material);
        this.setCreativeTab(MixedCraft.BlockTab);
        setHardness(2.0F);
        GameRegistry.registerBlock(this, name);
        setBlockName(name);                 
        registerTexture(name);
        LangRegistry.addBlock(this);
    }
    
    public boolean getEnableStats() {
        return this.enableStats;
    }

    public Block disableStats() {
        this.enableStats = false;
        return this;
    }

    public Block registerTexture(String text) {
        tileSideName = tileTopName = tileBottomName = text;
		return this;
    }

    public Block registerTexture(String side, String top, String bottom) {
        tileSideName = side;
        tileTopName = top;
        tileBottomName = bottom;
		return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        tileSide = icon.registerIcon(Utils.MOD_ID +":" + tileSideName);
        tileTop = icon.registerIcon(Utils.MOD_ID +":" + tileTopName);
        tileBottom = icon.registerIcon(Utils.MOD_ID +":" + tileBottomName);
    }

    @Override
    @SideOnly(Side.CLIENT) 
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? tileTop : side == 0 ? tileBottom : tileSide;
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock(this);
    }  

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 1;
    }
}
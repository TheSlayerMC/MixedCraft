package com.MixedCraft.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemFoodBase extends ItemFood{
	 private String iconPath;


	public ItemFoodBase(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par4);
        this.setCreativeTab(MixedCraft.ToolTab);
	}
	    public Item registerTextures(String texture) {
	        iconPath = texture;
	        return this;
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister icon) {
	        itemIcon = icon.registerIcon(Utils.MOD_ID + ":" + iconPath);
	    }
}
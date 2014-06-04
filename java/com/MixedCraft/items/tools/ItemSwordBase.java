package com.MixedCraft.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSwordBase extends ItemSword{
	
	private String iconPath;
	public ItemSwordBase(ToolMaterial par3ENUM){
		super(par3ENUM);
		setMaxStackSize(1);
        this.setCreativeTab(MixedCraft.ToolTab);
	}
	
	public Item setName(String name){
		setTextureName(name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		registerTexture(name);
		return this;
	}
	
    public Item registerTexture(String texture) {
        iconPath = texture;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {
        itemIcon = icon.registerIcon(Utils.MOD_ID + ":" + iconPath);
    }
		
}

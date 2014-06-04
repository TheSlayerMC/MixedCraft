package com.MixedCraft.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.MixedCraft.ItemHelper;
import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPickaxeBase extends ItemPickaxe{

	private String iconPath;

	public ItemPickaxeBase(ToolMaterial par3ENUM){
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

	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l, boolean par4) {
		if(i.getItem() == ItemHelper.SilverPickaxe)
			l.add(EnumChatFormatting.GREEN + "Smelts on mine");
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

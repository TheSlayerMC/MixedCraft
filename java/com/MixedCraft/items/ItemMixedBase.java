package com.MixedCraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.ItemsBase;
import com.MixedCraft.helper.LangRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMixedBase extends ItemsBase{

	public ItemMixedBase() {
		LangRegistry.addMixedItem(this);
	}
	
	private String[] description;

	public ItemMixedBase setDescription(String[] desc) {
		description = desc;
		return this;
	}
	
	public Item setName(String name){
		registerTextures("mixeddnaKey");
		setUnlocalizedName(name);
		setCreativeTab(MixedCraft.MixedDNATab);
		GameRegistry.registerItem(this, name);
		return this;
	}

	@Override 
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		for(String desc : description) {
			par3List.add(desc);
		}
	}
}

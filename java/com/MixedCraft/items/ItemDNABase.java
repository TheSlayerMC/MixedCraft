package com.MixedCraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.ItemsBase;
import com.MixedCraft.helper.LangRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDNABase extends ItemsBase{

	private String[] descriptors;
	private int Gui;

	public ItemDNABase(int Gui){
		LangRegistry.addDNAItem(this);
		this.Gui = Gui;
	}

	public Item setName(String name){
		registerTextures("dnaKey");
		setUnlocalizedName(name);
		setCreativeTab(MixedCraft.DNATab);
		GameRegistry.registerItem(this, name);
		return this;
	}
	
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		var3.openGui(MixedCraft.instance, Gui, var2, 0, 0, 0);
		return var1;
	}

	public ItemDNABase setDescription(String[] descs) {
		descriptors = descs;
		return this;
	}

	@Override 
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		for (String desc : descriptors) {
			par3List.add(desc);
		}
	}
}
package com.MixedCraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.items.tools.ItemSwordBase;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBigSword extends ItemSwordBase{

	public ItemBigSword(ToolMaterial par3enum) {
		super(par3enum);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		super.onItemRightClick(itemstack, world, player);
		//itemstack.damageItem(1, player);
		//player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	public Item setName(String name){
		setTextureName(name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		registerTexture(name);
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(itemstack.getMaxDamage() - itemstack.getItemDamage() + " Uses Remaining");
	}

}

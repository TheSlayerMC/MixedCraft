package com.MixedCraft.items;

import com.MixedCraft.entity.EntityHarmlessEnderPearl;
import com.MixedCraft.helper.ManaHelper;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WandOfTeleportation extends ItemBaseWand {


	public static int defaultCharges = 64;

	public WandOfTeleportation() {
		this.setMaxDamage(defaultCharges + 1);
	}

	@Override
	public int getUseCost() {
		return 1;
	}

	@Override
	public int getBaseRepairCost() {
		return 12;
	}

	@Override 
	public int getMaxItemUseDuration(ItemStack par1ItemStack){
		return 400;
	}
	
	@Override 
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	@Override 
	public ItemStack onItemRightClick(ItemStack srcItemStack, World world, EntityPlayer playerEntity){
		playerEntity.setItemInUse(srcItemStack, getMaxItemUseDuration(srcItemStack));
		return srcItemStack;
	}
	
	@Override 
	public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		return super.onItemUse(srcItemStack, playerEntity, world, par4, par5, par6, par7, par8, par9, par10);
	}
	
	@Override 
	public void onPlayerStoppedUsing (ItemStack srcItemStack, World world, EntityPlayer playerEntity, int timeRemain){
		if(!playerEntity.capabilities.isCreativeMode) {
			if(isOutOfCharge(srcItemStack)){
				playSound(noChargeAttackSound,world,playerEntity);
				return;
			}
			srcItemStack.damageItem(getUseCost(), playerEntity);
		}
		if(!world.isRemote && ManaHelper.useBar(50)) {
			world.spawnEntityInWorld(new EntityHarmlessEnderPearl(world, playerEntity));
		}
	}

}

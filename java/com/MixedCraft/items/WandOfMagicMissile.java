package com.MixedCraft.items;

import com.MixedCraft.helper.ManaHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WandOfMagicMissile extends ItemBaseWand {

	public static int cooldown = 1;

	public static int defaultCharges = 64;

	public WandOfMagicMissile() {
		this.setMaxDamage(defaultCharges + 1);
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack){
		return cooldown;
	}

	public ItemStack onItemRightClick(ItemStack srcItemStack, World world, EntityPlayer playerEntity){
		playerEntity.setItemInUse(srcItemStack, getMaxItemUseDuration(srcItemStack));
		return srcItemStack;
	}

	@Override 
	public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		return super.onItemUse(srcItemStack, playerEntity, world, par4, par5, par6, par7, par8, par9, par10);
	}

	@Override 
	public void onPlayerStoppedUsing(ItemStack srcItemStack, World world, EntityPlayer playerEntity, int timeRemain){
		super.onPlayerStoppedUsing(srcItemStack, world, playerEntity, timeRemain);
	}

	@Override 
	public ItemStack onEaten(ItemStack srcItemStack, World world, EntityPlayer playerEntity) { 

		if (!playerEntity.capabilities.isCreativeMode) {
			if(isOutOfCharge(srcItemStack)){
				playSound(noChargeAttackSound,world,playerEntity);
				return srcItemStack;
			}
			srcItemStack.damageItem(getUseCost(), playerEntity);
		}

		playSound("mob.endermen.portal",world,playerEntity);

		if (!world.isRemote && ManaHelper.useBar(10)) {
			world.spawnEntityInWorld(new MagicMissile(world, playerEntity,  2.0F));
		}
		return srcItemStack;
	}

	@Override 
	public int getUseCost() {
		return 1;
	}

	@Override  
	public int getBaseRepairCost(){
		return 7;
	}
}

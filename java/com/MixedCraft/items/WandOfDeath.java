package com.MixedCraft.items;

import com.MixedCraft.entity.DeathSkull;
import com.MixedCraft.helper.ManaHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class WandOfDeath extends ItemBaseWand {

	public static int cooldown = 10;


	public static int defaultCharges = 64;

	public WandOfDeath() {
		this.setMaxDamage(defaultCharges + 1);
	}

	@Override 
	public int getMaxItemUseDuration(ItemStack par1ItemStack){
		return cooldown;
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
		super.onPlayerStoppedUsing(srcItemStack, world, playerEntity, timeRemain);
	}

	@Override 
	public ItemStack onEaten (ItemStack srcItemStack, World world, EntityPlayer playerEntity) { 

		if (!playerEntity.capabilities.isCreativeMode) {
			if(isOutOfCharge(srcItemStack)){

				playSound(noChargeAttackSound,world,playerEntity);
				return srcItemStack;
			}
			srcItemStack.damageItem(getUseCost(), playerEntity);
		}

		playSound("mob.endermen.portal", world, playerEntity);

		if (!world.isRemote && ManaHelper.useBar(100)) {
			double vecX = (double)(-MathHelper.sin(playerEntity.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerEntity.rotationPitch / 180.0F * (float)Math.PI));
			double vecY = (double)(-MathHelper.sin(playerEntity.rotationPitch / 180.0F * (float)Math.PI));
			double vecZ = (double)( MathHelper.cos(playerEntity.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerEntity.rotationPitch / 180.0F * (float)Math.PI));

			double deltaX = (double)(-MathHelper.sin(playerEntity.rotationYaw / 180.0F * (float)Math.PI));
			double deltaZ = (double)( MathHelper.cos(playerEntity.rotationYaw / 180.0F * (float)Math.PI));

			world.spawnEntityInWorld(new DeathSkull(world, playerEntity, playerEntity.posX + deltaX, playerEntity.posY + 1, playerEntity.posZ + deltaZ, vecX, vecY, vecZ));
		}
		return srcItemStack;
	}

	@Override 
	public int getUseCost(){
		return 1;
	}

	@Override 
	public int getBaseRepairCost(){
		return 20;
	}
}

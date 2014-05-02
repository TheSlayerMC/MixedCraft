package com.MixedCraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MixedCraft.helper.ManaHelper;

public class WandOfHarming extends ItemBaseWand {

	public static int cooldown = 10;

	public static int defaultCharges = 64;

	public WandOfHarming() {
		this.setMaxDamage(defaultCharges + 1);
	}

	@Override 
	public int getUseCost() {
		return 1;
	}

	@Override 
	public int getBaseRepairCost() {
		return 15;
	}


	@Override 
	public ItemStack onItemRightClick(ItemStack srcItemStack, World world, EntityPlayer playerEntity){
		if (!playerEntity.capabilities.isCreativeMode)
		{
			if(isOutOfCharge(srcItemStack)){
				playSound(noChargeAttackSound, world, playerEntity);
				return srcItemStack;
			}
			srcItemStack.damageItem(getUseCost(), playerEntity);
		}
		playSound("random.pop", world, playerEntity);

		ItemStack hp = new ItemStack(Items.potionitem, 5);
		hp.setItemDamage(5149388);
		if (!world.isRemote && ManaHelper.useBar(40))
		{
			world.spawnEntityInWorld(new EntityPotion(world, playerEntity, hp));
		}

		return srcItemStack;
	}
}

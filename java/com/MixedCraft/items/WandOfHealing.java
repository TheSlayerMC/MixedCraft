package com.MixedCraft.items;

import com.MixedCraft.helper.ManaHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WandOfHealing extends ItemBaseWand {

	public static int cooldown = 10;

	public static int defaultCharges = 64;

	public WandOfHealing() {
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
				playSound(noChargeAttackSound,world,playerEntity);
				return srcItemStack;
			}
			srcItemStack.damageItem(getUseCost(), playerEntity);
		}
		playSound("random.pop",world,playerEntity);

		ItemStack hp = new ItemStack(Items.potionitem);
		hp.setItemDamage(0x0005 + 0x4000);
		if (!world.isRemote && ManaHelper.useBar(40)) {
			world.spawnEntityInWorld(new EntityPotion(world, playerEntity,  hp));
		}

		return srcItemStack;
	}
}

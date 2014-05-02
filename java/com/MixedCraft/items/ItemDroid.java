package com.MixedCraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MixedCraft.entity.EntityDroid;
import com.MixedCraft.helper.ItemsBase;

public class ItemDroid extends ItemsBase{
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int se, float hitX, float hitY, float hitZ){
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntityDroid(world, x + 0.5F, y + 1.5F, z + 0.5F));
			stack.stackSize--;
			return true;
		} else {
			return false;
		}
	}
}
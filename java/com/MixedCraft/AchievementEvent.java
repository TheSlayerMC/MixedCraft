package com.MixedCraft;

import com.MixedCraft.api.Achievements;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementEvent {

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.getItem().equals(BlockHelper.assembler)){
			event.player.triggerAchievement(Achievements.assembler);
		}
		
		if(event.crafting.getItem().equals(BlockHelper.extractor)){
			event.player.triggerAchievement(Achievements.extractor);
		}
		
		if(event.crafting.getItem().equals(BlockHelper.mixer)){
			event.player.triggerAchievement(Achievements.mixer);
		}
	}
	
	@SubscribeEvent
	public void onItemSmelting(PlayerEvent.ItemSmeltedEvent event){
		if(event.smelting.getItem().equals(ItemHelper.CopperIngot)){
			event.player.triggerAchievement(Achievements.copper);
		}
		
		if(event.smelting.getItem().equals(ItemHelper.TinIngot)){
			event.player.triggerAchievement(Achievements.copper);
		}
	}
	
	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent event){
		if(event.pickedUp == new EntityItem(event.player.worldObj, event.player.posX, event.player.posY, event.player.posZ, new ItemStack(BlockHelper.tinOre))) {
			event.player.triggerAchievement(Achievements.tinOre);
		}
		
		if(event.pickedUp.equals(new ItemStack(BlockHelper.copperOre))) {
			event.player.triggerAchievement(Achievements.copperOre);
		}
	}
}
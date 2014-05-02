package com.MixedCraft;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementEvent {

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.getItem().equals(BlockHelper.Assembler)){
			event.player.triggerAchievement(Achievements.Assembler);
		}
		
		if(event.crafting.getItem().equals(BlockHelper.Extractor)){
			event.player.triggerAchievement(Achievements.Extractor);
		}
		
		if(event.crafting.getItem().equals(BlockHelper.Mixer)){
			event.player.triggerAchievement(Achievements.Mixer);
		}
	}
	
	@SubscribeEvent
	public void onItemSmelting(PlayerEvent.ItemSmeltedEvent event){
		if(event.smelting.getItem().equals(ItemHelper.CopperIngot)){
			event.player.triggerAchievement(Achievements.Copper);
		}
		
		if(event.smelting.getItem().equals(ItemHelper.TinIngot)){
			event.player.triggerAchievement(Achievements.Copper);
		}
	}
	
	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent event){
		if(event.pickedUp == new EntityItem(event.player.worldObj, event.player.posX, event.player.posY, event.player.posZ, new ItemStack(BlockHelper.TinOre))) {
			event.player.triggerAchievement(Achievements.TinOre);
		}
		
		if(event.pickedUp.equals(new ItemStack(BlockHelper.CopperOre))) {
			event.player.triggerAchievement(Achievements.CopperOre);
		}
	}
}
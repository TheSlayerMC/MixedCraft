package com.MixedCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.MixedCraft.blocks.BlockFlylightSapling;
import com.MixedCraft.helper.ManaHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class Event {	

	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlock(event.x, event.y, event.z) == BlockHelper.flylightSapling) {
			((BlockFlylightSapling)BlockHelper.flylightSapling).growTree(event.world, event.x, event.y, event.z, event.world.rand);
		}
	}

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event){
		if (event.harvester != null) {
			if (event.harvester.getHeldItem().getItem() == ItemHelper.SilverPickaxe || event.harvester.getHeldItem().getItem() == ItemHelper.SilverShickaxe) {
				ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(event.block, 1, event.blockMetadata));
				if (stack != null && event.block != Blocks.redstone_ore && event.block != Blocks.lapis_ore) {
					event.drops.clear();
					event.drops.add(stack.copy());
				}
			}
		}
	}

	@SubscribeEvent
	public void constructed(EntityConstructing ev){
		if(ev.entity instanceof EntityPlayer){
			
		}
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){ 
		ManaHelper.setBarValue(200);
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event){ 
		ManaHelper.setBarValue(0);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event){ 
		ManaHelper.setBarValue(200);
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event){
		ManaHelper.setBarValue(200);
	}
}
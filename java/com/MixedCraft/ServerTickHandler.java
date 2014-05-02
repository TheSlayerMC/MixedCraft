package com.MixedCraft;

import net.minecraft.server.MinecraftServer;

import com.MixedCraft.helper.ManaHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ServerTickHandler {

	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.END){
			ManaHelper.updateAllBars();
		}
	}
}
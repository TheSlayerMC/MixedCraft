package com.MixedCraft;

import com.MixedCraft.helper.ManaHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientTickHandler {

	Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.START){
			onTickStart();
		}else{
			//onTickEnd();
		}
	}
	
	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		if(mc.currentScreen == null) {
			GuiIngame gig = mc.ingameGUI;
			EntityPlayer player = mc.thePlayer;
			int var29;
			int var26;
			ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			int k = scaledresolution.getScaledHeight();
			this.mc.getTextureManager().bindTexture(new ResourceLocation("MixedCraft:textures/gui/ManaBar.png"));
			var26 = k - 18;
			var29 = i - 220;
			gig.drawTexturedModalRect(var29, var26, 0, 0, 200 + 3, 10);
			gig.drawTexturedModalRect(var29, var26, 0, 10, (int) ManaHelper.getBarValue() + 1, 20);  
		}
	}

	private void onTickEnd() {
		EntityPlayer player = mc.thePlayer;
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(MixedAPI.addChatMessage(EnumChatFormatting.GREEN + "Welcome " + player.getDisplayName()));
	}

	private void onTickStart() { }
}
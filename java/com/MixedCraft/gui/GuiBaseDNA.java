package com.MixedCraft.gui;

import org.lwjgl.opengl.GL11;

import com.MixedCraft.blocks.container.ContainerBigCrafting;
import com.MixedCraft.blocks.container.DNAContainer;
import com.MixedCraft.handler.GuiResourceLocation;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiBaseDNA extends GuiContainer{

	public GuiBaseDNA() {
		super(new DNAContainer());
	}

	public void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiResourceLocation.DNA);
		this.xSize = 238;
		this.ySize = 247;
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}
}
package com.MixedCraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.MixedCraft.blocks.container.ContainerIronFurnace;
import com.MixedCraft.blocks.tileEntity.TileEntityIronFurnace;
import com.MixedCraft.handler.GuiResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiIronFurnace extends GuiContainer
{
    private TileEntityIronFurnace furnaceInventory;

    public GuiIronFurnace(InventoryPlayer par1InventoryPlayer, TileEntityIronFurnace par2TileEntityFurnace)
    {
        super(new ContainerIronFurnace(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = "Iron Furnace";
        this.fontRendererObj.drawString(s, 10, 6, 4210752);
        this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GuiResourceLocation.IronFurnace);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.furnaceInventory.isBurning())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 140, l + 60 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 96, l + 34, 176, 14, i1 + 1, 16);
    }
}

package com.MixedCraft.entity.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.MixedCraft.blocks.tileEntity.TileEntityTable;
import com.MixedCraft.entity.model.ModelTable;


public class RenderTable extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation("MixedCraft:textures/model/Table.png");
    
    static final float scale = (float)(1.0 / 16.0);
    private ModelTable modelTable;

    public RenderTable()
    {
        modelTable = new ModelTable(scale);
    }
    
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntityTable)var1, x, y, z, tick);
    }

    public void renderAModelAt(TileEntityTable tile, double x, double y, double z, float f)
    {
        int rotation = 0;
        if(tile.getWorldObj() != null)
        {
            rotation = tile.getBlockMetadata();
        }
        
        this.bindTexture(texture);
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y - 0.0F, (float)z + 0.5F);
        GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
        modelTable.render(0.0625F);
        GL11.glPopMatrix();
    }
    
}

package com.MixedCraft.entity.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.MixedCraft.entity.EntityDroid;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroid extends ModelBase{

	private ArrayList<ModelRenderer> parts, panels, outerPanels;
	private ModelRenderer core, pillars;

	public ModelDroid(){
		parts = new ArrayList<ModelRenderer>();

		textureHeight = 64;
		textureWidth = 64;

		ModelRenderer main = new ModelRenderer(this, 0, 0);
		main.addBox(-5, -5, -5,
				10, 10, 10);

		main.setRotationPoint(0, 0, 0);
		parts.add(main);

		pillars = new ModelRenderer(this, 0, 20);
		for(int x = -1; x <= 1; x += 2){
			for(int z = -1; z <= 1; z += 2){
				pillars.addBox(-1 + x * 3.995F, -1, -1 + z * 3.995F, 2, 8, 2);
			}
		}
		pillars.setRotationPoint(0, -6, 0);
		parts.add(pillars);

		ModelRenderer top = new ModelRenderer(this, 0, 20);
		top.addBox(-5, -2, -5,
				10, 4, 10);

		top.setRotationPoint(0, -3, 0);
		pillars.addChild(top);

		panels = new ArrayList<ModelRenderer>();
		outerPanels = new ArrayList<ModelRenderer>();
		for(float r = 0; r < Math.PI * 2; r += Math.PI / 2){
			ModelRenderer side = new ModelRenderer(this, 0, 34);
			side.addBox(-4, -2.5F, 5, 8, 5, 1);

			side.setRotationPoint(0, 0, 0);
			side.rotateAngleY = r;	
			parts.add(side);

			ModelRenderer panel = new ModelRenderer(this, 18, 34);
			panel.addBox(-4, -0.5F, -0.5F, 8, 5, 1);

			panel.setRotationPoint(0, -2, 6.5F);
			side.addChild(panel);
			panels.add(panel);

			ModelRenderer panelOuter = new ModelRenderer(this, 18, 34);

			panelOuter.addBox(-4, -0.5F, -0.5F, 8, 5, 1);

			panelOuter.setRotationPoint(0, 5, 0);
			panel.addChild(panelOuter);
			outerPanels.add(panelOuter);
		}

		core = new ModelRenderer(this, 30, 0);
		core.addBox(-3, -1, -3,
				6, 2, 6);

		core.setRotationPoint(0, -6, 0);
		//parts.add(core);
	}


	public void render(float CoreRotation, float PanelRotation, float OuterPanelRotation, float HelmetPosition, float coreRed, float coreGreen, float coreBlue, float mult) {

		core.rotateAngleY = CoreRotation;

		for(ModelRenderer panel : panels){
			panel.rotateAngleX = PanelRotation;
		}

		for(ModelRenderer panel : outerPanels){
			panel.rotateAngleX = OuterPanelRotation;
		}

		//pillars.rotationPointY = HelmetPosition;

		GL11.glColor4f(1F, 1F, 1F, 1F); 

		for(ModelRenderer part : parts){
			part.render(mult); 
		}

		GL11.glColor4f(coreRed, coreGreen, coreBlue, 1F);

		core.render(mult);
	}

}

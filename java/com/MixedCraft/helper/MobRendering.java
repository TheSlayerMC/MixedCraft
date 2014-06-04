package com.MixedCraft.helper;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.MixedCraft.*;
import com.MixedCraft.blocks.tileEntity.*;
import com.MixedCraft.entity.*;
import com.MixedCraft.entity.model.*;
import com.MixedCraft.entity.model.ModelSheep1;
import com.MixedCraft.entity.model.ModelSheep2;
import com.MixedCraft.entity.render.*;

import cpw.mods.fml.client.registry.*;


public class MobRendering {

	public static void init(){

		RenderingRegistry.registerEntityRenderingHandler(EntityChickenCow.class, new RenderChickenCow(new ModelChicken(), 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCowCreeper.class, new RenderCowCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityCowPig.class, new RenderCowPig(new ModelCow(), 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCowSheep.class, new RenderCowSheep(new ModelSheep2(), new ModelSheep1(), 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCowEnderman.class, new RenderCowEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityCowZombie.class, new RenderCowZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityCompanion.class, new RenderTameable());

		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(new ModelDroid()));
        MinecraftForgeClient.registerItemRenderer(ItemHelper.Droid, new RenderDroidItem());
		
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new RenderTable());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHelper.table), new ItemTableRenderer());
                
        RenderingRegistry.registerEntityRenderingHandler(EntityLightningArrow.class, new RenderLightningArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityTNTArrow.class, new RenderTNTArrow());
	}

}

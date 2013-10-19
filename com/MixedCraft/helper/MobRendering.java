package com.MixedCraft.helper;

import net.minecraft.client.model.*;
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


		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(new ModelDroid()));
        MinecraftForgeClient.registerItemRenderer(ItemHelper.Droid.itemID, new RenderDroidItem());
		
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new RenderTable());
        MinecraftForgeClient.registerItemRenderer(BlockHelper.Table.blockID, new ItemTableRenderer());
        
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHugeChest.class, new RenderHugeChest());
        //MinecraftForgeClient.registerItemRenderer(BlockHelper.HugeChest.blockID, new ItemRenderHugeChest());
        
        
	}

}

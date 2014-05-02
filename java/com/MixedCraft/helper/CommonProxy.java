package com.MixedCraft.helper;

import net.minecraftforge.common.MinecraftForge;

import com.MixedCraft.AchievementEvent;
import com.MixedCraft.Achievements;
import com.MixedCraft.BlockHelper;
import com.MixedCraft.ClientEvent;
import com.MixedCraft.Event;
import com.MixedCraft.ServerTickHandler;
import com.MixedCraft.blocks.tileEntity.TileEntityDNAAssembler;
import com.MixedCraft.blocks.tileEntity.TileEntityDNAExtractor;
import com.MixedCraft.blocks.tileEntity.TileEntityDNAMixer;
import com.MixedCraft.blocks.tileEntity.TileEntityDiamondFurnace;
import com.MixedCraft.blocks.tileEntity.TileEntityGoldFurnace;
import com.MixedCraft.blocks.tileEntity.TileEntityIronFurnace;
import com.MixedCraft.blocks.tileEntity.TileEntityPowerFurnace;
import com.MixedCraft.blocks.tileEntity.TileEntitySolarPanel;
import com.MixedCraft.dimension.DimensionHelper;
import com.MixedCraft.gen.WorldGenMixedMinable;
import com.MixedCraft.handler.HelperHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy extends HelperHandler {

	public void registerRenderInformation() {}    

	//ClientProxy
	public void preInit(FMLPreInitializationEvent event) {         
		ConfigHelper.initConfig();
		GameRegistry.registerWorldGenerator(new WorldGenMixedMinable(), 10);
		BlockHelper.addOres();
		HarvestLevelHelper.init();
		RecipeRemover.init();
		MobRegistry.init();
		DimensionHelper.init();
		registerTileEntity();
		MinecraftForge.EVENT_BUS.register(new Event());
		LangRegistry.init();
		if(Utils.DEBUG){
			LangRegistry.addBlockNames();
		    LangRegistry.addItemNames();
		}
		LangRegistry.closeFile();
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
	}

	public void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityDiamondFurnace.class, "TileEntity Diamond Furnace");
		GameRegistry.registerTileEntity(TileEntityIronFurnace.class, "TileEntity Iron Furnace");
		GameRegistry.registerTileEntity(TileEntityDNAExtractor.class, "TileEntity Extractor");
		GameRegistry.registerTileEntity(TileEntityDNAMixer.class, "TileEntity Mixer");
		GameRegistry.registerTileEntity(TileEntityDNAAssembler.class, "TileEntity Assember");
		GameRegistry.registerTileEntity(TileEntityGoldFurnace.class, "TileEntity Gold Furnace");
		GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "TileEntity SolarPanel");
		GameRegistry.registerTileEntity(TileEntityPowerFurnace.class, "TileEntity Power Furnace");
	}

	public void init(FMLInitializationEvent event) {     
		Achievements.init();
		MinecraftForge.EVENT_BUS.register(new ClientEvent());
		FMLCommonHandler.instance().bus().register(new AchievementEvent());
	}
	
	public void registerCape(){ }
}

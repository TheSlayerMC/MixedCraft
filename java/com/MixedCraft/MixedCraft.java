package com.MixedCraft;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.fluids.Fluid;

import com.MixedCraft.api.ModFluid;
import com.MixedCraft.dimension.BiomeGenFlylight;
import com.MixedCraft.handler.*;
import com.MixedCraft.helper.*;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

@Mod(modid = Utils.MOD_ID, name = Utils.MOD_NAME, version = Utils.MOD_VERSION)
public class MixedCraft extends HelperHandler {

	@Instance(Utils.MOD_ID)
	public static MixedCraft instance;

	@SidedProxy(serverSide = Utils.COMMONPROXY, clientSide = Utils.CLIENTPROXY)
	public static CommonProxy proxy; 

	public static Fluid modWater = new ModFluid("Fluid");
	
	public static final CreativeTabs DNATab = new CreativeTabs("DNA"){
		public Item getTabIconItem() { return ItemHelper.CowDNADrive; }
	};
	public static final CreativeTabs MixedDNATab = new CreativeTabs("MixedDNA"){
		public Item getTabIconItem() { return ItemHelper.CowBlazeMixedDrive; }
	};
	public static final CreativeTabs SpawnerTab = new CreativeTabs("Spawner"){
		public Item getTabIconItem() { return ItemHelper.CowChickenSpawner; }
	};
	public static final CreativeTabs BlockTab = new CreativeTabs("Block"){
		public Item getTabIconItem() { return Item.getItemFromBlock(BlockHelper.extractor); }
	};
	public static final CreativeTabs ToolTab = new CreativeTabs("Tool"){
		public Item getTabIconItem() { return ItemHelper.SilverPickaxe; }
	};
	public static final CreativeTabs MiscTab = new CreativeTabs("Misc"){
		public Item getTabIconItem() { return ItemHelper.SilverIngot; }
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		proxy.registerRenderInformation();
		event.getModMetadata().credits = "The_Slayer ~ The programmer, DrCyano ~ The programmer for the Magic Wands mod";
		event.getModMetadata().description = "MixedCraft is a mod made by The_Slayer, it's still in the making!";
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		//proxy.registerCape();
	}	

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event){}
}
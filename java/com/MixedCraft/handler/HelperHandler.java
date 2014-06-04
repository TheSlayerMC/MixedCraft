package com.MixedCraft.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.MixedCraft.helper.ConfigHelper;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class HelperHandler {
	
	public static String MobTexturePrefix = Utils.MOD_ID + ":" + "textures/entity/";
	public static String ModelTexturePrefix = Utils.MOD_ID + ":" + "textures/model/";
	public static String GuiTexturePrefix = Utils.MOD_ID + ":" + "textures/gui/";
		
	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;
	
	public static ToolMaterial Silver = EnumHelper.addToolMaterial("Silver", 4, 1000, 11.0F, 7, 16);
    public static ToolMaterial SilverShick = EnumHelper.addToolMaterial("SilverShick", 5, -1, 150.0F, 22, 20);
	public static ToolMaterial Flame = EnumHelper.addToolMaterial("Flame", 4, -1, 0.0F, 6, 16);
	public static ToolMaterial Iron = EnumHelper.addToolMaterial("Iron", 4, 1000, 0.2F, 4, 16);
	public static ToolMaterial Diamond = EnumHelper.addToolMaterial("Diamond", 4, 1000, 0.2F, 7, 16);
	public static ToolMaterial Gold = EnumHelper.addToolMaterial("Gold", 4, 1000, 0.2F, 4, 16);
	public static ToolMaterial Wood = EnumHelper.addToolMaterial("Wood", 0, 1000, 0.1F, 0, 5);
	public static ToolMaterial Stone = EnumHelper.addToolMaterial("Stone", 4, 1000, 0.2F, 2, 16);	
}

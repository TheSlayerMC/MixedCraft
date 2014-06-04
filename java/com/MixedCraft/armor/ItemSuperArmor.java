package com.MixedCraft.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.MixedCraft.MixedCraft;
import com.MixedCraft.helper.LangRegistry;
import com.MixedCraft.helper.Utils;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSuperArmor extends ItemArmor{

	public static final int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;
	protected String textureName = Utils.MOD_ID + ":" + "textures/armor/", name;

	public ItemSuperArmor(ArmorMaterial par2EnumArmorMaterial, int type, String name) {
		super(par2EnumArmorMaterial, type, type);
		
		setCreativeTab(MixedCraft.ToolTab);
        setArmorType(name, armorType);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
	}

	protected void setArmorType(String material, int armorType) {
		this.name = armorType == HEAD ? material + "Helmet" : armorType == BODY ? material + "Body" : armorType == LEGS ? material + "Legs" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
		this.textureName = (armorType == 0 || armorType == 1 || armorType == 3) ? textureName + material + "_1.png" : textureName + material + "_2.png";
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return textureName;
    }
}
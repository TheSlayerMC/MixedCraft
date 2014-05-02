package com.MixedCraft.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;


public class ManaHelper implements IExtendedEntityProperties{

	private static int mana = 0;
	private static int regenDelay = 0;

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("Mana", mana);
		n.setInteger("Regen", regenDelay);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.mana = n.getInteger("Mana");
		this.regenDelay = n.getInteger("Regen");
	}

	public static void updateAllBars() {
		if(mana != 200){
			regen(1);
		} else {
			regen(0);
		}
	}                

	public static boolean useBar(int amount) {
		if(mana < amount) {
			regenDelay = 30;
			return false;
		}
		mana -= amount;
		regenDelay = 30;
		return true;
	}

	public static void regen(int par1) {
		if(regenDelay == 0) {
			mana += par1;
		} else {
			regenDelay -= 1;
		}
	}

	public static float getBarValue() {
		return mana;
	}

	public static void setBarValue(int i) {
		mana += i;
	}

	@Override
	public void init(Entity entity, World world) { }
}
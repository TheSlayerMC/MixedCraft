package com.MixedCraft;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class MixedAPI {
	
	public static ChatComponentTranslation addChatMessage(EnumChatFormatting color, String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.getChatStyle().setColor(color);
		return ret;
	}

	public static ChatComponentTranslation addChatMessage(String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.getChatStyle().setColor(EnumChatFormatting.WHITE);
		return ret;
	}
}
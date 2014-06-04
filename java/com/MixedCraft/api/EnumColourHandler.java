package com.MixedCraft.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum EnumColourHandler {
    BLACK('0'),
    DARK_BLUE('1'),
    DARK_GREEN('2'),
    DARK_AQUA('3'),
    DARK_RED('4'),
    DARK_PURPLE('5'),
    GOLD('6'),
    GRAY('7'),
    DARK_GRAY('8'),
    BLUE('9'),
    GREEN('a'),
    AQUA('b'),
    RED('c'),
    LIGHT_PURPLE('d'),
    YELLOW('e'),
    WHITE('f'),
    OBFUSCATED('k'),
    BOLD('l'),
    STRIKETHROUGH('m'),
    UNDERLINE('n'),
    ITALIC('o'),
    RESET('r');
    private final String colour;

    private EnumColourHandler(char par3) {
        this.colour = "\u00a7" + par3;
    }

    public String toString() {
        return this.colour;
    }
}

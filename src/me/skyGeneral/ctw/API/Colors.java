package me.skyGeneral.ctw.API;

import org.bukkit.ChatColor;

public class Colors {
	public static String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	public static String colorize(char c, String message){
		return ChatColor.translateAlternateColorCodes(c, message);
	}

}

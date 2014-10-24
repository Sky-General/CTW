package me.skyGeneral.ctw;

import me.skyGeneral.ctw.API.APIListener;
import me.skyGeneral.ctw.API.CustomEntityType;
import me.skyGeneral.ctw.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable(){
		CustomEntityType.registerEntities();
		new APIListener(this);
		new PlayerListener(this);
		}
	public void onDisable(){
		CustomEntityType.unregisterEntities();
	}

}

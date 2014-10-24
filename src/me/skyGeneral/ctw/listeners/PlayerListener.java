package me.skyGeneral.ctw.listeners;

import me.skyGeneral.ctw.Main;
import me.skyGeneral.ctw.API.API;
import me.skyGeneral.ctw.entities.RedSheep;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerListener implements Listener {
	Main plugin;
	public PlayerListener(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(e.getMessage().equalsIgnoreCase("go")){
			API.placeSheep(plugin, e.getPlayer().getWorld());
		}
		if(e.getMessage().equalsIgnoreCase("red")){
			API.setRedSheepLocation(plugin, new Location(e.getPlayer().getWorld(), (int) e.getPlayer().getLocation().getX(), (int) e.getPlayer().getLocation().getY(), (int) e.getPlayer().getLocation().getZ()));
		}
		if(e.getMessage().equalsIgnoreCase("blue")){
			API.setBlueSheepLocation(plugin, new Location(e.getPlayer().getWorld(), (int) e.getPlayer().getLocation().getX(), (int) e.getPlayer().getLocation().getY(), (int) e.getPlayer().getLocation().getZ()));
		}
		if(e.getMessage().equalsIgnoreCase("test")){
			RedSheep.spawn(e.getPlayer().getWorld(), e.getPlayer().getLocation());
		}
		if(e.getMessage().equalsIgnoreCase("killall")){
			for(Entity en : e.getPlayer().getNearbyEntities(100, 100, 100)){
				if(!(en instanceof Player)) en.remove();
			}
			e.setCancelled(true);
		}
	}

}

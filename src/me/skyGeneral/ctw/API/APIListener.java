package me.skyGeneral.ctw.API;

import me.skyGeneral.ctw.Main;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class APIListener implements Listener {
	Main plugin;
	public APIListener(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent e){
		API.updateBlockStorage(e.getBlock().getLocation(), e.getBlock().getState());	
	}
	@EventHandler
	public void onBlockExplode(EntityExplodeEvent e){
		for(Block block : e.blockList()){
			API.updateBlockStorage(block.getLocation(), block.getState());
		}
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		API.updateBlockStorage(e.getBlock().getLocation(), e.getBlockReplacedState());	
	}
}

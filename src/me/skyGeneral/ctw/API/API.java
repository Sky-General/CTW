package me.skyGeneral.ctw.API;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import me.skyGeneral.ctw.Main;
import me.skyGeneral.ctw.entities.BlueSheep;
import me.skyGeneral.ctw.entities.RedSheep;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;

public class API {
	private static Map<Location, Material> blocks = new HashMap<Location, Material>();
	private static Map<Location, Byte> data = new HashMap<Location, Byte>();
	private static HashSet<Location> dataToRemove = new HashSet<Location>();
	
	public static void resetArena(World arena){
		for(Entry<Location, Material> ent : blocks.entrySet()){
			if(ent.getKey().getWorld().equals(arena)){
				ent.getKey().getBlock().setType(ent.getValue());
				ent.getKey().getBlock().setData(data.get(ent.getKey()));
			}
		}
		Iterator itr = dataToRemove.iterator();
		while(itr.hasNext()){
			blocks.remove(itr.next());
			data.remove(itr.next());
		}
		dataToRemove.clear();
		
	}
	public static void updateBlockStorage(Location loc, BlockState b){
		if(!blocks.containsKey(loc)){
			blocks.put(loc, b.getType());
			data.put(loc, b.getBlock().getData());				
			 
		}
	}
	public static void placeSheep(Main plugin, World world){
		RedSheep.spawn(world, getRedSheepLocation(plugin, world));
		Bukkit.broadcastMessage("RED SHEEP SPAWNED");
		BlueSheep.spawn(world, getBlueSheepLocation(plugin, world));
		Bukkit.broadcastMessage("BLUE SHEEP SPAWNED");
	}
	public static Location getRedSheepLocation(Main plugin, World arena){
		try{
			return new Location(arena, plugin.getConfig().getInt("Sheep." + arena.getName() + ".red.x"), plugin.getConfig().getInt("Sheep." + arena.getName() + ".red.y"), plugin.getConfig().getInt("Sheep." + arena.getName() + ".red.z")).add(0.5,0,-0.5);
		} catch(NullPointerException ex){
			Bukkit.broadcastMessage(Colors.colorize("&4ERROR: Could not find the red flag/sheep for arena " + arena));
		}
		return null;
	}
	public static Location getBlueSheepLocation(Main plugin, World arena){
		try{
			return new Location(arena, plugin.getConfig().getInt("Sheep." + arena.getName() + ".blue.x"), plugin.getConfig().getInt("Sheep." + arena.getName() + ".blue.y"), plugin.getConfig().getInt("Sheep." + arena.getName() + ".blue.z")).add(0.5,0,-0.5);
		} catch(NullPointerException ex){
			Bukkit.broadcastMessage(Colors.colorize("&4ERROR: Could not find the blue flag/sheep for arena " + arena));
		}
		return null;
	}
	public static void setRedSheepLocation(Main plugin, Location loc){
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".red.x", loc.getX());
		plugin.saveConfig();
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".red.y", loc.getY());
		plugin.saveConfig();
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".red.z", loc.getZ());
		plugin.saveConfig();
	}
	public static void setBlueSheepLocation(Main plugin, Location loc){
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".blue.x", loc.getX());
		plugin.saveConfig();
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".blue.y", loc.getY());
		plugin.saveConfig();
		plugin.getConfig().set("Sheep." + loc.getWorld().getName() + ".blue.z", loc.getZ());
		plugin.saveConfig();
	}

}

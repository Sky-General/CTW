package me.skyGeneral.ctw.entities;

import java.util.List;

import me.skyGeneral.ctw.API.EntityUtils;
import net.minecraft.server.v1_7_R3.DamageSource;
import net.minecraft.server.v1_7_R3.EntityHuman;
import net.minecraft.server.v1_7_R3.EntitySheep;
import net.minecraft.server.v1_7_R3.NBTTagCompound;
import net.minecraft.server.v1_7_R3.PathfinderGoalSelector;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RedSheep extends EntitySheep {
	public RedSheep(World world){
		super(((CraftWorld) world).getHandle());
		List goalB = (List) EntityUtils.getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
        List goalC = (List) EntityUtils.getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
        List targetB = (List) EntityUtils.getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
        List targetC = (List) EntityUtils.getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
        

	}
	public static void spawn(World world, Location loc){
		RedSheep entity = new RedSheep(world);
		entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
		(((CraftWorld) loc.getWorld()).getHandle()).addEntity(entity);
		entity.setColor(DyeColor.RED.ordinal());
	}
	@Override
    public void g(double a, double b, double c){
		
	}
	@Override
	public void e(NBTTagCompound nbttagcompound){
		
	}
	@Override
	public boolean a(EntityHuman entityhuman) {
		if(this.getColor() == DyeColor.RED.ordinal()){
			this.setColor(DyeColor.WHITE.ordinal());
			ItemStack wool = new ItemStack(Material.WOOL);
			wool.setDurability((short) 14);
			((Player) entityhuman.getBukkitEntity()).getInventory().setHelmet(wool);
		}
		return true;
	}

}

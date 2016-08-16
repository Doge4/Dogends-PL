package me.woulfiee.server.worlds.utils;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.worlds.plots.plotsgenerator.PlotsGenerator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

/**
 * 
 * @author Woulfiee
 *
 */
public class CreateWorld {

	public static void createPlotWorld() {
		new WorldCreator("plots");
		WorldCreator world = WorldCreator.name("plots").generator(new PlotsGenerator());
		Bukkit.createWorld(world);
		Dogends.getMain().getConfig().set("Worlds.plots.Generator", "plots");
		Dogends.getMain().saveConfig();
	}

	public static void createWorld(String name, World.Environment environment, WorldType worldtype) {
		new WorldCreator(name);
		WorldCreator world = WorldCreator.name(name).environment(environment).type(worldtype);
		Bukkit.createWorld(world);
		if (environment == Environment.THE_END) {
			if (worldtype == WorldType.NORMAL) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "end");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "normal");
			} else if (worldtype == WorldType.FLAT) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "end");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "flat");
			} else if (worldtype == WorldType.AMPLIFIED) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "end");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "amplified");
			}
		} else if (environment == Environment.NORMAL) {
			if (worldtype == WorldType.NORMAL) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "normal");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "normal");
			} else if (worldtype == WorldType.FLAT) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "normal");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "flat");
			} else if (worldtype == WorldType.AMPLIFIED) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "normal");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "amplified");
			}

		} else if (environment == Environment.NETHER) {
			if (worldtype == WorldType.NORMAL) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "nether");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "normal");
			} else if (worldtype == WorldType.FLAT) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "nether");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "flat");
			} else if (worldtype == WorldType.AMPLIFIED) {
				Dogends.getMain().getConfig().set("Worlds." + name + ".Environment", "nether");
				Dogends.getMain().getConfig().set("Worlds." + name + ".Type", "amplified");
			}
		}
		Dogends.getMain().saveConfig();
	}

}

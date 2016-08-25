package me.woulfiee.server.worlds.utils;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import me.woulfiee.server.Dogends;

/**
 * 
 * @author Woulfiee
 *
 */
public class LoadWorlds {

	public static void loadWorlds() {
		if (Dogends.getMain().getConfig().getConfigurationSection("Worlds") != null) {
			for (String names : Dogends.getMain().getConfig().getConfigurationSection("Worlds").getKeys(false)) {
				if (names != null) {
					if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Environment") != null) {
						if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Environment").equals("end")) {
							if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type").equals("normal")) {
								Bukkit.createWorld(new WorldCreator(names).environment(Environment.THE_END)
										.type(WorldType.NORMAL));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("flat")) {
								Bukkit.createWorld(
										new WorldCreator(names).environment(Environment.THE_END).type(WorldType.FLAT));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("amplified")) {
								Bukkit.createWorld(new WorldCreator(names).environment(Environment.THE_END)
										.type(WorldType.AMPLIFIED));
							}
						} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Environment")
								.equals("normal")) {
							if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type").equals("normal")) {
								Bukkit.createWorld(
										new WorldCreator(names).environment(Environment.NORMAL).type(WorldType.NORMAL));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("flat")) {
								Bukkit.createWorld(
										new WorldCreator(names).environment(Environment.NORMAL).type(WorldType.FLAT));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("amplified")) {
								Bukkit.createWorld(new WorldCreator(names).environment(Environment.NORMAL)
										.type(WorldType.AMPLIFIED));
							}

						} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Environment")
								.equals("nether")) {
							if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type").equals("normal")) {
								Bukkit.createWorld(
										new WorldCreator(names).environment(Environment.NETHER).type(WorldType.NORMAL));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("flat")) {
								Bukkit.createWorld(
										new WorldCreator(names).environment(Environment.NETHER).type(WorldType.FLAT));
							} else if (Dogends.getMain().getConfig().getString("Worlds." + names + ".Type")
									.equals("amplified")) {
								Bukkit.createWorld(new WorldCreator(names).environment(Environment.NETHER)
										.type(WorldType.AMPLIFIED));
							}

						} else if (Dogends.getMain().getConfig().getString("Worlds.plots.Generator").equals("plots")) {
							CreateWorld.createPlotWorld();
						}
					}
				}
			}
		}
	}

}

/**
 * 
 */
package me.woulfiee.server.tab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * @author Woulfiee
 *
 */
public class TabCompletion implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String a0lias, String[] args) {
		List<String> tab = new ArrayList<String>();
		if (command.getName().equalsIgnoreCase("ann")) {
			if (args.length == 1) {
				String a0 = args[0].toLowerCase();
				if (a0.startsWith("t")) {
					tab.add("title");
					tab.add("text");
					return tab;
				} else if (a0.startsWith("s")) {
					tab.add("subtitle");
					return tab;
				} else if (a0.startsWith("")) {
					tab.add("subtitle");
					tab.add("title");
					tab.add("text");
					return tab;
				}
			}
		} else if (command.getName().equalsIgnoreCase("setrank")) {
			if (args.length == 1) {
				String a0 = args[0].toLowerCase();
				if (a0.startsWith("g")) {
					tab.add("gracz");
					return tab;
				} else if (a0.startsWith("v")) {
					tab.add("vip");
					return tab;
				} else if (a0.startsWith("b")) {
					tab.add("budowniczy");
					return tab;
				} else if (a0.startsWith("m")) {
					tab.add("mod");
					return tab;
				} else if (a0.startsWith("y")) {
					tab.add("youtuber");
					return tab;
				} else if (a0.startsWith("a")) {
					tab.add("admin");
					return tab;
				} else if (a0.startsWith("w")) {
					tab.add("wlasciciel");
					return tab;
				} else if (a0.startsWith("")) {
					tab.add("gracz");
					tab.add("vip");
					tab.add("budowniczy");
					tab.add("mod");
					tab.add("youtuber");
					tab.add("admin");
					tab.add("wlasciciel");
					Collections.sort(tab);
					return tab;
				}
			}
		} else if (command.getName().equalsIgnoreCase("gamemode")) {
			if (args.length == 1) {
				String a0 = args[0].toLowerCase();
				if (a0.startsWith("s")) {
					tab.add("survival");
					tab.add("spectator");
					return tab;
				} else if (a0.startsWith("c")) {
					tab.add("creative");
					return tab;
				} else if (a0.startsWith("a")) {
					tab.add("adventure");
					return tab;
				} else if (a0.startsWith("")) {
					tab.add("0");
					tab.add("1");
					tab.add("2");
					tab.add("3");
					tab.add("survival");
					tab.add("adventure");
					tab.add("spectator");
					tab.add("creative");
					Collections.sort(tab);
					return tab;
				}
			}
		} else if (command.getName().equalsIgnoreCase("world")) {
			if (args.length == 1) {
				String a0 = args[0].toLowerCase();
				if (a0.startsWith("c")) {
					tab.add("create");
					return tab;
				} else if (a0.startsWith("r")) {
					tab.add("remove");
					return tab;
				} else if (a0.startsWith("i")) {
					tab.add("import");
					return tab;
				} else if (a0.startsWith("u")) {
					tab.add("unload");
					return tab;
				}
			} else if (args.length == 2) {
				String a0 = args[0].toLowerCase();
				if (a0.equalsIgnoreCase("create")) {
					String a1 = args[1].toLowerCase();
					if (a1.startsWith("e")) {
						tab.add("end");
						return tab;
					}
					// } else if (a0.startsWith("r")) {
					// tab.add("remove");
					// return tab;
					// } else if (a0.startsWith("i")) {
					// tab.add("import");
					// return tab;
					// } else if (a0.startsWith("u")) {
					// tab.add("unload");
					// return tab;
				}
			}
		} else if (command.getName().equalsIgnoreCase("wgoto")) {
			if (args.length == 1) {
				String a0 = args[0].toLowerCase();
				for (World world : Bukkit.getWorlds()) {
					if (a0.substring(0, 1).startsWith(world.getName().substring(0, 1).toLowerCase())) {
						tab.add(world.getName());
						return tab;
					} else if (a0.startsWith("")) {
						tab.add(world.getName());
						return tab;
					}
				}
			}
		} else if (command.getName().equalsIgnoreCase("deop")) {

			// } else if (command.getName().equalsIgnoreCase("dzialka")) {

		}
		return null;
	}

}

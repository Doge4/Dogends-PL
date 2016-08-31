/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.worlds.plots.commands;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.worlds.plots.utils.LocationUtils;
import me.woulfiee.server.worlds.plots.utils.Plot;
import me.woulfiee.server.worlds.plots.utils.PlotManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * 
 * @author Woulfiee
 *
 */
public class PlotCommand implements CommandExecutor {

	/**
	 * Displays help message
	 * 
	 * @return help message
	 */
	private static String displayHelpMessage() {
        StringBuilder builder = new StringBuilder(StringUtils.center("§c DZIALKI ", 239, "§7§m-") + "\n");
        builder.append("§7- /d stworz - tworzy nowa dzialke\n");
        builder.append("§7 - /d usun - usuwa dzialke, na ktorej stoisz\n");
        builder.append(
                "§7 - /d publiczna - ustawia status twojej dzialki na publiczna lub niepubliczna.\n");
        builder.append("§7 - /d ukonczona - ustawia status twojej dzialki na ukonczona\n");
        builder.append(
                "§7 - /d dodaj <nick> - dodaje pomocnika do dzialki\n");
        builder.append("§7");
        return builder.toString();
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("dzialka")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("create")
							|| args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("s")) {
                        Set<String> plots = Dogends.getMain().getConfig().getConfigurationSection("Plots." + player.getName()).getKeys(false);
                        int id = plots.size() + 1;
                        Plot plot = new Plot(id, LocationUtils.getMinX(id), LocationUtils.getMinZ(id),
                                LocationUtils.getMaxX(id), LocationUtils.getMaxZ(id), player.getName(), null, true,
                                false);
                        PlotManager.createPlot(plot);
                    }
                } else {
					player.sendMessage(displayHelpMessage());
				}
			} else {
				sender.sendMessage("Na te chwile tylko gracze moga uzywac tej komendy");
			}
		}
		return false;
	}

}

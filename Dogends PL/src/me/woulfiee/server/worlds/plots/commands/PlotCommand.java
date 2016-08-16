package me.woulfiee.server.worlds.plots.commands;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.worlds.plots.utils.LocationUtils;
import me.woulfiee.server.worlds.plots.utils.Plot;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		builder.append("\n §7- /d stworz - tworzy nowa dzialke. Gracz moze miec jedna, VIP moze miec 3\n");
		builder.append("§7 - /d usun - usuwa dzialke, na ktorej stoisz\n");
		builder.append(
				"§7 - /d publiczna - twoja dzialke na publiczna lub niepubliczna.\n   Jezeli jest niepubliczna, nikt nie moze wejsc na nia oprocz\n   ciebie, administracji i pomocnikow dzialki.\n");
		builder.append("§7 - /d ukonczona - ustanawia twoja dzialke ukonczona\n");
		builder.append(
				"§7 - /d dodaj <nick> - dodaje pomocnika do dzialki. Gracz moze miec ich nie wiecej niz pieciu. VIP moze miec ich dziesieciu\n");
		builder.append("§7");
		return builder.toString();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("dzialka")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length >= 1) {
					for (String plotName : Dogends.getMain().getConfig().getConfigurationSection("Plots").getKeys(false)) {
						if (Dogends.getMain().getConfig().contains(plotName)) {
							List<String> plots = Dogends.getMain().getConfig().getStringList("Plots");
							int id = plots.size() + 1;
							new Plot(id, LocationUtils.getMinX(id), LocationUtils.getMinZ(id), LocationUtils.getMaxX(id),
									LocationUtils.getMaxZ(id), player.getName(), null, null, true, false);
						}
					}
				} else {
					player.sendMessage(displayHelpMessage());
				}
			} else {

			}
		}
		return false;
	}

}

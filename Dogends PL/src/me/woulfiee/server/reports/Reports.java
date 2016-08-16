package me.woulfiee.server.reports;

import me.woulfiee.server.chat.ranks.Ranks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * 
 * @author Woulfiee
 *
 */
public class Reports implements CommandExecutor, Listener {

	public HashMap<Player, String> handled = new HashMap<Player, String>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("report")) {
		} else if (label.equalsIgnoreCase("a")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length >= 1) {
					for (Player online : Bukkit.getOnlinePlayers()) {
						if (Ranks.isStaff(online)) {
							if (online.isOnline()) {
								StringBuilder str = new StringBuilder();
								for (int i = 0; i < args.length; i++) {
									str.append(args[i] + " ");
								}
								p.sendMessage(
										"§a" + p.getName() + "§e > §aADMINISTRACJA §e>> " + str.toString().trim());
								online.sendMessage(
										"§a" + p.getName() + "§e > §aADMINISTRACJA §e>> " + str.toString().trim());
								online.sendMessage("§aZeby zajac sie ta sprawa, wpisz §e/handle {USERNAME}");
							} else {
								p.sendMessage("§6[HelpOp] §aNie ma zadnego czlonka administracji na serwerze!");
							}
						}
					}
				} else {
					p.sendMessage("§6[HelpOp] §cUsage: /helpop {question}");
				}
			}
		} else if (label.equalsIgnoreCase("helpop")) {
			if (sender instanceof Player) {
				if (args.length >= 1) {

				}
			}
		} else if (label.equalsIgnoreCase("handle")) {

		} else if (label.equalsIgnoreCase("ar")) {

		}
		return false;
	}

}

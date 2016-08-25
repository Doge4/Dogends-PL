package me.woulfiee.server.reports;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

public class HelpOP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("helpop")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length >= 1) {
					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
						builder.append(args[i] + " ");
					}
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (Ranks.isStaff(p)) {
							p.sendMessage("§6§l" + player.getName() + " -> Administracja >> §e§l"
									+ builder.toString().trim());

						}
					}
					List<String> reports = Dogends.getMain().getConfig().getStringList("Reports");
					reports.add(builder.toString().trim());
					Dogends.getMain().getConfig().set("Reports", reports);
					Dogends.getMain().saveConfig();
					player.sendMessage("§6§lTy -> Administracja >> §e§l" + builder.toString().trim());
				} else {
					player.sendMessage("§6[HelpOP] §cZa malo argumentow! Uzycie: §e/helpop <wiadomosc>.");
				}
			} else {
				sender.sendMessage("Tylko gracze moga uzywac tej komedy!");
			}

		} else if (command.getName().equalsIgnoreCase("helpopreply")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (args.length > 1) {
						StringBuilder builder = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
							builder.append(args[i] + " ");
						}
						if (Bukkit.getPlayer(args[0]) != null) {
							Player targetPlayer = Bukkit.getPlayer(args[0]);
							targetPlayer.sendMessage("§6§lAdministracja -> Ty >> §e§l" + builder.toString().trim());
							for (Player onlineplayers : Bukkit.getOnlinePlayers()) {
								if (Ranks.isStaff(onlineplayers)) {
									onlineplayers.sendMessage("§6§lAdministracja -> " + targetPlayer.getName()
											+ " >> §e§l" + builder.toString().trim());
								}
							}
						} else {
							player.sendMessage("§6[HelpOP] §cGracza nie ma na serwerze!");
						}
					} else {
						player.sendMessage("§6[HelpOP] §cZa malo argumentow! Uzycie: §e/hr <gracz> <wiadomosc>");
					}
				} else {
					player.sendMessage("§6[HelpOP] §cNie masz pozwolenia");
				}
			} else {
				if (args.length > 1) {
					StringBuilder builder = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						builder.append(args[i] + " ");
					}
					if (Bukkit.getPlayer(args[0]) != null) {
						Player targetPlayer = Bukkit.getPlayer(args[0]);
						targetPlayer.sendMessage("§6§lAdministracja -> Ty >> §e§l" + builder.toString().trim());
						for (Player onlineplayers : Bukkit.getOnlinePlayers()) {
							if (Ranks.isStaff(onlineplayers)) {
								onlineplayers.sendMessage("§6§lAdministracja -> " + targetPlayer.getName() + " >> §e§l"
										+ builder.toString().trim());
							}
						}
						System.out.println("[HelpOP] " + targetPlayer.getName() + ": " + builder.toString().trim());
					} else {
						sender.sendMessage("§6[HelpOP] §cGracza nie ma na serwerze!");
					}
				} else {
					sender.sendMessage("§6[HelpOP] §cZa malo argumentow! Uzycie: §e/hr <gracz> <wiadomosc>");
				}
			}
		}
		return false;
	}

}

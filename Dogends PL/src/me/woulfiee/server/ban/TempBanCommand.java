/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.ban;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * 
 * @author Woulfiee
 *
 */
public class TempBanCommand implements CommandExecutor {

	public static HashMap<String, Long> banned = new HashMap<String, Long>();

	public static String getMSG(long endOfBan) {
		String message = "";

		long now = System.currentTimeMillis();
		long diff = endOfBan - now;
		int seconds = (int) (diff / 1000L);
		if (seconds >= 86400) {
			int days = seconds / 86400;
			seconds %= 86400;

			message = message + days + " Dzie§ (Dni) ";
		}
		if (seconds >= 3600) {
			int hours = seconds / 3600;
			seconds %= 3600;

			message = message + hours + " Godzin (Godziny) ";
		}
		if (seconds >= 60) {
			int min = seconds / 60;
			seconds %= 60;

			message = message + min + " Minut (Minuty) ";
		}
		if (seconds >= 0) {
			message = message + seconds + " Sekund (Sekundy) ";
		}
		return message;
	}

	public HashMap<String, Long> getBanned() {
		return banned;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String desc, String[] args) {
		if ((sender instanceof Player)) {
			Player player = (Player) sender;
			if (command.getName().equalsIgnoreCase("tempban")) {
				if (args.length != 3) {
					player.sendMessage("§6[Ban] §cZa du§o/ma§o argument§w!");
				} else {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (!(Ranks.getAdmins().contains(player.getUniqueId().toString())
							|| Ranks.getMods().contains(player.getUniqueId().toString())
							|| Ranks.getOwners().contains(player.getUniqueId().toString()))) {
						player.sendMessage("§6[Ban] §cNie masz pozwolenia!");
					} else {
						OfflinePlayer targetp = Bukkit.getServer().getOfflinePlayer(args[0]);
						long endOfBan = System.currentTimeMillis()
								+ BanUnit.getTicks(args[2], Integer.parseInt(args[1]));

						long now = System.currentTimeMillis();
						long diff = endOfBan - now;
						if (diff > 0L) {
							setBanned(targetp.getName().toLowerCase(), endOfBan);

							String message = getMSG(endOfBan);

							Bukkit.getServer()
									.broadcastMessage("§6[Ban] " + ChatColor.GREEN + "Gracz " + ChatColor.AQUA
											+ targetp.getName() + ChatColor.GREEN + " zostal zbanowany na "
											+ ChatColor.AQUA + message);
							target.kickPlayer("[Ban] Zostales tymczasowo zbanowany na " + message);
						}
						player.sendMessage(ChatColor.RED + "Blad: Jednostka czasu lub czas jest nieprawidlowy.");
					}
				}
			}
		} else {
			if (command.getName().equalsIgnoreCase("tempban")) {
				if (args.length != 3) {
					sender.sendMessage("§6[Ban] §cZa duzo/malo argumentow!");
				} else {
					OfflinePlayer targetp = Bukkit.getServer().getOfflinePlayer(args[0]);
					long endOfBan = System.currentTimeMillis() + BanUnit.getTicks(args[2], Integer.parseInt(args[1]));

					long now = System.currentTimeMillis();
					long diff = endOfBan - now;
					if (diff > 0L) {
						setBanned(targetp.getName().toLowerCase(), endOfBan);

						String message = getMSG(endOfBan);

						for (Player p : Bukkit.getOnlinePlayers()) {
							if (!(Ranks.getAdmins().contains(p.getUniqueId().toString())
									|| Ranks.getMods().contains(p.getUniqueId().toString())
									|| Ranks.getOwners().contains(p.getUniqueId().toString()))) {
								p.sendMessage("§6[Ban] §e" + p.getName() + " §azbanowal §e" + targetp.getName()
										+ " §ado §e" + getMSG(endOfBan) + "§a!");
							}
						}
						if (targetp.isOnline()) {
							sender.getServer().getPlayer(args[0]).kickPlayer("[Ban] Zostales zbanowany na " + message);
						}
					}
					sender.sendMessage(ChatColor.RED + "Blad: Jednostka czasu lub czas jest nieprawidlowy.");
				}
			}

		}
		return false;
	}

	public void setBanned(String name, long end) {
		getBanned().put(name, Long.valueOf(end));
	}

}

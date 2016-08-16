package me.woulfiee.server.chat.commands;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.scoreboard.Sb;
import me.woulfiee.server.scoreboard.ScoreboardUpdateType;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class Setrank implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("setrank")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isOwner(p) || p.getName().equals("Woulfiee")) {
					if (args.length >= 2) {
						OfflinePlayer p2 = p.getServer().getOfflinePlayer(args[0]);
						if (p2 != null) {
							if (args[1].equalsIgnoreCase("gracz")) {
								Ranks.setPlayer(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga gracz zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("vip")) {
								Ranks.setVip(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage("§6[Rangi] §aRanga VIP zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("youtuber")) {
								Ranks.setYoutuber(p);

								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga YouTuber zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("budowniczy")) {
								Ranks.setBuilder(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga Budowniczy zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("mod")) {
								Ranks.setMod(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga Moderator zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("admin")) {
								Ranks.setAdmin(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga Admin zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else if (args[1].equalsIgnoreCase("wlasciciel")) {
								Ranks.setOwner(p);
								for (Player online : Bukkit.getOnlinePlayers())
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								p.sendMessage(
										"§6[Rangi] §aRanga Wlasciciel zostala ustawiona dla §e" + p2.getName() + "§a!");
							} else {
								p.sendMessage("§6[Rangi] §cNie znaleziono rangi!");
							}
						}
					} else {
						p.sendMessage("§6[Rangi] §cZa malo argumentow! Uzycie: /setrank <gracz> <ranga>");
					}
				} else {
					p.sendMessage("§6[Rangi] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 2) {
					OfflinePlayer p2 = sender.getServer().getOfflinePlayer(args[0]);
					if (p2 != null) {
						if (args[1].equalsIgnoreCase("gracz")) {
							Ranks.setPlayer(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga gracz zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("piesel")) {
							Ranks.setVip(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga Piesel zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("youtuber")) {
							Ranks.setYoutuber(p2);

							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga YouTuber zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("budowniczy")) {
							Ranks.setBuilder(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga Budowniczy zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("mod")) {
							Ranks.setMod(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga Moderator zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("admin")) {
							Ranks.setAdmin(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga Admin zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else if (args[1].equalsIgnoreCase("wlasciciel")) {
							Ranks.setOwner(p2);
							for (Player online : Bukkit.getOnlinePlayers())
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							sender.sendMessage(
									"§6[Rangi] §aRanga Wlasciciel zostala ustawiona dla §e" + p2.getName() + "§a!");
						} else {
							sender.sendMessage("§6[Rangi] §cNie znaleziono rangi!");
						}
					}
				} else {
					sender.sendMessage("§6[Rangi] §cZa malo argumentow! Uzycie: /setrank <gracz> <ranga>");
				}
			}
		}
		return false;
	}

}

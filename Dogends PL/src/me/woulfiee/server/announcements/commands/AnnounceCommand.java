/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.announcements.commands;

import me.woulfiee.server.announcements.utils.PacketUtils;
import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class AnnounceCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("ann")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isAdmin(p) || Ranks.isOwner(p)) {
					if (args.length > 1) {
						StringBuilder str = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
							str.append(args[i] + " ");
						}
						if (args[0].equalsIgnoreCase("title")) {
							for (Player player : Bukkit.getOnlinePlayers()) {
                                PacketUtils.sendTitle(player, str.toString().trim().replaceAll("&", "§"));
                            }
                            Bukkit.broadcastMessage(
                                    "§8§l>>> §r" + str.toString().trim().replaceAll("&", "§") + " §8§l<<<");

						} else if (args[0].equalsIgnoreCase("subtitle")) {
							for (Player player : Bukkit.getOnlinePlayers()) {
                                PacketUtils.sendSubtitle(player, str.toString().trim().replaceAll("&", "§"));
                            }
                        } else if (args[0].equalsIgnoreCase("text")) {
							Bukkit.broadcastMessage(
                                    "§8§l>>> §r" + str.toString().trim().replaceAll("&", "§") + " §8§l<<<");
                        } else {
                            p.sendMessage("§6[Ogloszenia] §cWpisz title, subtitle lub text!");
                        }
                    } else {
                        p.sendMessage("§6[Ogloszenia] §cZa malo argumentow! Uzycie: /ann <title/subtitle/text>");
                    }
                } else {
                    sender.sendMessage("§6[Ogloszenia] §cNie masz pozwolenia!");
                }
            } else {
				if (args.length > 1) {
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						str.append(args[i] + " ");
					}
					if (args[0].equalsIgnoreCase("tytul")) {
						for (Player player : Bukkit.getOnlinePlayers()) {
                            PacketUtils.sendTitle(player, str.toString().trim().replaceAll("&", "§"));
                        }
                        Bukkit.broadcastMessage("§8§l>>> §r" + str.toString().trim().replaceAll("&", "§") + " §8§l<<<");

					} else if (args[0].equalsIgnoreCase("podtytul")) {
						for (Player player : Bukkit.getOnlinePlayers()) {
                            PacketUtils.sendSubtitle(player, str.toString().trim().replaceAll("&", "§"));
                        }
                    } else if (args[0].equalsIgnoreCase("tekst")) {
                        Bukkit.broadcastMessage("§8§l>>> §r" + str.toString().trim().replaceAll("&", "§") + " §8§l<<<");
                    }
                } else {
                    sender.sendMessage("§6[Ogloszenia] §cZa malo argumentow!");
                }
            }
		}

		return false;
	}

}

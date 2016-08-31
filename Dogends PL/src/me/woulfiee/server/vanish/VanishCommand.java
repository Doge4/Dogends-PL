/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.vanish;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.scoreboard.Sb;
import me.woulfiee.server.scoreboard.ScoreboardUpdateType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;

/**
 * 
 * @author Woulfiee
 *
 */
public class VanishCommand implements CommandExecutor {

	public static HashSet<String> vanished = new HashSet<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("vanish")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (args.length == 0) {
						if (!vanished.contains(player.getName())) {
							vanished.add(player.getName());
							player.setPlayerListName(null);
							player.setCanPickupItems(false);
                            player.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                online.hidePlayer(player);
								Sb.update(online, ScoreboardUpdateType.HID);
							}
						} else {
							vanished.remove(player.getName());
							player.setPlayerListName(player.getName());
							player.setCanPickupItems(true);
                            player.sendMessage("§6[Vanish] §aStales sie widoczny!");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                online.showPlayer(player);
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							}
						}
					} else if (args.length >= 1) {
						Player targetPlayer = Bukkit.getPlayer(args[0]);
						if (targetPlayer != null) {
							if (!vanished.contains(targetPlayer.getName())) {
								targetPlayer.setPlayerListName(null);
								vanished.add(targetPlayer.getName());
								targetPlayer.setCanPickupItems(false);
                                player.sendMessage("§6[Vanish] §aGracz stal sie niewidoczny!");
                                targetPlayer.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
                                for (Player online : Bukkit.getOnlinePlayers()) {
                                    online.hidePlayer(targetPlayer);
									Sb.update(online, ScoreboardUpdateType.HID);
								}
							} else {
								vanished.remove(targetPlayer.getName());
								targetPlayer.setPlayerListName(targetPlayer.getName());
								targetPlayer.setCanPickupItems(true);
                                player.sendMessage("§6[Vanish] §aGracz stal sie widoczny!");
                                targetPlayer.sendMessage("§6[Vanish] §aStales sie widoczny!");
                                for (Player online : Bukkit.getOnlinePlayers()) {
                                    online.showPlayer(targetPlayer);
									Sb.update(online, ScoreboardUpdateType.NORMAL);
								}
							}
						} else {
                            player.sendMessage("§6[Vanish] §cGracz nie jest online!");
                        }
                    }
				}
			} else {
				if (args.length >= 1) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					if (targetPlayer != null) {
						if (!vanished.contains(targetPlayer.getName())) {
							targetPlayer.setPlayerListName(null);
							vanished.add(targetPlayer.getName());
							targetPlayer.setCanPickupItems(false);
                            sender.sendMessage("§6[Vanish] §aGracz stal sie niewidoczny!");
                            targetPlayer.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                online.hidePlayer(targetPlayer);
								Sb.update(online, ScoreboardUpdateType.HID);
							}
						} else {
							vanished.remove(targetPlayer.getName());
							targetPlayer.setPlayerListName(targetPlayer.getName());
							targetPlayer.setCanPickupItems(true);
                            sender.sendMessage("§6[Vanish] §aGracz stal sie widoczny!");
                            targetPlayer.sendMessage("§6[Vanish] §aStales sie widoczny!");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                online.showPlayer(targetPlayer);
								Sb.update(online, ScoreboardUpdateType.NORMAL);
							}
						}
					} else {
                        sender.sendMessage("§6[Vanish] §cGracz nie jest online!");
                    }
                } else {
                    sender.sendMessage("§6[Vanish] §cMusisz byc graczem!");
                }
            }
		}
		return false;
	}

}

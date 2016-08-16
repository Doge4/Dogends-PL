package me.woulfiee.server.vanish;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.scoreboard.Sb;
import me.woulfiee.server.scoreboard.ScoreboardUpdateType;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class VanishCommand implements CommandExecutor {

	public static List<String> vanished = new ArrayList<String>();

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
							player.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.hidePlayer(player);
								Sb.update(online, ScoreboardUpdateType.HID);
							}
						} else {
							vanished.remove(player.getName());
							player.setPlayerListName(player.getName());
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
								player.sendMessage("§6[Vanish] §aGracz stal sie niewidoczny!");
								targetPlayer.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.hidePlayer(targetPlayer);
									Sb.update(online, ScoreboardUpdateType.HID);
								}
							} else {
								vanished.remove(targetPlayer.getName());
								targetPlayer.setPlayerListName(targetPlayer.getName());
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
							sender.sendMessage("§6[Vanish] §aGracz stal sie niewidoczny!");
							targetPlayer.sendMessage("§6[Vanish] §aStales sie niewidoczny!");
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.hidePlayer(targetPlayer);
								Sb.update(online, ScoreboardUpdateType.HID);
							}
						} else {
							vanished.remove(targetPlayer.getName());
							targetPlayer.setPlayerListName(targetPlayer.getName());
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

	@EventHandler
	public void pickupItems(PlayerPickupItemEvent e) {
		if (e.getPlayer().getWorld().getName().equals("spawn")) {
			e.setCancelled(true);
		}
	}

}

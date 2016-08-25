package me.woulfiee.server.teleportation.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class TPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("tp")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {
					if (args.length == 1) {
						Player targetPlayer = p.getServer().getPlayer(args[0]);
						Location targetPlayerLocation = targetPlayer.getLocation();
						if (targetPlayer.isOnline()) {
							p.teleport(targetPlayerLocation);
							p.sendMessage("§6[TP] §aZostales przeteleportowany do §e" + targetPlayer.getName() + "§e!");
						} else {
							p.sendMessage("§6[TP] §cGracz §e" + targetPlayer.getName() + " §cnie jest online!");
						}
					} else if (args.length == 2) {
						Player player = p.getServer().getPlayer(args[0]);
						Player targetPlayer = p.getServer().getPlayer(args[1]);
						if (player.isOnline()) {
							if (targetPlayer.isOnline()) {

								Location targetPlayerLocation = targetPlayer.getLocation();
								player.teleport(targetPlayerLocation);
								p.sendMessage("§6[TP] §e" + player.getName() + " §azostal przeteleportowany do §e"
										+ targetPlayer.getName() + "§e!");
								player.sendMessage(
										"§6[TP] §aZostales przeteleportowany do §e" + targetPlayer.getName() + "§a!");
								targetPlayer.sendMessage(
										"§6[TP] §e" + player.getName() + " §azostal przeteleportowany do §eCiebie§a!");
							} else {
								p.sendMessage("§6[TP] §e" + targetPlayer.getName() + " §cnie jest online!");
							}
						} else {
							p.sendMessage("§6[TP] §e" + player.getName() + " §cnie jest online!");
						}
					} else if (args.length == 3) {
						int x = Integer.parseInt(args[0]);
						int y = Integer.parseInt(args[1]);
						int z = Integer.parseInt(args[2]);
						p.teleport(new Location(p.getLocation().getWorld(), x, y, z));
						p.sendMessage("§6[TP] §aPrzeteleportowales sie na koordynaty §eX: " + x + "§a, §eY: " + y
								+ "§a, §eZ: " + z + "§a!");
					} else if (args.length >= 4) {
						Player targetPlayer = Bukkit.getPlayer(args[0]);
						int x = Integer.parseInt(args[1]);
						int y = Integer.parseInt(args[2]);
						int z = Integer.parseInt(args[3]);
						if (targetPlayer.isOnline()) {
							World tpWorld = targetPlayer.getLocation().getWorld();
							World pWorld = p.getLocation().getWorld();
							if (tpWorld == pWorld) {
								targetPlayer.teleport(new Location(p.getLocation().getWorld(), x, y, z));
								targetPlayer.sendMessage("§6[TP] §aPrzeteleportowales sie na koordynaty §eX: " + x
										+ "§a, §eY: " + y + "§a, §eZ: " + z + "§a!");
								targetPlayer.sendMessage("§6[TP] §aPrzeteleportowano gracza na koordynaty §eX: " + x
										+ "§a, §eY: " + y + "§a, §eZ: " + z + "§a!");
							} else {
								p.sendMessage("§6[TP] §cTy i gracz musicie byc w tych samych swiatach!");
							}
						}
					} else {
						p.sendMessage("§6[TP] §cZa malo argumentow! Uzycia: /tp <gracz/x> [gracz/y] [z]");
					}
				} else {
					p.sendMessage("§6[TP] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length == 2) {
					Player player = sender.getServer().getPlayer(args[0]);
					Player targetPlayer = sender.getServer().getPlayer(args[1]);
					if (player.isOnline()) {
						if (targetPlayer.isOnline()) {

							Location targetPlayerLocation = targetPlayer.getLocation();
							player.teleport(targetPlayerLocation);
							sender.sendMessage("§6[TP] §e" + player.getName() + " §azostal przeteleportowany do §e"
									+ targetPlayer.getName() + "§e!");
							player.sendMessage(
									"§6[TP] §aZostales przeteleportowany do §e" + targetPlayer.getName() + "§a!");
							targetPlayer.sendMessage(
									"§6[TP] §e" + player.getName() + " §azostal przeteleportowany do §eCiebie§a!");
						} else {
							sender.sendMessage("[TP] §e" + targetPlayer.getName() + " §cnie jest online!");
						}
					} else {
						sender.sendMessage("[TP] §e" + player.getName() + " §cnie jest online!");
					}
				} else if (args.length >= 4) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					int x = Integer.parseInt(args[1]);
					int y = Integer.parseInt(args[2]);
					int z = Integer.parseInt(args[3]);
					if (targetPlayer.isOnline()) {
						targetPlayer.teleport(new Location(targetPlayer.getLocation().getWorld(), x, y, z));
						targetPlayer.sendMessage("§6[TP] §aPrzeteleportowales sie na koordynaty §eX: " + x + "§a, §eY: "
								+ y + "§a, §eZ: " + z + "§a!");
						targetPlayer.sendMessage("§6[TP] §aPrzeteleportowano gracza na koordynaty §eX: " + x
								+ "§a, §eY: " + y + "§a, §eZ: " + z + "§a!");
					}
				} else {
					sender.sendMessage("§6[TP] §cZa malo argumentow! Uzycia: /tp <gracz/x> [gracz/y] [z]");
				}
			}
		}

		return false;
	}

}

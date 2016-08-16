package me.woulfiee.server.worlds.commands;

import me.woulfiee.server.chat.ranks.Ranks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class GoToCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("wgoto")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player) || Ranks.isBuilder(player)) {
					if (args.length == 1) {
						World world = Bukkit.getWorld(args[0]);
						if (world != null) {
							player.teleport(new Location(world, world.getSpawnLocation().getX(),
									world.getSpawnLocation().getY(), world.getSpawnLocation().getZ()));
							player.sendMessage(
									"§6[TP] §aZostales przeteleportowany do swiata §e" + world.getName() + "§a!");
						} else {
							player.sendMessage("§6[TP] §cTen swiat nie istnieje!");
						}
					} else if (args.length >= 2) {
						Player targetPlayer = Bukkit.getPlayer(args[1]);
						World world = Bukkit.getWorld(args[0]);
						if (world != null) {
							if (targetPlayer != null) {
								targetPlayer.teleport(new Location(world, world.getSpawnLocation().getX(),
										world.getSpawnLocation().getY(), world.getSpawnLocation().getZ()));
								targetPlayer.sendMessage(
										"§6[TP] §aZostales przeteleportowany do swiata §e" + world.getName() + "§a!");
							} else {
								player.sendMessage("§6[TP] §e" + args[1] + "§c nie jest online!");
							}
						} else {
							player.sendMessage("§6[TP] §cTen swiat nie istnieje!");
						}
					} else {
						player.sendMessage("§6[TP] §cZa malo argumentow!");
					}
				} else {
					player.sendMessage("§6[TP] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 2) {
					Player targetPlayer = Bukkit.getPlayer(args[1]);
					World world = Bukkit.getWorld(args[0]);
					if (world != null) {
						if (targetPlayer != null) {
							targetPlayer.teleport(new Location(world, world.getSpawnLocation().getX(),
									world.getSpawnLocation().getY(), world.getSpawnLocation().getZ()));
							targetPlayer.sendMessage(
									"§6[TP] §aZostales przeteleportowany do swiata §e" + world.getName() + "§a!");
						} else {
							sender.sendMessage("§6[TP] §e" + args[1] + "§c nie jest online!");
						}
					} else {
						sender.sendMessage("§6[TP] §cTen swiat nie istnieje!");
					}
				} else {
					sender.sendMessage("§6[TP] §cZa malo argumentow!");
				}
			}
		}
		return false;
	}

}

package me.woulfiee.server.op;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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
public class OPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("op")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isOwner(player)) {
					if (args.length >= 1) {
						OfflinePlayer targetPlayer = Bukkit.getOfflinePlayer(args[0]);
						if (!targetPlayer.isOp()) {
							targetPlayer.setOp(true);
							player.sendMessage("§6[OP] §aGracz stal sie operatorem!");
						} else {
							player.sendMessage("§6[OP] §cGracz juz jest operatorem!");
						}
					} else {
						player.sendMessage("§6[OP] §cZa malo argumentow!");
					}
				} else {
					player.sendMessage("§6[OP] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 1) {
					OfflinePlayer targetPlayer = Bukkit.getOfflinePlayer(args[0]);
					if (!targetPlayer.isOp()) {
						targetPlayer.setOp(true);
						sender.sendMessage("§6[OP] §aGracz stal sie operatorem!");
					} else {
						sender.sendMessage("§6[OP] §cGracz juz jest operatorem!");
					}
				} else {
					sender.sendMessage("§6[OP] §cZa malo argumentow!");
				}
			}
		}
		return false;
	}

}

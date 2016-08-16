package me.woulfiee.server.op;

import me.woulfiee.server.chat.ranks.Ranks;

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
public class DeOPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("deop")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isOwner(player)) {
					if (args.length >= 1) {
						OfflinePlayer targetPlayer = Bukkit.getOfflinePlayer(args[0]);
						if (targetPlayer.isOp()) {
							targetPlayer.setOp(false);
							player.sendMessage("§6[OP] §aGraczowi odebrano uprawnienia operatora!");
						} else {
							player.sendMessage("§6[OP] §cGracz nie jest operatorem!");
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
					if (targetPlayer.isOp()) {
						targetPlayer.setOp(false);
						sender.sendMessage("§6[OP] §aGraczowi odebrano uprawnienia operatora!");
					} else {
						sender.sendMessage("§6[OP] §cGracz nie jest operatorem!");
					}
				} else {
					sender.sendMessage("§6[OP] §cZa malo argumentow!");
				}
			}
		}
		return false;
	}

}

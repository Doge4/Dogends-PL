package me.woulfiee.server.kick;

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
public class KickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("kick")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {
					if (args.length >= 2) {
						if (Ranks.isOtherRank(p)) {
							StringBuilder str = new StringBuilder();
							for (int i = 1; i < args.length; i++) {
								str.append(args[i] + " ");
							}
							Player player = p.getServer().getPlayer(args[0]);
							if (player != null) {
								player.kickPlayer(
										"§6§lDOGENDS\n\n       §cZostales wyrzucony z serwera! \n\n\nWyrzucajacy: §e"
												+ p.getName() + "\n§cPowod: §e" + str.toString().trim() + "§c!");
							} else {
								sender.sendMessage("§6[Kick] §cTen gracz nie jest online!");
							}
						} else {
							sender.sendMessage("§6[Kick] §cNie mozesz wyrzucic tego gracza!");
						}
					} else {
						sender.sendMessage("§6[Kick] §cZa malo argumentow! Musisz podac gracza i powod!");
					}
				} else {
					sender.sendMessage("§6[Kick] §cNie masz pozwolenia!");
				}

			} else {
				if (args.length > 1) {
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						str.append(args[i] + " ");
					}
					Player player = sender.getServer().getPlayer(args[0]);
					if (player != null) {
						player.kickPlayer("§6§lDOGENDS\n\n       §cZostales wyrzucony z serwera! \n\n\nWyrzucajacy: §e"
								+ sender.getName() + "\n§cPowod: §e" + str.toString().trim() + "§c!");
					} else {
						sender.sendMessage("§6[Kick] §cTen gracz nie jest online!");
					}
				} else {
					sender.sendMessage("§6[Kick] §cZa malo argumentow! Musisz podac gracza i powod!");
				}
			}
		}
		return false;
	}

}

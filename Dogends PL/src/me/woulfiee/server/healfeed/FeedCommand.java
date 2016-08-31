/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.healfeed;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class FeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if (cmd.getName().equalsIgnoreCase("feed")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§6[Nakarm] §cTylko gracze moga uzywac tej komendy!");
			} else {
				Player p = (Player) sender;
				if (!(Ranks.isStaff(p))) {
					p.sendMessage("§6[Nakarm] §cNie masz pozwolenia!");
				} else {
					if (args.length == 0) {
						p.setHealth(20);
						p.setFoodLevel(20);
						p.sendMessage("§6[Nakarm] §aZostales nakarmiony!");

					} else if (args.length == 1) {
						Player tp = p.getServer().getPlayer(args[0]);
						if (tp != null) {
							tp.setHealth(20);
							tp.setFoodLevel(20);
							p.sendMessage("§6[Nakarm] §aNakarmiles gracza §e" + tp.getName() + "§a!");
							tp.sendMessage("§6[Nakarm] §aZostales nakarmiony!");
						} else {
							p.sendMessage("§6[Nakarm] §cTen gracz nie jest online!");
						}
					}
				}
			}
		}
		return false;
	}
}
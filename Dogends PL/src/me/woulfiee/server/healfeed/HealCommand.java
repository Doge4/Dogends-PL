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
public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("heal")) {
			if (!(sender instanceof Player)) {
                sender.sendMessage("§6[Ulecz] §cTylko gracze moga uzywac tej komendy!");
            } else {
                Player p = (Player) sender;
				if (!(Ranks.isStaff(p))) {
                    p.sendMessage("§6[Ulecz] §cNie masz pozwolenia!");

				} else {
					if (args.length == 0) {
						p.setHealth(20);
						p.setFoodLevel(20);
                        p.sendMessage("§6[Ulecz] §aZostales uleczony!");

					} else if (args.length == 1) {
						Player tp = p.getServer().getPlayer(args[0]);
						if (tp != null) {
							tp.setHealth(20);
							tp.setFoodLevel(20);
                            p.sendMessage("§6[Ulecz] §aUleczyles §e" + tp.getName() + "§a!");
                            tp.sendMessage("§6[Ulecz] §aZostales uleczony!");
                        } else {
                            p.sendMessage("§6[Ulecz] §cTen gracz nie jest online!");
                        }
                    }
				}
			}
		}
		return false;
	}
}
/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.ban;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;
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
public class UnbanCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("unban")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {
					if (args.length == 1) {
						Player targetPlayer = sender.getServer().getPlayerExact(args[0]);
						Dogends.getMain().getConfig().set("Banned." + targetPlayer.getName(), null);
						Dogends.getMain().saveConfig();
                        p.sendMessage("§6[Ban] §aGracz odbanowany!");

					} else {
                        p.sendMessage("§6[Ban] §cZa malo argumentow!");
                    }
                } else {
                    p.sendMessage("§6[Ban] §cNie masz pozwolenia!");
                }
            } else {
				if (args.length == 1) {
					OfflinePlayer targetPlayer = sender.getServer().getOfflinePlayer(args[0]);
					Dogends.getMain().getConfig().set("Banned." + targetPlayer.getName(), null);
					Dogends.getMain().saveConfig();
                    sender.sendMessage("§6[Ban] §aGracz odbanowany!");
                } else {
                    sender.sendMessage("§6[Ban] §cZa malo argumentow!");
                }
            }
		}
		return false;
	}

}

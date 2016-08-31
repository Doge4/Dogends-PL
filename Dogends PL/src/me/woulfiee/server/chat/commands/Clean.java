/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.chat.commands;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class Clean implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("cc")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						for (int i = 0; i < 100; i++)
							p.sendMessage("\n");
					}
                    Bukkit.broadcastMessage("§8§l>> §aCzat zostal wyczyszczony przez §e" + player.getName() + "§a!");
                } else {
                    player.sendMessage("§6[ChatCleaner] §cNie masz pozwolenia!");
                }
            } else {
				for (Player p : Bukkit.getOnlinePlayers()) {
					for (int i = 0; i < 100; i++)
						p.sendMessage("\n");
				}
                Bukkit.broadcastMessage("§8§l>> §aCzat zostal wyczyszczony przez §e" + sender.getName() + "§a!");
            }
        }
		return false;
	}

}

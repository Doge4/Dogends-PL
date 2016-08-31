/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.broadcast.commands;

import me.woulfiee.server.broadcast.Broadcaster;
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
public class ToggleBroadcast extends Broadcaster implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("tb")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isOwner(player)) {
					if (running == 1) {
						Bukkit.getScheduler().cancelTask(tid);
						running = 0;
                        sender.sendMessage("§6[Broadcast] §aWylaczyles broadcast!");
                        for (Player p : Bukkit.getOnlinePlayers())
                            if (Ranks.isStaff(p)) {
                                p.sendMessage("§6[Broadcast] §aBroadcast zostal wylaczony!");
                            }
                    } else {
						runBroadcast();
						running = 1;
                        sender.sendMessage("§6[Broadcast] §aWlaczyles broadcast!");
                        for (Player p : Bukkit.getOnlinePlayers())
                            if (Ranks.isStaff(p)) {
                                p.sendMessage("§6[Broadcast] §aBroadcast zostal wlaczony!");
                            }
                    }
				}
			} else {
				if (running == 1) {
					Bukkit.getScheduler().cancelTask(tid);
					running = 0;
                    sender.sendMessage("§6[Broadcast] §aWylaczyles broadcast!");
                    for (Player p : Bukkit.getOnlinePlayers())
                        if (Ranks.isStaff(p)) {
                            p.sendMessage("§6[Broadcast] §aBroadcast zostal wylaczony!");
                        }
                } else {
					runBroadcast();
					running = 1;
                    sender.sendMessage("§6[Broadcast] §aWylaczyles broadcast!");
                    for (Player p : Bukkit.getOnlinePlayers())
                        if (Ranks.isStaff(p)) {
                            p.sendMessage("§6[Broadcast] §aBroadcast zostal wylaczony!");
                        }
                }
			}
		}
		return false;
	}
}

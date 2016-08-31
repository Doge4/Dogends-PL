/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.chat.censor;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Woulfiee
 */
public class ToggleCensor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("tcc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (Ranks.isStaff(player)) {
                    if (Censor.toggledOn) {
                        Censor.toggledOn = false;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (Ranks.isStaff(p)) {
                                p.sendMessage("§6[Chat] §cCenzura wylaczona!");
                            }
                        }
                    } else {
                        Censor.toggledOn = true;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (Ranks.isStaff(p)) {
                                sender.sendMessage("§6[Chat] §aCenzura wlaczona!");
                            }
                        }
                    }
                } else {
                    sender.sendMessage("§6[Chat] §cNie masz pozwolenia!");
                }
            } else {
                if (Censor.toggledOn) {
                    Censor.toggledOn = false;
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (Ranks.isStaff(p)) {
                            p.sendMessage("§6[Chat] §cCenzura wylaczona!");
                        }
                    }
                } else {
                    Censor.toggledOn = true;
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (Ranks.isStaff(p)) {
                            sender.sendMessage("§6[Chat] §aCenzura wlaczona!");
                        }
                    }
                }
            }
        }
        return false;
    }

}

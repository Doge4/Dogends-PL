/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.chat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class VIP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("vip")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
                StringBuilder builder = new StringBuilder("§a§m---------------§2 VIP §a§m---------------\n");
                builder.append("§a Ranga ta otrzymuje nastepujace, dodatkowe funkcje:\n");
                builder.append("§a - wlasna ranga;\n");
                builder.append("§a - rozne dodatki w menu kosmetycznym;\n");
                builder.append("§a - mozliwosc aplikowania na moderatora;\n");
                builder.append("§a Nastepne dodatki zostana dodane w przyszlosci!");
                p.sendMessage(builder.toString());
            } else {
				sender.sendMessage("Przeciez ty to wiesz! :)");
			}
		}
		return false;
	}

}

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
public class Moderator implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("mod")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
                StringBuilder builder = new StringBuilder("§e§m------------§6§l MODERATOR §e§m------------\n");
                builder.append("§e Ranga ta otrzymuje nastepujace, dodatkowe funkcje:\n");
                builder.append("§e - wlasna ranga;\n");
                builder.append("§e - bycie respektowanym przez wszystkich;\n");
                builder.append("§e - mozliwosc banowania, wyrzucania, wyciszania graczy i moderacji czatu;\n");
                builder.append("§e - dostep do wszystkich zestawow;\n");
                builder.append("§e Nastepne dodatki zostana dodane w przyszlosci!");
                p.sendMessage(builder.toString());
            } else {
				sender.sendMessage("Przeciez ty to wiesz! :)");
			}
		}
		return false;
	}

}

package me.woulfiee.server.tps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.tps.Lag;

/**
 * 
 * @author Woulfiee
 *
 */
public class TPSCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		double tps = Lag.getTPS();
		double percentage = Lag.getLagPercentage(tps);
		if (label.equalsIgnoreCase("tps")) {
			if (sender instanceof Player) {
				if (Ranks.isStaff(((Player) sender))) {
					sender.sendMessage("§6[TPS] §aTPS serwera: §e" + String.valueOf(tps).substring(0, 5));
				}
			} else {
				sender.sendMessage("[TPS] TPS serwera: " + String.valueOf(tps).substring(0, 5));
			}
		} else if (label.equalsIgnoreCase("tpspercentage")) {
			if (sender instanceof Player) {
				if (Ranks.isStaff(((Player) sender))) {
					sender.sendMessage("§6[TPS] §aLagi serwera: §f" + String.valueOf(percentage).substring(0, 5));
				}
			} else {
				sender.sendMessage("[TPS] Lagi serwera: " + String.valueOf(percentage).substring(0, 5));
			}
		}
		return false;
	}

}

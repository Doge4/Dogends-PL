package me.woulfiee.server.chat.censor;

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
public class ToggleCensor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("tcc")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (Censor.toggle.contains("on")) {
						Censor.toggle.clear();
						for (Player p : Bukkit.getOnlinePlayers())
							if (Ranks.getAdmins().contains(p.getUniqueId().toString())
									|| Ranks.getMods().contains(p.getUniqueId().toString())
									|| Ranks.getOwners().contains(p.getUniqueId().toString())) {
								p.sendMessage("§6[Chat] §cCenzura wylaczona!");
							}
					} else {
						Censor.toggle.add("on");
						sender.sendMessage("§6[Chat] §aCenzura wlaczona!");
					}
				} else {
					sender.sendMessage("§6[Chat] §cnie masz pozwolenia!");
				}
			} else {
				if (Censor.toggle.contains("on")) {
					Censor.toggle.clear();
					for (Player p : Bukkit.getOnlinePlayers())
						if (Ranks.getAdmins().contains(p.getUniqueId().toString())
								|| Ranks.getMods().contains(p.getUniqueId().toString())
								|| Ranks.getOwners().contains(p.getUniqueId().toString())) {
							p.sendMessage("§6[Chat] §cCenzura wylaczona!");
						}
				} else {
					Censor.toggle.add("on");
					sender.sendMessage("§6[Chat] §aCenzura wlaczona!");
				}
			}
		}
		return false;
	}

}

package me.woulfiee.server.ban;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

/**
 * 
 * @author Woulfiee
 *
 */
public class BanCommand implements CommandExecutor, Listener {

	static String reason;

	/**
	 * Gets a banned player's ban reason
	 * 
	 * @param name
	 * @return ban reason
	 */
	public static String getReason(String name) {
		reason = Dogends.getMain().getConfig().getString("Banned." + name + ".Reason");
		return reason;
	}

	/**
	 * Checks if a player is banned
	 * 
	 * @param name
	 * @return true, if player is banned, otherwise false
	 */
	public static boolean isBanned(String name) {
		if (getReason(name) != null) {
			if (Dogends.getMain().getConfig().contains("Banned." + name)) {
				return true;
			}
		}
		return false;
	}

	public HashMap<String, String> banned = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("ban")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {
					if (args.length > 1) {
						Player targetPlayer = p.getServer().getPlayerExact(args[0]);
						if (Ranks.isOtherRank(targetPlayer)) {
							StringBuilder str = new StringBuilder();
							for (int i = 1; i < args.length; i++) {
								str.append(args[i] + " ");
							}
							reason = str.toString().trim();
							setReason(targetPlayer.getName(), reason, p.getName());
							if (targetPlayer.isOnline()) {
								targetPlayer.kickPlayer(
										"§6§lDOGENDS\n\n        §cZostales zbanowany do odwolania! \n\n\nBanujacy: §e"
												+ Dogends.getMain().getConfig().getString("Banned." + p.getName() + ".Who")
												+ "\n§cPowod: §e" + getReason(p.getName()) + "§c!");
							}
						} else {
							sender.sendMessage("§6[Ban] §cNie mozesz zbanowac tego gracza!");
						}
					} else {
						sender.sendMessage("§6[Ban] §cZa malo argumentow, musisz podac gracza i powod!");
					}
				} else {
					sender.sendMessage("§6[Ban] §cNie masz pozwolenia!");
				}

			} else {
				if (args.length > 1) {
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						str.append(args[i] + " ");
					}
					Player targetPlayer = sender.getServer().getPlayer(args[0]);
					reason = str.toString().trim();
					setReason(targetPlayer.getName(), reason, sender.getName());
					if (targetPlayer.isOnline())
						targetPlayer.kickPlayer(
								"§6§lDOGENDS\n\n       §cZostales zbanowany do odwolania! \n\n\nBanujacy: §eCONSOLE\n§cPowod: §e"
										+ getReason(targetPlayer.getName()) + "§c!");
				} else {
					sender.sendMessage("§6[Ban] §cZa malo argumentow!");
				}
			}
		}
		return false;
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if (isBanned(e.getPlayer().getName())) {

			e.disallow(Result.KICK_BANNED,
					"§6§lDOGENDS\n\n       §cZostales zbanowany do odwolania! \n\n\nBanujacy: §e"
							+ Dogends.getMain().getConfig().getString("Banned." + e.getPlayer().getName() + ".Who") + "\n§cPowod: §e"
							+ getReason(e.getPlayer().getName()) + "§c!");
			System.out.println("[DBAN] Zbanowany gracz, " + e.getPlayer().getDisplayName()
					+ ", chcial sie polaczyc z serwerem. Polaczenie odrzucono.");
		} else {
			e.allow();
		}
	}

	/**
	 * Sets the ban reason
	 * 
	 * @param name
	 * @param banreason
	 * @param who
	 */
	public void setReason(String name, String banreason, String who) {
		reason = banreason;
		Dogends.getMain().getConfig().set("Banned." + name + ".Who", who);
		Dogends.getMain().getConfig().set("Banned." + name + ".Reason", reason);
		Dogends.getMain().saveConfig();
	}

}

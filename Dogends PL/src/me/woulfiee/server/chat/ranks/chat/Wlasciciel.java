package me.woulfiee.server.chat.ranks.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.chat.ranks.utils.Utils;

/**
 * 
 * @author Woulfiee
 *
 */
public class Wlasciciel implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isOwner(e.getPlayer())) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				Utils.playOutChat("§4§lWLASCICIEL", "Najwyzsza ranga na serwerze. \nNie ma mozliwosci jej zdobycia.",
						player, e.getMessage());
			}
		}
	}

}

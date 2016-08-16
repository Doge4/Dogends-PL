package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Wlasciciel implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isOwner(e.getPlayer())) {
			e.setFormat(Utils.playOutChat("§4§lWLASCICIEL", "Najwyzsza ranga na serwerze. \nNie ma mozliwosci jej zdobycia.")
						+ e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());

		}
	}

}

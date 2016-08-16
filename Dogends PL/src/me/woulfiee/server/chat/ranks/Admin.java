package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Admin implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isAdmin(e.getPlayer())) {
				e.setFormat(Utils.playOutChat("§c§lADMIN", "Przedostatnia ranga na serwerze, jaka istnieje. \nNie mozesz jej otrzymac w zaden sposob.") + e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());
		}
	}

}

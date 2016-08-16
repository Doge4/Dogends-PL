package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Budowniczy implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isBuilder(e.getPlayer())) {
			e.setFormat(Utils.playOutChat("§9§lBudowniczy", "Ostatnia ranga przed ranga moderator. \nMozesz ja zdobyc, aplikujac na odpowiednie stanowisko.") + e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());
		}
	}

}

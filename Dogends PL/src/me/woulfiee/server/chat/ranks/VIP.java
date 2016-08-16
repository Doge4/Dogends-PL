package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class VIP implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isVip(e.getPlayer())) {
			e.setFormat(Utils.playOutChat("§2VIP", "Pierwsza ranga, jaka mozesz dostac! \nDzieki niej mozesz zostac moderatorem!") + e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());

		}
	}

}

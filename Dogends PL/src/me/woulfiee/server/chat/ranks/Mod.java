package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Mod implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isMod(e.getPlayer())) {
			e.setFormat(Utils.playOutChat("§6§lMOD", "Ten gracz zostal mianowany ranga moderator \nMa prawo Ciebie wyrzucic, zbanowac lub wyciszyc.") + e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());

		}
	}

}

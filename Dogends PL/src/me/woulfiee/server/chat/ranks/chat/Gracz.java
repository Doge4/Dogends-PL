package me.woulfiee.server.chat.ranks.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class Gracz implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isPlayer(e.getPlayer()) || (!Ranks.isPlayer(e.getPlayer()) && !Ranks.isVip(e.getPlayer())
				&& !Ranks.isYoutuber(e.getPlayer()) && !Ranks.isBuilder(e.getPlayer()) && !Ranks.isMod(e.getPlayer())
				&& !Ranks.isAdmin(e.getPlayer()) && !Ranks.isOwner(e.getPlayer()))) {
			e.setFormat(" §7Gracz §f" + e.getPlayer().getName() + " §8§o>> §r" + e.getMessage());
		}
	}

}

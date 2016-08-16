package me.woulfiee.server.chat.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class YouTuber implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isYoutuber(e.getPlayer())) {
				e.setFormat(Utils.playOutChat("§f§lYou§4§lTuber", "Tylko profesjonalisci moga otrzymac \ntak wartosciowa range, jak ta. \nNie martw sie, Ty tez mozesz ja zdobyc, \njezeli powiesz administratorom, ze nagrywasz.") + e.getPlayer().getName() + " §8§o§l>> §r" + e.getMessage());

		}
	}

}

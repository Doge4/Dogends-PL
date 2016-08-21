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
public class YouTuber implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isYoutuber(e.getPlayer())) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				Utils.playOutChat("§f§lYou§4§lTuber",
						"Tylko profesjonalisci moga otrzymac \ntak wartosciowa range, jak ta. \nNie martw sie, Ty tez mozesz ja zdobyc, \njezeli powiesz administratorom, ze nagrywasz.",
						player, e.getMessage());
			}
		}
	}

}

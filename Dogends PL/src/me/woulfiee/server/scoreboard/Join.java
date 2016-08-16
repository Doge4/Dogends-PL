package me.woulfiee.server.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Join implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		for (Player online : Bukkit.getOnlinePlayers())
			Sb.update(online, ScoreboardUpdateType.NORMAL);
	}
}

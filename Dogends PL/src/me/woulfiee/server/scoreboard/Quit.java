package me.woulfiee.server.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Quit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		for (Player online : Bukkit.getServer().getOnlinePlayers())
			Sb.update(online, ScoreboardUpdateType.QUIT);
	}

}

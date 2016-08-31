/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.chat.ranks.chat;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.chat.ranks.utils.Utils;
import me.woulfiee.server.loginregister.Login;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Admin implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isAdmin(e.getPlayer())) {
			if (Login.isLoggedIn(e.getPlayer())) {
				for (Player player : Bukkit.getOnlinePlayers()) {
                    Utils.playOutChat("§c§lADMIN",
                            "Przedostatnia ranga na serwerze, jaka istnieje. \nNie mozesz jej otrzymac w zaden sposob.",
                            player, e.getPlayer(), e.getMessage());
                    e.setCancelled(true);
                }
				System.out.println("ADMIN " + e.getPlayer().getName() + " >> " + e.getMessage());

			}
		}
	}

}

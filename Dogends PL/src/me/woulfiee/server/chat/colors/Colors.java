/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.chat.colors;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Colors implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isAdmin(e.getPlayer()) || Ranks.isOwner(e.getPlayer())) {
            e.setMessage(e.getMessage().replaceAll("&", "§"));
        }
    }

	@EventHandler
	public void onPlayerSign(SignChangeEvent e) {
		if (Ranks.isAdmin(e.getPlayer()) || Ranks.isOwner(e.getPlayer()) || e.getPlayer().isOp()) {
			if (e.getLine(0).contains("&")) {
                e.setLine(0, e.getLine(0).replaceAll("&", "§"));
            }
            if (e.getLine(1).contains("&")) {
                e.setLine(1, e.getLine(1).replaceAll("&", "§"));
            }
            if (e.getLine(2).contains("&")) {
                e.setLine(2, e.getLine(2).replaceAll("&", "§"));
            }
            if (e.getLine(3).contains("&")) {
                e.setLine(3, e.getLine(3).replaceAll("&", "§"));
            }
        }
	}

}

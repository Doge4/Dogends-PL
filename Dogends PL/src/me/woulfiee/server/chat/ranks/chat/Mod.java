package me.woulfiee.server.chat.ranks.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.chat.ranks.utils.Utils;
import me.woulfiee.server.loginregister.Login;

/**
 * 
 * @author Woulfiee
 *
 */
public class Mod implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isMod(e.getPlayer())) {
			if (Login.isLoggedIn(e.getPlayer())) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					Utils.playOutChat("§6§lMOD",
							"Ten gracz zostal mianowany ranga moderator \nMa prawo Ciebie wyrzucic, zbanowac lub wyciszyc.",
							player, e.getMessage());
					e.setCancelled(true);
				}
				System.out.println("MOD " + e.getPlayer().getName() + " >> " + e.getMessage());
			}
		}
	}

}

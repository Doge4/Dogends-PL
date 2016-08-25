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
public class VIP implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (Ranks.isVip(e.getPlayer())) {
			if (Login.isLoggedIn(e.getPlayer())) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					Utils.playOutChat("§2VIP",
							"Pierwsza ranga, jaka mozesz dostac! \nDzieki niej mozesz zostac moderatorem aplikuj¹c na odpowiednie stanowisko.",
							player, e.getMessage());
					e.setCancelled(true);
				}
				System.out.println("VIP " + e.getPlayer().getName() + " >> " + e.getMessage());
			}
		}
	}

}

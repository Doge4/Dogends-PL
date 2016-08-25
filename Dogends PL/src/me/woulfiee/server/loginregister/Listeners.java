package me.woulfiee.server.loginregister;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class Listeners implements Listener {

	public static void sendMessages(final Player player) {
		if (Register.isRegistered(player)) {
			Bukkit.getScheduler().runTaskAsynchronously(Dogends.getMain(), new Runnable() {
				@Override
				public void run() {
					if (player.isOnline()) {
						try {
							Thread.sleep(1000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Logowanie] §aZaloguj sie wpisujac §e/login <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.kickPlayer(
										"§6§lDOGENDS\n\n        §cCzas logowania minal! Zaloguj sie ponownie!");
						} catch (InterruptedException e) {
						}

					}
				}
			});

		} else {
			Bukkit.getScheduler().runTaskAsynchronously(Dogends.getMain(), new Runnable() {

				@Override
				public void run() {
					if (player.isOnline()) {
						try {
							Thread.sleep(1000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.sendMessage("§6[Rejestracja] §aZarejestruj sie wpisujac §e/register <haslo>§a!");
							if (!Login.isLoggedIn(player))
								Thread.sleep(3000);
							if (!Login.isLoggedIn(player))
								player.kickPlayer(
										"§6§lDOGENDS\n\n        §cCzas rejestracji minal! Zaloguj sie ponownie!");
						} catch (InterruptedException e) {
						}
					}

				}
			});
		}
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (!Login.isLoggedIn(e.getPlayer())) {
			if (e.getMessage().startsWith("/")) {
				if (!(e.getMessage().contains("/login") || e.getMessage().contains("/register")
						|| e.getMessage().contains("/l"))) {
					e.setCancelled(true);
				}
			} else {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		if (!Ranks.isStaff(e.getPlayer())) {
			e.setJoinMessage("§7§l§o>>> §eGracz " + e.getPlayer().getName() + " dolaczyl do gry!");
		} else {
			e.setJoinMessage(null);
		}
		final Player p = e.getPlayer();
		if (!p.hasPlayedBefore()) {
			e.setJoinMessage(null);
			p.kickPlayer("§6§lDOGENDS\n\n         §eWeryfikacja konta zakonczona, zaloguj sie ponownie!");
		}
		if (Bukkit.getWorld("world") != null) {
			Location loc = new Location(Bukkit.getWorld("world"), -954.5, 29, -594.5, 90, 0);
			p.teleport(loc);
		}
		sendMessages(p);
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if (!Ranks.isStaff(e.getPlayer())) {
			e.setQuitMessage("§7§l§o>>> §eGracz " + e.getPlayer().getName() + " wyszedl z gry!");
		} else {
			e.setQuitMessage(null);
		}
		Login.loggedin.remove(e.getPlayer().getName());
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (!Login.isLoggedIn(p)) {
			Location from = e.getFrom();
			Location to = e.getTo();
			double x = Math.floor(from.getX());
			double y = Math.floor(from.getY());
			double z = Math.floor(from.getZ());
			if (Math.floor(to.getX()) != x || Math.floor(to.getY()) != y || Math.floor(to.getZ()) != z) {
				x += .5;
				z += .5;
				e.getPlayer().teleport(new Location(from.getWorld(), x, y, z, from.getYaw(), from.getPitch()));
			}
		}
	}
}

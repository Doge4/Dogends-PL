package me.woulfiee.server.teleportation.spawn;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitTask;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class Spawn implements Listener, CommandExecutor {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	public static HashMap<Player, BukkitTask> playerTeleportLocation = new HashMap<Player, BukkitTask>();

	public static void teleportPlayerWithDelay(final Player player, long l, final Location location,
			final String messageAfterTp) {
		if (playerTeleportLocation.get(player) != null) {
			playerTeleportLocation.remove(player);
		}
		BukkitTask task = Bukkit.getScheduler().runTaskLaterAsynchronously(Dogends.getMain(), new Runnable() {
			@Override
			public void run() {
				if (player.isOnline()) {
					player.teleport(location);
					playerTeleportLocation.remove(player);
					if (messageAfterTp != null) {
						player.sendMessage(messageAfterTp);
					}

				}
			}
		}, l * 20L);

		playerTeleportLocation.put(player, task);
		Bukkit.getScheduler().runTaskAsynchronously(Dogends.getMain(), new Runnable() {
			@Override
			public void run() {
				try {
					cooldown.add(player);
					Thread.sleep(600000);
					cooldown.remove(player);
				} catch (Exception ignored) {
				}
			}
		});
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("spawn")) {
			if ((sender instanceof Player)) {
				Player p = (Player) sender;
				if (args.length == 0) {
					Location spawn = new Location(Bukkit.getWorld("world"), -954.5, 29, -594.5, 90, 0);
					if (Ranks.isOtherRank(p)) {
						if (!cooldown.contains(p)) {
							p.sendMessage("§6[TP] §aPoczekaj i nie ruszaj sie przez 20 sekund!");
							teleportPlayerWithDelay(p, 20, spawn, "§6[TP] §aZostales przeteleportowany na spawn!");
						} else {
							p.sendMessage("§6[TP] §cMusisz poczekac 5 minut przed ponowna teleportacja!");
						}
					} else {
						p.teleport(spawn);
						p.sendMessage("§6[TP] §aZostales przeteleportowany na spawn!");
					}
				} else {
					Location spawn = new Location(Bukkit.getWorld("world"), -954.5, 29, -594.5, 90, 0);
					Player targetPlayer = p.getServer().getPlayer(args[0]);
					if (Ranks.isStaff(p)) {
						if (targetPlayer.isOnline()) {
							if (Ranks.isOtherRank(targetPlayer)) {
								targetPlayer.teleport(spawn);
								targetPlayer.sendMessage("§6[TP] §aZostales przeteleportowany na spawn!");
								p.sendMessage("§6[TP] §aGracz przeteleportowany!");
							} else {
								p.sendMessage(
										"§6[TP] §cNie mozesz przeteleportowac tego gracza na spawn! Ten gracz moze przeteleportowac sie sam.");
							}
						}
					} else {
						p.sendMessage("§6[TP] §cNie masz pozwolenia!");
					}
				}
			} else {
				if (args.length >= 1) {
					Location spawn = new Location(Bukkit.getWorld("world"), -954.5, 29, -594.5, 90, 0);
					Player targetPlayer = sender.getServer().getPlayer(args[0]);
					if (targetPlayer.isOnline()) {
						if (Ranks.isOtherRank(targetPlayer)) {
							targetPlayer.teleport(spawn);
							targetPlayer.sendMessage("§6[TP] §aZostales przeteleportowany na spawn!");
							sender.sendMessage("§6[TP] §aGracz przeteleportowany!");
						} else {
							sender.sendMessage(
									"§6[TP] §cNie mozesz przeteleportowac tego gracza na spawn! Ten gracz moze przeteleportowac sie sam.");
						}
					}
				}
			}
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerDamage(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			if (playerTeleportLocation.get(player) != null) {
				playerTeleportLocation.remove(player).cancel();
				player.sendMessage("§6[TP] §cTeleportacja zostala przerwana!");
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerMove(PlayerMoveEvent event) {
		Location from = event.getFrom();
		Location to = event.getTo();
		if ((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY())
				|| (from.getBlockZ() != to.getBlockZ()) || (from.getWorld() != to.getWorld())) {
			Player player = event.getPlayer();
			if (playerTeleportLocation.get(player) != null) {
				playerTeleportLocation.remove(player).cancel();
				player.sendMessage("§6[TP] §cTeleportacja zostala przerwana!");
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Location spawn = new Location(Bukkit.getWorld("world"), -954.5, 29, -594.5, 90, 0);
		e.getPlayer().teleport(spawn);
	}

}

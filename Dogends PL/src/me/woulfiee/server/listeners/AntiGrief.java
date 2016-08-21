package me.woulfiee.server.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class AntiGrief implements Listener, CommandExecutor {

	public static ArrayList<String> basifm = new ArrayList<String>();
	public static ArrayList<String> bbp = new ArrayList<String>();
	public static ArrayList<String> bdnc = new ArrayList<String>();
	public static ArrayList<String> be = new ArrayList<String>();
	public static ArrayList<String> bld = new ArrayList<String>();
	public static ArrayList<String> bms = new ArrayList<String>();
	public static ArrayList<String> bpe = new ArrayList<String>();
	public static ArrayList<String> bpp = new ArrayList<String>();
	public static ArrayList<String> bwc = new ArrayList<String>();
	
	@EventHandler
	public void cactusGrow(BlockGrowEvent e) {
		if(e.getBlock().getType() == Material.CACTUS) {
			e.setCancelled(true);
		}
	}

	/**
	 * Blocks daylight cycle - the sun and moon can't move
	 */
	public static void blockDaynightCycle() {
		for (final World world : Bukkit.getWorlds()) {
			Bukkit.getScheduler().scheduleAsyncRepeatingTask(Dogends.getMain(), new BukkitRunnable() {

				@Override
				public void run() {
					world.setTime(6000);
				}
			}, 0, 1);
		}
	}

	/**
	 * Blocks player from breaking blocks
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void blockDamage(BlockDamageEvent e) {
		if (e.getPlayer().getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (bbp.contains("on")) {
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz niszczyc tutaj blokow!");
					e.setCancelled(true);
				}
			}
		}
	}

	/**
	 * Blocks a player from breaking blocks
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void breakEvent(BlockBreakEvent e) {
		if (e.getPlayer().getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (bbp.contains("on")) {
					e.setCancelled(true);
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz niszczyc tutaj blokow!");
				}
			}
		}
	}

	/**
	 * Blocks an entity from exploding
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void creeperBoom(EntityExplodeEvent e) {
		if (be.contains("on")) {
			e.setCancelled(true);
		}
	}

	/**
	 * Stops the food bar going down
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void hungerlevelChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	/**
	 * Blocks the mobs from spawning excluding snowman, golem or if a mob was
	 * spawned by a plugin, using a spawn egg or a spawner.
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void mobworld(CreatureSpawnEvent e) {
		if (e.getSpawnReason() != SpawnReason.BUILD_SNOWMAN || e.getSpawnReason() != SpawnReason.BUILD_IRONGOLEM
				|| e.getSpawnReason() != SpawnReason.CUSTOM || e.getSpawnReason() != SpawnReason.SPAWNER_EGG
				|| e.getSpawnReason() != SpawnReason.SPAWNER) {
				if (bms.contains("on")) {
					e.setCancelled(true);
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("togglegrief")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {
				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("toggleblockplace")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("toggleexplosion")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("togglepve")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("togglepvp")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("toggleleafdecay")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("toggleblockplace")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		} else if (label.equalsIgnoreCase("togglearmorstanditemframemanipulation")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p)) {

				} else {

				}
			} else {

			}

		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLeavesDecay(LeavesDecayEvent e) {
		if (bld.contains("on")) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent e) {
		Player player = e.getPlayer();
		if (player.getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (basifm.contains("on")) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e) {
		Player player = e.getPlayer();
		if (player.getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (bbp.contains("on")) {
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz stawiac tutaj blokow!");
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerBucketFill(PlayerBucketFillEvent e) {
		Player player = e.getPlayer();

		if (player.getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (bbp.contains("on")) {
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz niszczyc tutaj blokow!");
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		if ((e instanceof PlayerArmorStandManipulateEvent)) {
			return;
		}
		Player player = e.getPlayer();
		Entity entity = e.getRightClicked();
		if (player.getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (entity instanceof ItemFrame) {
					if (basifm.contains("on")) {
						ItemFrame frame = (ItemFrame) entity;
						if ((frame.getItem().getType().equals(Material.AIR))
								&& ((!player.getInventory().getItemInHand().getType().equals(Material.AIR)))) {
							e.setCancelled(true);
						}
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void placeEvent(BlockPlaceEvent e) {
		if (e.getPlayer().getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (bbp.contains("on")) {
					e.setCancelled(true);
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz stawiac tutaj blokow!");
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void pvppveEvent(EntityDamageEvent e) {
		if (e.getEntity().getLocation().getWorld().getName().equals("world")) {
			if (e.getEntity() instanceof Player) {
				if (bpp.contains("on")) {
					e.setCancelled(true);
				}
			}
		}

	}

	/**
	 * Stops the weather changes
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void weatherChange(WeatherChangeEvent e) {
		if (bwc.contains("on")) {
			e.setCancelled(true);
		}
	}

}

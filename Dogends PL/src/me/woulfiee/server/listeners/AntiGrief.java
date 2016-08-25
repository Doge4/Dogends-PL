package me.woulfiee.server.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
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
public class AntiGrief implements Listener {

	public static boolean blockarmorstanditemframemanipulation = false;
	public static boolean blockbreakplace = true;
	public static boolean blockdaynightcycle = true;
	public static boolean blockexplosion = true;
	public static boolean blockgrowing = false;
	public static boolean blockleafdecay = false;
	public static boolean blockmobspawn = true;
	public static boolean blockpve = true;
	public static boolean blockpvp = true;
	public static boolean blockweatherchange = true;

	/**
	 * Blocks daylight cycle - the sun and moon can't move
	 */
	public static void blockDaynightCycle() {
		if (blockdaynightcycle) {
			for (final World world : Bukkit.getWorlds()) {
				Bukkit.getScheduler().scheduleAsyncRepeatingTask(Dogends.getMain(), new BukkitRunnable() {

					@Override
					public void run() {
						world.setTime(6000);
					}
				}, 0, 1);
			}
		}
	}

	/**
	 * Blocks player from breaking blocks
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void blockDamage(BlockDamageEvent e) {
		if (e.getPlayer().getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (blockbreakplace) {
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
				if (blockbreakplace) {
					e.setCancelled(true);
					e.getPlayer().sendMessage("§6[Ochrona] §cNie mozesz niszczyc tutaj blokow!");
				}
			}
		}
	}

	@EventHandler
	public void cactusGrow(BlockGrowEvent e) {
		if (e.getBlock().getLocation().getX() >= -52 && e.getBlock().getLocation().getX() <= -3) {
			if (e.getBlock().getLocation().getZ() <= 52 && e.getBlock().getLocation().getZ() >= 3) {
				if (!e.isCancelled()) {
					e.setCancelled(true);
				}
			}
		}
		if (blockgrowing) {
			e.setCancelled(true);
		}
	}

	/**
	 * Blocks an entity from exploding
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void creeperBoom(EntityExplodeEvent e) {
		if (blockexplosion) {
			e.setCancelled(true);
		}
	}

	/**
	 * Stops the food bar from going down
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
			if (!e.isCancelled()) {
				e.setCancelled(true);
			}
		}
		if (blockmobspawn) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLeavesDecay(LeavesDecayEvent e) {
		if (blockleafdecay) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent e) {
		Player player = e.getPlayer();
		if (player.getLocation().getWorld().getName().equals("world")) {
			if (!(Ranks.isAdmin(e.getPlayer()) || Ranks.isBuilder(e.getPlayer()) || Ranks.isOwner(e.getPlayer()))) {
				if (blockarmorstanditemframemanipulation) {
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
				if (blockbreakplace) {
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
				if (blockbreakplace) {
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
					if (blockarmorstanditemframemanipulation) {
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
				if (blockbreakplace) {
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
				if (blockpvp) {
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
		if (blockweatherchange) {
			e.setCancelled(true);
		}
	}

}

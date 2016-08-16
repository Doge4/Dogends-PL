package me.woulfiee.server.signs;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Plugins implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (block != null) {
				if (block.getLocation().getWorld().getName().equalsIgnoreCase("spawn")) {
					Location loc = block.getLocation();
					if ((loc.getX() == -749) && (loc.getY() == 45) && (loc.getZ() == 529)) {
						if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
							StringBuilder builder = new StringBuilder(
									StringUtils.center("§6 PLUGINY ", 239, "§e§m-") + "\n");
							builder.append("§e - Nasz wlasny plugin - obsluguje wiekszosc zadan na serwerze;\n");
							builder.append("§e - NoCheatPlus;\n");
							builder.append("§e - World Edit - w przyszlosci prawdopodobnie nie bedziemy go uzywac;\n");
							e.getPlayer().sendMessage(builder.toString());

						}
					}
				}
			}
		}
	}
}

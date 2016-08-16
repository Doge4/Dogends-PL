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
public class Rules implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (block != null) {
				if (block.getLocation().getWorld().getName().equalsIgnoreCase("spawn")) {
					Location loc = block.getLocation();
					if ((loc.getX() == -749) && (loc.getY() == 45) && (loc.getZ() == 528)) {
						if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
							StringBuilder builder = new StringBuilder(
									StringUtils.center("§6 REGULY ", 240, "§e§m-") + "\n");
							builder.append("§61. §7Obrazanie graczy, jak i administracji jest zakazane.\n");
							builder.append(
									"§62. §7Korzystanie z jakichkolwiek cheatow i zhackowanych klientow jest zabronione i grozi banem.\n");
							builder.append(
									"§63. §7Nadmierne spamowanie, przeklinanie na czacie jest niedopuszczalne i rowniez grozi banem. Przy czym jakakolwiek proba obejscia cenzury skutkuje wyciszeniem.\n");
							builder.append(
									"§64. §7Moderatorzy nie zawsze maja racje. Jesli uwazasz, ze nieslusznie dostales bana skontaktuj sie z administratorem.\n");
							e.getPlayer().sendMessage(builder.toString());

						}
					}
				}
			}
		}
	}

}

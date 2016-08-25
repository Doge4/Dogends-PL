/**
 * 
 */
package me.woulfiee.server.chat.ranks.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;

/**
 * @author Woulfiee
 *
 */
public class Utils {

	public static void playOutChat(String rank, String hoverText, Player player, String message) {

		CraftPlayer craftplayer = (CraftPlayer) player;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;

		String jsonrank = "[\"\",{text:\"" + rank
				+ "\",hoverEvent:{action:\"show_text\",value:{text:\"\",extra:[{text:\"" + rank + "\n\n" + hoverText
				+ "\"}]}}},{text:\" §f" + player.getName() + " §8§o§l>> §f" + message + "\"}]";

		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(jsonrank));
		connection.sendPacket(packet);

	}

}

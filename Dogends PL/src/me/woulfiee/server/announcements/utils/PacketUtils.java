package me.woulfiee.server.announcements.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

/**
 * 
 * @author Woulfiee
 *
 */
public class PacketUtils {

	/**
	 * Sends a subtitle to a player
	 * 
	 * @param player
	 * @param subtitle
	 *            (text to display)
	 */
	public static void sendSubtitle(Player player, String subtitle) {
		CraftPlayer craftplayer = (CraftPlayer) player;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;

		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
				ChatSerializer.a("{\"text\": \"" + subtitle + "\"}"));

		connection.sendPacket(packet);
	}

	/**
	 * 
	 * @param player
	 * @param title
	 *            (text to display)
	 * 
	 */

	public static void sendTitle(Player player, String title) {

		CraftPlayer craftplayer = (CraftPlayer) player;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\": \"" + title + "\"}"));

		connection.sendPacket(packet);

	}
}

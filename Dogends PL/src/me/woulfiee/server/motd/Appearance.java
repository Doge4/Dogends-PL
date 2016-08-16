package me.woulfiee.server.motd;

import static org.apache.commons.lang.StringUtils.center;

import me.woulfiee.server.Dogends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedServerPing;

/**
 * 
 * @author Woulfiee
 *
 */
public class Appearance {

	public static void setupMotD() {
		final ProtocolManager manager = ProtocolLibrary.getProtocolManager();
		manager.addPacketListener(
				new PacketAdapter(Dogends.getMain(), ListenerPriority.NORMAL, PacketType.Status.Server.OUT_SERVER_INFO) {
					@Override
					public void onPacketSending(PacketEvent event) {
						if (event.getPacketType() != PacketType.Status.Server.OUT_SERVER_INFO)
							return;

						event.getPacket().getServerPings().read(0)
								.setMotD(center("§6§lDOGENDS\n" + center("§e§lPIERWSZA EDYCJA", 52), (int) 117.385));
					}
				});
	}
}

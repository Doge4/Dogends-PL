package me.woulfiee.server.motd;

import static org.apache.commons.lang3.StringUtils.center;

import java.util.ArrayList;
import java.util.List;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedServerPing;

import me.woulfiee.server.Dogends;

/**
 * 
 * @author Woulfiee
 *
 */
public class Appearance {

	public static void setupMotD() {
		final ProtocolManager manager = ProtocolLibrary.getProtocolManager();
		manager.addPacketListener(new PacketAdapter(Dogends.getMain(), ListenerPriority.NORMAL,
				PacketType.Status.Server.OUT_SERVER_INFO) {
			@Override
			public void onPacketSending(PacketEvent event) {
				if (event.getPacketType() != PacketType.Status.Server.OUT_SERVER_INFO)
					return;

				WrappedServerPing packet = event.getPacket().getServerPings().read(0);
				// packet.setMotD(center("§6§lDOGENDS\n" + center("§e§lPIERWSZA
				// EDYCJA", 52), (int) 117.385));
				packet.setMotD(center("§6§lDOGENDS\n" + center("§8⎜§e█████████████████§7███§8⎜ §6§l85%", 50), 117));
				List<WrappedGameProfile> message = new ArrayList<WrappedGameProfile>();
				message.add(new WrappedGameProfile("0", "§eDzieki za dodanie serwera na liste!"));
				message.add(new WrappedGameProfile("1", center("§eWersja: 1.8.8", 42)));
				message.add(new WrappedGameProfile("2", center("§eSerwer gotowy w §a85%", 42)));
				packet.setPlayers(message);
				packet.setVersionProtocol(3);
				packet.setVersionName("§6Online: §e" + packet.getPlayersOnline() + "§8/§e" + packet.getPlayersMaximum());
			}
		});
	}
}

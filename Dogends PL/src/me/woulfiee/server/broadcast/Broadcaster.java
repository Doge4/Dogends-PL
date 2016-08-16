package me.woulfiee.server.broadcast;

import me.woulfiee.server.Dogends;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class Broadcaster {

	public static int currentLine = 0;
	public static int running = 1;
	public static int tid = 0;

	@SuppressWarnings("resource")
	public static void broadcastMessage(String fileName) throws IOException {
		FileInputStream fs = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));

		for (int i = 0; i < currentLine; ++i)
			br.readLine();
		String line = br.readLine();
		line = line.replaceAll("&", "§");
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage("§8§l>>> §r" + line);
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		}
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(fileName)));
		lnr.skip(Long.MAX_VALUE);
		int lastLine = lnr.getLineNumber();
		if (currentLine + 1 == lastLine + 1) {
			currentLine = 0;
		} else {
			currentLine++;
		}
	}

	public static void runBroadcast() {
		int interval = Dogends.getMain().getConfig().getInt("Broadcast.Interval");
		tid = Bukkit.getScheduler().scheduleSyncRepeatingTask(Dogends.getMain(), new Runnable() {
			@Override
			public void run() {
				try {
					broadcastMessage("plugins/Dogends/broadcastmessages.yml");

				} catch (IOException e) {
				}
			}
		}, 0, interval * 20);
	}

}

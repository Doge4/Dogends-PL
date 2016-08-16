package me.woulfiee.server.chat.censor;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.startup.ConfigSetup;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 
 * @author Woulfiee
 *
 */
public class Censor implements Listener {

	public static List<String> toggle = new ArrayList<String>();

	private char[] allowedChars = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
			'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '@',
			'$', '%', '&', '^', '*', '(', ')', '-', '=', '+', '[', ']', '\\', ';', '\'', ',', '.', '?', '?', '>', '<',
			':', '"', '{', '}', '|', '~', ' ' };

	@EventHandler
	public void onPlayerChat(final AsyncPlayerChatEvent e) {
		String message = e.getMessage().toLowerCase().replaceAll("@", "a").replaceAll("\\p{Punct}", "")
				.replace("ê", "e").replace("ó", "o").replace("¹", "a").replace("œ", "s").replace("³", "l")
				.replace("¿", "z").replace("Ÿ", "z").replace("æ", "c").replace("ñ", "n");
		String replacePolish = e.getMessage().replace("ê", "e").replace("ó", "o").replace("¹", "a").replace("œ", "s")
				.replace("³", "l").replace("¿", "z").replace("Ÿ", "z").replace("æ", "c").replace("ñ", "n")
				.replace("Ê", "E").replace("Ó", "O").replace("¥", "A").replace("Œ", "S").replace("£", "L")
				.replace("¯", "Z").replace("", "Z").replace("Æ", "c").replace("Ñ", "N");
		if (e.getMessage().contains("gandalf")) {
			Bukkit.getServer().getScheduler().runTaskAsynchronously(Dogends.getMain(), new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						e.getPlayer().sendMessage("§7§lYou...");
						Thread.sleep(1250);
						e.getPlayer().sendMessage("§7§lshall not...");
						Thread.sleep(1500);
						e.getPlayer().sendMessage("§7§lpass!");
					} catch (Exception ignored) {
					}
				}
			});

		}
		e.setMessage(e.getMessage().replace(e.getMessage(), replacePolish));
		if (toggle.contains("on")) {
			if (ConfigSetup.getSwearsConfig() != null)
				if (ConfigSetup.getSwearsConfig().getStringList("Swears") != null) {
					for (String word : ConfigSetup.getSwearsConfig().getStringList("Swears")) {
						if (message.matches("(.* )?" + word + "( .*)?")) {
							e.setMessage(replaceAll(replaceChars(word), StringUtils.repeat("*", word.length()),
									replacePolish, true));
						}
					}
				} else {
					System.err.println(
							"Could not check, if the message contained a swearword, due to the fact, we could not load swears config!");
				}
			if (StringUtils.isAllUpperCase(replacePolish)) {
				e.getPlayer().sendMessage("§6[Czat] §cWylacz Caps-Lock!");
				e.setCancelled(true);
			} else {
				if (StringUtils.containsOnly(replacePolish.toLowerCase(), allowedChars)) {
					if (e.getMessage().length() < 2) {
						e.getPlayer().sendMessage("§6[Czat] §cNapisz cos wiecej!");
						e.setCancelled(true);
					}
					for (char character : allowedChars) {
						if (countOccurrences(replacePolish.toLowerCase(), character) > 15) {
							e.getPlayer().sendMessage("§6[Czat] §cZa duzo takich samych znakow!");
							e.setCancelled(true);
						}
					}
				} else {
					e.getPlayer().sendMessage("§6[Czat] §cWpisales niedozwolone znaki!");
					e.setCancelled(true);
				}
			}
		}
	}

	public static int countOccurrences(String haystack, char needle) {
		int count = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle) {
				count++;
			}
		}
		return count;
	}

	public String replaceAll(String findtxt, String replacetxt, String str, boolean isCaseInsensitive) {
		if (str == null) {
			return null;
		}
		if (findtxt == null || findtxt.length() == 0) {
			return str;
		}
		if (findtxt.length() > str.length()) {
			return str;
		}
		int counter = 0;
		String thesubstr = "";
		while ((counter < str.length()) && (str.substring(counter).length() >= findtxt.length())) {
			thesubstr = str.substring(counter, counter + findtxt.length());
			if (isCaseInsensitive) {
				if (thesubstr.equalsIgnoreCase(findtxt)) {
					str = str.substring(0, counter) + replacetxt + str.substring(counter + findtxt.length());
					counter += replacetxt.length();
				} else {
					counter++;
				}
			}
		}
		return str;
	}

	public String replaceChars(String string) {
		string.toLowerCase().replaceAll("@", "a").replaceAll("\\p{Punct}", "").replace("ê", "e").replace("ó", "o")
				.replace("¹", "a").replace("œ", "s").replace("³", "l").replace("¿", "z").replace("Ÿ", "z")
				.replace("æ", "c").replace("ñ", "n");
		return string;
	}

}

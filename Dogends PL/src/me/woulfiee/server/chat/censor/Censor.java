package me.woulfiee.server.chat.censor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;

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
	private String[] swears = { "chuj", "chuja", "chujek", "chuju", "chujem", "chujnia", "chujowy", "chujowa",
			"chujowe", "cipa", "cipê", "cipe", "cip¹", "cipie", "dojebaæ", "dojebac", "dojebie", "dojeba³", "dojebal",
			"dojeba³a", "dojebala", "dojeba³em", "dojebalem", "dojeba³am", "dojebalam", "dojebiê", "dojebie",
			"dopieprzaæ", "dopieprzac", "dopierdalaæ", "dopierdalac", "dopierdala", "dopierdala³", "dopierdalal",
			"dopierdala³a", "dopierdalala", "dopierdoli", "dopierdoli³", "dopierdolil", "dopierdolê", "dopierdole",
			"dopierdoli", "dopierdalaj¹cy", "dopierdalajacy", "dopierdoliæ", "dopierdolic", "dupa", "dupie", "dup¹",
			"dupcia", "dupeczka", "dupy", "dupe", "huj", "hujek", "hujnia", "huja", "huje", "hujem", "huju", "jebaæ",
			"jebac", "jeba³", "jebal", "jebie", "jebi¹", "jebia", "jebak", "jebaka", "jebal", "jeba³", "jebany",
			"jebane", "jebanka", "jebanko", "jebankiem", "jebanymi", "jebana", "jebanym", "jebanej", "jeban¹", "jebana",
			"jebani", "jebanych", "jebanymi", "jebcie", "jebi¹cy", "jebiacy", "jebi¹ca", "jebiaca", "jebi¹cego",
			"jebiacego", "jebi¹cej", "jebiacej", "jebia", "jebi¹", "jebie", "jebiê", "jebliwy", "jebn¹æ", "jebnac",
			"jebn¹c", "jebnaæ", "jebn¹³", "jebnal", "jebn¹", "jebna", "jebnê³a", "jebnela", "jebnie", "jebnij", "jebut",
			"koorwa", "kórwa", "kurestwo", "kurew", "kurewski", "kurewska", "kurewskiej", "kurewsk¹", "kurewska",
			"kurewsko", "kurewstwo", "kurwa", "kurwaa", "kurwami", "kurw¹", "kurwe", "kurwê", "kurwie", "kurwiska",
			"kurwo", "kurwy", "kurwach", "kurwami", "kurewski", "kurwiarz", "kurwi¹cy", "kurwica", "kurwiæ", "kurwic",
			"kurwido³ek", "kurwik", "kurwiki", "kurwiszcze", "kurwiszon", "kurwiszona", "kurwiszonem", "kurwiszony",
			"kutas", "kutasa", "kutasie", "kutasem", "kutasy", "kutasów", "kutasow", "kutasach", "kutasami",
			"matkojebca", "matkojebcy", "matkojebc¹", "matkojebca", "matkojebcami", "matkojebcach", "nabar³o¿yæ",
			"najebaæ", "najebac", "najeba³", "najebal", "najeba³a", "najebala", "najebane", "najebany", "najeban¹",
			"najebana", "najebie", "najebi¹", "najebia", "naopierdalaæ", "naopierdalac", "naopierdala³", "naopierdalal",
			"naopierdala³a", "naopierdalala", "naopierdala³a", "napierdalaæ", "napierdalac", "napierdalaj¹cy",
			"napierdalajacy", "napierdoliæ", "napierdolic", "nawpierdalaæ", "nawpierdalac", "nawpierdala³",
			"nawpierdalal", "nawpierdala³a", "nawpierdalala", "obsrywaæ", "obsrywac", "obsrywaj¹cy", "obsrywajacy",
			"odpieprzaæ", "odpieprzac", "odpieprzy", "odpieprzy³", "odpieprzyl", "odpieprzy³a", "odpieprzyla",
			"odpierdalaæ", "odpierdalac", "odpierdol", "odpierdoli³", "odpierdolil", "odpierdoli³a", "odpierdolila",
			"odpierdoli", "odpierdalaj¹cy", "odpierdalajacy", "odpierdalaj¹ca", "odpierdalajaca", "odpierdoliæ",
			"odpierdolic", "odpierdoli", "odpierdoli³", "opieprzaj¹cy", "opierdalaæ", "opierdalac", "opierdala",
			"opierdalaj¹cy", "opierdalajacy", "opierdol", "opierdoliæ", "opierdolic", "opierdoli", "opierdol¹",
			"opierdola", "piczka", "pieprzniêty", "pieprzniety", "pieprzony", "pierdel", "pierdlu", "pierdol¹",
			"pierdola", "pierdol¹cy", "pierdolacy", "pierdol¹ca", "pierdolaca", "pierdol", "pierdole", "pierdolenie",
			"pierdoleniem", "pierdoleniu", "pierdolê", "pierdolec", "pierdola", "pierdol¹", "pierdoliæ", "pierdolicie",
			"pierdolic", "pierdoli³", "pierdolil", "pierdoli³a", "pierdolila", "pierdoli", "pierdolniêty",
			"pierdolniety", "pierdolisz", "pierdoln¹æ", "pierdolnac", "pierdoln¹³", "pierdolnal", "pierdolnê³a",
			"pierdolnela", "pierdolnie", "pierdolniêty", "pierdolnij", "pierdolnik", "pierdolona", "pierdolone",
			"pierdolony", "pierdo³ki", "pierdz¹cy", "pierdzieæ", "pierdziec", "pizda", "pizd¹", "pizde", "pizdê",
			"piŸdzie", "pizdzie", "pizdn¹æ", "pizdnac", "pizdu", "podpierdalaæ", "podpierdalac", "podpierdala",
			"podpierdalaj¹cy", "podpierdalajacy", "podpierdoliæ", "podpierdolic", "podpierdoli", "pojeb", "pojeba",
			"pojebami", "pojebani", "pojebanego", "pojebanemu", "pojebani", "pojebany", "pojebanych", "pojebanym",
			"pojebanymi", "pojebem", "pojebaæ", "pojebac", "pojebalo", "popierdala", "popierdalac", "popierdalaæ",
			"popierdoliæ", "popierdolic", "popierdoli", "popierdolonego", "popierdolonemu", "popierdolonym",
			"popierdolone", "popierdoleni", "popierdolony", "porozpierdalaæ", "porozpierdala", "porozpierdalac",
			"poruchac", "poruchaæ", "przejebaæ", "przejebane", "przejebac", "przyjebali", "przepierdalaæ",
			"przepierdalac", "przepierdala", "przepierdalaj¹cy", "przepierdalajacy", "przepierdalaj¹ca",
			"przepierdalajaca", "przepierdoliæ", "przepierdolic", "przyjebaæ", "przyjebac", "przyjebie", "przyjeba³a",
			"przyjebala", "przyjeba³", "przyjebal", "przypieprzaæ", "przypieprzac", "przypieprzaj¹cy",
			"przypieprzajacy", "przypieprzaj¹ca", "przypieprzajaca", "przypierdalaæ", "przypierdalac", "przypierdala",
			"przypierdoli", "przypierdalaj¹cy", "przypierdalajacy", "przypierdoliæ", "przypierdolic", "qrwa",
			"rozjebaæ", "rozjebac", "rozjebie", "rozjeba³a", "rozjebi¹", "rozpierdalaæ", "rozpierdalac", "rozpierdala",
			"rozpierdoliæ", "rozpierdolic", "rozpierdole", "rozpierdoli", "rozpierducha", "skurwiæ", "skurwiel",
			"skurwiela", "skurwielem", "skurwielu", "skurwysyn", "skurwysynów", "skurwysynow", "skurwysyna",
			"skurwysynem", "skurwysynu", "skurwysyny", "skurwysyñski", "skurwysynski", "skurwysyñstwo", "skurwysynstwo",
			"spieprzaæ", "spieprzac", "spieprza", "spieprzaj", "spieprzajcie", "spieprzaj¹", "spieprzaja",
			"spieprzaj¹cy", "spieprzajacy", "spieprzaj¹ca", "spieprzajaca", "spierdalaæ", "spierdalac", "spierdala",
			"spierdala³", "spierdala³a", "spierdalal", "spierdalalcie", "spierdalala", "spierdalaj¹cy", "spierdalajacy",
			"spierdoliæ", "spierdolic", "spierdoli", "spierdoli³a", "spierdoli³o", "spierdol¹", "spierdola", "sraæ",
			"srac", "sraj¹cy", "srajacy", "sraj¹c", "srajac", "sraj", "sukinsyn", "sukinsyny", "sukinsynom",
			"sukinsynowi", "sukinsynów", "sukinsynow", "œmierdziel", "udupiæ", "ujebaæ", "ujebac", "ujeba³", "ujebal",
			"ujebana", "ujebany", "ujebie", "ujeba³a", "ujebala", "upierdalaæ", "upierdalac", "upierdala", "upierdoli",
			"upierdoliæ", "upierdolic", "upierdoli", "upierdol¹", "upierdola", "upierdoleni", "wjebaæ", "wjebac",
			"wjebie", "wjebi¹", "wjebia", "wjebiemy", "wjebiecie", "wkurwiaæ", "wkurwiac", "wkurwi", "wkurwia",
			"wkurwia³", "wkurwial", "wkurwiaj¹cy", "wkurwiajacy", "wkurwiaj¹ca", "wkurwiajaca", "wkurwiæ", "wkurwic",
			"wkurwi", "wkurwiacie", "wkurwiaj¹", "wkurwiali", "wkurwi¹", "wkurwia", "wkurwimy", "wkurwicie",
			"wkurwiacie", "wkurwiæ", "wkurwic", "wkurwia", "wpierdalaæ", "wpierdalac", "wpierdalaj¹cy", "wpierdalajacy",
			"wpierdol", "wpierdoliæ", "wpierdolic", "wpizdu", "wyjebaæ", "wyjebac", "wyjebali", "wyjeba³", "wyjebac",
			"wyjeba³a", "wyjeba³y", "wyjebie", "wyjebi¹", "wyjebia", "wyjebiesz", "wyjebie", "wyjebiecie", "wyjebiemy",
			"wypieprzaæ", "wypieprzac", "wypieprza", "wypieprza³", "wypieprzal", "wypieprza³a", "wypieprzala",
			"wypieprzy", "wypieprzy³a", "wypieprzyla", "wypieprzy³", "wypieprzyl", "wypierdal", "wypierdalaæ",
			"wypierdalac", "wypierdala", "wypierdalaj", "wypierdala³", "wypierdalal", "wypierdala³a", "wypierdalala",
			"wypierdalaæ", "wypierdoliæ", "wypierdolic", "wypierdoli", "wypierdolimy", "wypierdolicie", "wypierdol¹",
			"wypierdola", "wypierdolili", "wypierdoli³", "wypierdolil", "wypierdoli³a", "wypierdolila", "zajebaæ",
			"zajebac", "zajebie", "zajebi¹", "zajebia", "zajebia³", "zajebial", "zajeba³a", "zajebiala", "zajebali",
			"zajebana", "zajebani", "zajebane", "zajebany", "zajebanych", "zajebanym", "zajebanymi", "zajebiste",
			"zajebisty", "zajebistych", "zajebista", "zajebistym", "zajebistymi", "zajebiœcie", "zajebiscie",
			"zapieprzyæ", "zapieprzyc", "zapieprzy", "zapieprzy³", "zapieprzyl", "zapieprzy³a", "zapieprzyla",
			"zapieprz¹", "zapieprza", "zapieprzy", "zapieprzymy", "zapieprzycie", "zapieprzysz", "zapierdala",
			"zapierdalaæ", "zapierdalac", "zapierdalaja", "zapierdala³", "zapierdalaj", "zapierdalajcie",
			"zapierdala³a", "zapierdalala", "zapierdalali", "zapierdalaj¹cy", "zapierdalajacy", "zapierdoliæ",
			"zapierdolic", "zapierdoli", "zapierdoli³", "zapierdolil", "zapierdoli³a", "zapierdolila", "zapierdol¹",
			"zapierdola", "zapierniczaæ", "zapierniczaj¹cy", "zasraæ", "zasranym", "zasrywaæ", "zasrywaj¹cy",
			"zesrywaæ", "zesrywaj¹cy", "zjebaæ", "zjebac", "zjeba³", "zjebal", "zjeba³a", "zjebala", "zjebana",
			"zjebi¹", "zjebali", "zjeby" };

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

			for (String word : swears) {
				if (message.matches("(.* )?" + replaceChars(word) + "( .*)?")) {
					e.setMessage(replaceAll(replaceChars(word), StringUtils.repeat("*", word.length()), replacePolish,
							true));
				}
			}
			if (StringUtils.isAllUpperCase(replacePolish)) {
				e.getPlayer().sendMessage("§6[Czat] §cWylacz Caps-Lock!");
				e.setCancelled(true);
			} else {
				if (StringUtils.containsOnly(replacePolish.toLowerCase(), allowedChars)) {
					if (Ranks.isStaff(e.getPlayer()))
						if (e.getMessage().length() < 2) {
							e.getPlayer().sendMessage("§6[Czat] §cNapisz cos wiecej!");
							e.setCancelled(true);
						}
					for (char character : allowedChars) {
						if (!Ranks.isStaff(e.getPlayer()))
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

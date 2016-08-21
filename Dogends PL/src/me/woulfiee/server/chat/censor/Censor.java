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
			"chujowe", "cipa", "cip�", "cipe", "cip�", "cipie", "dojeba�", "dojebac", "dojebie", "dojeba�", "dojebal",
			"dojeba�a", "dojebala", "dojeba�em", "dojebalem", "dojeba�am", "dojebalam", "dojebi�", "dojebie",
			"dopieprza�", "dopieprzac", "dopierdala�", "dopierdalac", "dopierdala", "dopierdala�", "dopierdalal",
			"dopierdala�a", "dopierdalala", "dopierdoli", "dopierdoli�", "dopierdolil", "dopierdol�", "dopierdole",
			"dopierdoli", "dopierdalaj�cy", "dopierdalajacy", "dopierdoli�", "dopierdolic", "dupa", "dupie", "dup�",
			"dupcia", "dupeczka", "dupy", "dupe", "huj", "hujek", "hujnia", "huja", "huje", "hujem", "huju", "jeba�",
			"jebac", "jeba�", "jebal", "jebie", "jebi�", "jebia", "jebak", "jebaka", "jebal", "jeba�", "jebany",
			"jebane", "jebanka", "jebanko", "jebankiem", "jebanymi", "jebana", "jebanym", "jebanej", "jeban�", "jebana",
			"jebani", "jebanych", "jebanymi", "jebcie", "jebi�cy", "jebiacy", "jebi�ca", "jebiaca", "jebi�cego",
			"jebiacego", "jebi�cej", "jebiacej", "jebia", "jebi�", "jebie", "jebi�", "jebliwy", "jebn��", "jebnac",
			"jebn�c", "jebna�", "jebn��", "jebnal", "jebn�", "jebna", "jebn�a", "jebnela", "jebnie", "jebnij", "jebut",
			"koorwa", "k�rwa", "kurestwo", "kurew", "kurewski", "kurewska", "kurewskiej", "kurewsk�", "kurewska",
			"kurewsko", "kurewstwo", "kurwa", "kurwaa", "kurwami", "kurw�", "kurwe", "kurw�", "kurwie", "kurwiska",
			"kurwo", "kurwy", "kurwach", "kurwami", "kurewski", "kurwiarz", "kurwi�cy", "kurwica", "kurwi�", "kurwic",
			"kurwido�ek", "kurwik", "kurwiki", "kurwiszcze", "kurwiszon", "kurwiszona", "kurwiszonem", "kurwiszony",
			"kutas", "kutasa", "kutasie", "kutasem", "kutasy", "kutas�w", "kutasow", "kutasach", "kutasami",
			"matkojebca", "matkojebcy", "matkojebc�", "matkojebca", "matkojebcami", "matkojebcach", "nabar�o�y�",
			"najeba�", "najebac", "najeba�", "najebal", "najeba�a", "najebala", "najebane", "najebany", "najeban�",
			"najebana", "najebie", "najebi�", "najebia", "naopierdala�", "naopierdalac", "naopierdala�", "naopierdalal",
			"naopierdala�a", "naopierdalala", "naopierdala�a", "napierdala�", "napierdalac", "napierdalaj�cy",
			"napierdalajacy", "napierdoli�", "napierdolic", "nawpierdala�", "nawpierdalac", "nawpierdala�",
			"nawpierdalal", "nawpierdala�a", "nawpierdalala", "obsrywa�", "obsrywac", "obsrywaj�cy", "obsrywajacy",
			"odpieprza�", "odpieprzac", "odpieprzy", "odpieprzy�", "odpieprzyl", "odpieprzy�a", "odpieprzyla",
			"odpierdala�", "odpierdalac", "odpierdol", "odpierdoli�", "odpierdolil", "odpierdoli�a", "odpierdolila",
			"odpierdoli", "odpierdalaj�cy", "odpierdalajacy", "odpierdalaj�ca", "odpierdalajaca", "odpierdoli�",
			"odpierdolic", "odpierdoli", "odpierdoli�", "opieprzaj�cy", "opierdala�", "opierdalac", "opierdala",
			"opierdalaj�cy", "opierdalajacy", "opierdol", "opierdoli�", "opierdolic", "opierdoli", "opierdol�",
			"opierdola", "piczka", "pieprzni�ty", "pieprzniety", "pieprzony", "pierdel", "pierdlu", "pierdol�",
			"pierdola", "pierdol�cy", "pierdolacy", "pierdol�ca", "pierdolaca", "pierdol", "pierdole", "pierdolenie",
			"pierdoleniem", "pierdoleniu", "pierdol�", "pierdolec", "pierdola", "pierdol�", "pierdoli�", "pierdolicie",
			"pierdolic", "pierdoli�", "pierdolil", "pierdoli�a", "pierdolila", "pierdoli", "pierdolni�ty",
			"pierdolniety", "pierdolisz", "pierdoln��", "pierdolnac", "pierdoln��", "pierdolnal", "pierdoln�a",
			"pierdolnela", "pierdolnie", "pierdolni�ty", "pierdolnij", "pierdolnik", "pierdolona", "pierdolone",
			"pierdolony", "pierdo�ki", "pierdz�cy", "pierdzie�", "pierdziec", "pizda", "pizd�", "pizde", "pizd�",
			"pi�dzie", "pizdzie", "pizdn��", "pizdnac", "pizdu", "podpierdala�", "podpierdalac", "podpierdala",
			"podpierdalaj�cy", "podpierdalajacy", "podpierdoli�", "podpierdolic", "podpierdoli", "pojeb", "pojeba",
			"pojebami", "pojebani", "pojebanego", "pojebanemu", "pojebani", "pojebany", "pojebanych", "pojebanym",
			"pojebanymi", "pojebem", "pojeba�", "pojebac", "pojebalo", "popierdala", "popierdalac", "popierdala�",
			"popierdoli�", "popierdolic", "popierdoli", "popierdolonego", "popierdolonemu", "popierdolonym",
			"popierdolone", "popierdoleni", "popierdolony", "porozpierdala�", "porozpierdala", "porozpierdalac",
			"poruchac", "porucha�", "przejeba�", "przejebane", "przejebac", "przyjebali", "przepierdala�",
			"przepierdalac", "przepierdala", "przepierdalaj�cy", "przepierdalajacy", "przepierdalaj�ca",
			"przepierdalajaca", "przepierdoli�", "przepierdolic", "przyjeba�", "przyjebac", "przyjebie", "przyjeba�a",
			"przyjebala", "przyjeba�", "przyjebal", "przypieprza�", "przypieprzac", "przypieprzaj�cy",
			"przypieprzajacy", "przypieprzaj�ca", "przypieprzajaca", "przypierdala�", "przypierdalac", "przypierdala",
			"przypierdoli", "przypierdalaj�cy", "przypierdalajacy", "przypierdoli�", "przypierdolic", "qrwa",
			"rozjeba�", "rozjebac", "rozjebie", "rozjeba�a", "rozjebi�", "rozpierdala�", "rozpierdalac", "rozpierdala",
			"rozpierdoli�", "rozpierdolic", "rozpierdole", "rozpierdoli", "rozpierducha", "skurwi�", "skurwiel",
			"skurwiela", "skurwielem", "skurwielu", "skurwysyn", "skurwysyn�w", "skurwysynow", "skurwysyna",
			"skurwysynem", "skurwysynu", "skurwysyny", "skurwysy�ski", "skurwysynski", "skurwysy�stwo", "skurwysynstwo",
			"spieprza�", "spieprzac", "spieprza", "spieprzaj", "spieprzajcie", "spieprzaj�", "spieprzaja",
			"spieprzaj�cy", "spieprzajacy", "spieprzaj�ca", "spieprzajaca", "spierdala�", "spierdalac", "spierdala",
			"spierdala�", "spierdala�a", "spierdalal", "spierdalalcie", "spierdalala", "spierdalaj�cy", "spierdalajacy",
			"spierdoli�", "spierdolic", "spierdoli", "spierdoli�a", "spierdoli�o", "spierdol�", "spierdola", "sra�",
			"srac", "sraj�cy", "srajacy", "sraj�c", "srajac", "sraj", "sukinsyn", "sukinsyny", "sukinsynom",
			"sukinsynowi", "sukinsyn�w", "sukinsynow", "�mierdziel", "udupi�", "ujeba�", "ujebac", "ujeba�", "ujebal",
			"ujebana", "ujebany", "ujebie", "ujeba�a", "ujebala", "upierdala�", "upierdalac", "upierdala", "upierdoli",
			"upierdoli�", "upierdolic", "upierdoli", "upierdol�", "upierdola", "upierdoleni", "wjeba�", "wjebac",
			"wjebie", "wjebi�", "wjebia", "wjebiemy", "wjebiecie", "wkurwia�", "wkurwiac", "wkurwi", "wkurwia",
			"wkurwia�", "wkurwial", "wkurwiaj�cy", "wkurwiajacy", "wkurwiaj�ca", "wkurwiajaca", "wkurwi�", "wkurwic",
			"wkurwi", "wkurwiacie", "wkurwiaj�", "wkurwiali", "wkurwi�", "wkurwia", "wkurwimy", "wkurwicie",
			"wkurwiacie", "wkurwi�", "wkurwic", "wkurwia", "wpierdala�", "wpierdalac", "wpierdalaj�cy", "wpierdalajacy",
			"wpierdol", "wpierdoli�", "wpierdolic", "wpizdu", "wyjeba�", "wyjebac", "wyjebali", "wyjeba�", "wyjebac",
			"wyjeba�a", "wyjeba�y", "wyjebie", "wyjebi�", "wyjebia", "wyjebiesz", "wyjebie", "wyjebiecie", "wyjebiemy",
			"wypieprza�", "wypieprzac", "wypieprza", "wypieprza�", "wypieprzal", "wypieprza�a", "wypieprzala",
			"wypieprzy", "wypieprzy�a", "wypieprzyla", "wypieprzy�", "wypieprzyl", "wypierdal", "wypierdala�",
			"wypierdalac", "wypierdala", "wypierdalaj", "wypierdala�", "wypierdalal", "wypierdala�a", "wypierdalala",
			"wypierdala�", "wypierdoli�", "wypierdolic", "wypierdoli", "wypierdolimy", "wypierdolicie", "wypierdol�",
			"wypierdola", "wypierdolili", "wypierdoli�", "wypierdolil", "wypierdoli�a", "wypierdolila", "zajeba�",
			"zajebac", "zajebie", "zajebi�", "zajebia", "zajebia�", "zajebial", "zajeba�a", "zajebiala", "zajebali",
			"zajebana", "zajebani", "zajebane", "zajebany", "zajebanych", "zajebanym", "zajebanymi", "zajebiste",
			"zajebisty", "zajebistych", "zajebista", "zajebistym", "zajebistymi", "zajebi�cie", "zajebiscie",
			"zapieprzy�", "zapieprzyc", "zapieprzy", "zapieprzy�", "zapieprzyl", "zapieprzy�a", "zapieprzyla",
			"zapieprz�", "zapieprza", "zapieprzy", "zapieprzymy", "zapieprzycie", "zapieprzysz", "zapierdala",
			"zapierdala�", "zapierdalac", "zapierdalaja", "zapierdala�", "zapierdalaj", "zapierdalajcie",
			"zapierdala�a", "zapierdalala", "zapierdalali", "zapierdalaj�cy", "zapierdalajacy", "zapierdoli�",
			"zapierdolic", "zapierdoli", "zapierdoli�", "zapierdolil", "zapierdoli�a", "zapierdolila", "zapierdol�",
			"zapierdola", "zapiernicza�", "zapierniczaj�cy", "zasra�", "zasranym", "zasrywa�", "zasrywaj�cy",
			"zesrywa�", "zesrywaj�cy", "zjeba�", "zjebac", "zjeba�", "zjebal", "zjeba�a", "zjebala", "zjebana",
			"zjebi�", "zjebali", "zjeby" };

	@EventHandler
	public void onPlayerChat(final AsyncPlayerChatEvent e) {
		String message = e.getMessage().toLowerCase().replaceAll("@", "a").replaceAll("\\p{Punct}", "")
				.replace("�", "e").replace("�", "o").replace("�", "a").replace("�", "s").replace("�", "l")
				.replace("�", "z").replace("�", "z").replace("�", "c").replace("�", "n");
		String replacePolish = e.getMessage().replace("�", "e").replace("�", "o").replace("�", "a").replace("�", "s")
				.replace("�", "l").replace("�", "z").replace("�", "z").replace("�", "c").replace("�", "n")
				.replace("�", "E").replace("�", "O").replace("�", "A").replace("�", "S").replace("�", "L")
				.replace("�", "Z").replace("�", "Z").replace("�", "c").replace("�", "N");
		if (e.getMessage().contains("gandalf")) {
			Bukkit.getServer().getScheduler().runTaskAsynchronously(Dogends.getMain(), new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						e.getPlayer().sendMessage("�7�lYou...");
						Thread.sleep(1250);
						e.getPlayer().sendMessage("�7�lshall not...");
						Thread.sleep(1500);
						e.getPlayer().sendMessage("�7�lpass!");
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
				e.getPlayer().sendMessage("�6[Czat] �cWylacz Caps-Lock!");
				e.setCancelled(true);
			} else {
				if (StringUtils.containsOnly(replacePolish.toLowerCase(), allowedChars)) {
					if (Ranks.isStaff(e.getPlayer()))
						if (e.getMessage().length() < 2) {
							e.getPlayer().sendMessage("�6[Czat] �cNapisz cos wiecej!");
							e.setCancelled(true);
						}
					for (char character : allowedChars) {
						if (!Ranks.isStaff(e.getPlayer()))
							if (countOccurrences(replacePolish.toLowerCase(), character) > 15) {
								e.getPlayer().sendMessage("�6[Czat] �cZa duzo takich samych znakow!");
								e.setCancelled(true);
							}
					}
				} else {
					e.getPlayer().sendMessage("�6[Czat] �cWpisales niedozwolone znaki!");
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
		string.toLowerCase().replaceAll("@", "a").replaceAll("\\p{Punct}", "").replace("�", "e").replace("�", "o")
				.replace("�", "a").replace("�", "s").replace("�", "l").replace("�", "z").replace("�", "z")
				.replace("�", "c").replace("�", "n");
		return string;
	}

}

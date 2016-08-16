package me.woulfiee.server.startup;

import me.woulfiee.server.Dogends;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * 
 * @author Woulfiee
 *
 */
public class ConfigSetup {
	
	public static FileConfiguration swearWords;
	public static File swearWordsFile;

	public static void reloadSwearsConfig() {
		if (swearWordsFile == null || !(swearWordsFile.exists())) {
			try {
				swearWordsFile = new File(Dogends.getMain().getDataFolder(), "swearwords.yml");
				swearWordsFile.createNewFile();
			} catch (IOException e) {
			}
		}

		try {
			FileInputStream fs = new FileInputStream("plugins/Dogends/swearwords.yml");
			if (fs != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				if (br != null) {
					YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(br);
					if (defConfig != null)
						if (swearWords != null)
							swearWords.setDefaults(defConfig);
				}
			}
		} catch (FileNotFoundException e) {
			Dogends.getMain().getLogger().log(Level.SEVERE, "Could not load file " + swearWordsFile, e.getMessage());
		}
		saveSwearsConfig();
	}

	public static FileConfiguration getSwearsConfig() {
		if (swearWords == null || !(swearWordsFile.exists())) {
			reloadSwearsConfig();
		}
		return swearWords;
	}

	public static void saveSwearsConfig() {
		if (swearWords == null || swearWordsFile == null) {
			return;
		}
		try {
			getSwearsConfig().save(swearWordsFile);
		} catch (IOException ex) {
			Dogends.getMain().getLogger().log(Level.SEVERE, "Could not save config to " + swearWordsFile, ex);
		}
	}

}

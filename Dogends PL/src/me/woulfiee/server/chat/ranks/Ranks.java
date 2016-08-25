package me.woulfiee.server.chat.ranks;

import me.woulfiee.server.Dogends;

import java.util.List;

import org.bukkit.OfflinePlayer;

/**
 * 
 * @author Woulfiee
 *
 */
public class Ranks {

	public static List<String> admins = Dogends.getMain().getConfig().getStringList("Ranks.Admin.Players");
	public static List<String> builders = Dogends.getMain().getConfig().getStringList("Ranks.Builder.Players");
	public static List<String> mods = Dogends.getMain().getConfig().getStringList("Ranks.Mod.Players");
	public static List<String> owners = Dogends.getMain().getConfig().getStringList("Ranks.Owner.Players");
	public static List<String> players = Dogends.getMain().getConfig().getStringList("Ranks.Player.Players");
	public static List<String> vips = Dogends.getMain().getConfig().getStringList("Ranks.VIP.Players");
	public static List<String> youtubers = Dogends.getMain().getConfig().getStringList("Ranks.Youtuber.Players");

	public static List<String> getAdmins() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Admin.Players");
	}

	public static List<String> getBuilders() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Builder.Players");
	}

	public static List<String> getMods() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Mod.Players");
	}

	public static List<String> getOwners() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Owner.Players");
	}

	public static List<String> getPlayers() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Player.Players");
	}

	public static List<String> getVips() {
		return Dogends.getMain().getConfig().getStringList("Ranks.VIP.Players");
	}

	public static List<String> getYoutubers() {
		return Dogends.getMain().getConfig().getStringList("Ranks.Youtuber.Players");
	}

	/**
	 * Checks if a player has admin rank
	 * 
	 * @return true, if has admin rank, otherwise false
	 */
	public static boolean isAdmin(OfflinePlayer player) {
		if (Ranks.getAdmins().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has builder rank
	 * 
	 * @return true, if has builder rank, otherwise false
	 */
	public static boolean isBuilder(OfflinePlayer player) {
		if (Ranks.getBuilders().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has moderator rank
	 * 
	 * @return true, if has moderator rank, otherwise false
	 */
	public static boolean isMod(OfflinePlayer player) {
		if (Ranks.getMods().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has other rank than one of staff ranks
	 * 
	 * @return true, if has an other than staff rank rank, otherwise false
	 */
	public static boolean isOtherRank(OfflinePlayer player) {
		if (Ranks.isBuilder(player)) {
			return true;
		}
		if (Ranks.isVip(player)) {
			return true;
		}
		if (Ranks.isPlayer(player)) {
			return true;
		}
		if (Ranks.isYoutuber(player)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has owner rank
	 * 
	 * @return true, if has owner rank, otherwise false
	 */
	public static boolean isOwner(OfflinePlayer player) {
		if (Ranks.getOwners().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has player rank
	 * 
	 * @return true, if has player rank, otherwise false
	 */
	public static boolean isPlayer(OfflinePlayer player) {
		if (Ranks.getPlayers().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has staff rank
	 * 
	 * @return true, if has staff rank, otherwise false
	 */
	public static boolean isStaff(OfflinePlayer player) {
		if (Ranks.getAdmins().contains(player.getName())) {
			return true;
		}
		if (Ranks.getMods().contains(player.getName())) {
			return true;
		}
		if (Ranks.getOwners().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has VIP rank
	 * 
	 * @return true, if has VIP rank, otherwise false
	 */
	public static boolean isVip(OfflinePlayer player) {
		if (Ranks.getVips().contains(player.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has youtuber rank
	 * 
	 * @return true, if has youtuber rank, otherwise false
	 */
	public static boolean isYoutuber(OfflinePlayer player) {
		if (Ranks.getYoutubers().contains(player.getName())) {
			return true;
		}
		return false;
	}

	public static void setAdmin(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		admins.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setBuilder(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		builders.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setMod(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		mods.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setOwner(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		owners.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setPlayer(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		players.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setVip(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		vips.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}

	public static void setYoutuber(OfflinePlayer player) {
		players.remove(player.getName());
		vips.remove(player.getName());
		youtubers.remove(player.getName());
		builders.remove(player.getName());
		mods.remove(player.getName());
		admins.remove(player.getName());
		owners.remove(player.getName());
		youtubers.add(player.getName());

		Dogends.getMain().getConfig().set("Ranks.Player.Players", players);
		Dogends.getMain().getConfig().set("Ranks.Doge.Players", vips);
		Dogends.getMain().getConfig().set("Ranks.Youtuber.Players", youtubers);
		Dogends.getMain().getConfig().set("Ranks.Builder.Players", builders);
		Dogends.getMain().getConfig().set("Ranks.Mod.Players", mods);
		Dogends.getMain().getConfig().set("Ranks.Admin.Players", admins);
		Dogends.getMain().getConfig().set("Ranks.Owner.Players", owners);

		Dogends.getMain().saveConfig();
	}
}

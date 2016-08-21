package me.woulfiee.server.scoreboard;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.vanish.VanishCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import net.minecraft.server.v1_8_R3.PlayerConnection;

/**
 * 
 * @author Woulfiee
 *
 */
public class Sb {

	public static ScoreboardManager manager;
	public static Objective obj;
	public static Score score1;
	// public static Score score9;
	// public static Score score10;
	// public static Score score11;
	public static Score score12;
	public static Score score2;
	public static Score score3;
	public static Score score4;
	public static Score score5;
	public static Score score6;
	public static Score score7;
	public static Score score8;
	// public static Score score13;
	// public static Score score14;
	// public static Score score15;
	// public static Score score16;
	@SuppressWarnings("unused")
	private static Scoreboard scoreboard;

	public static ScoreboardManager getManager() {
		return manager;
	}

	public static Objective getObj() {
		return obj;
	}

	public static Scoreboard getScoreboard(Player p) {
		return p.getScoreboard();
	}

	public static void update(Player p, ScoreboardUpdateType updatetype) {
		CraftPlayer craftplayer = (CraftPlayer) p;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		if (!connection.isDisconnected()) {
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

			manager = Bukkit.getScoreboardManager();
			obj = getScoreboard(p).registerNewObjective("§6§lDOGENDS", "Dogends Sidebar Scoreboard");

			Team owners = getScoreboard(p).registerNewTeam("owners");
			owners.setPrefix(ChatColor.DARK_RED + "" + ChatColor.BOLD + "WLAS " + ChatColor.WHITE);
			owners.setAllowFriendlyFire(true);
			owners.setCanSeeFriendlyInvisibles(false);
			Team admins = getScoreboard(p).registerNewTeam("admins");
			admins.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.WHITE);
			admins.setAllowFriendlyFire(true);
			admins.setCanSeeFriendlyInvisibles(false);
			Team mods = getScoreboard(p).registerNewTeam("mods");
			mods.setPrefix(ChatColor.GOLD + "" + ChatColor.BOLD + "MOD " + ChatColor.WHITE);
			mods.setAllowFriendlyFire(true);
			mods.setCanSeeFriendlyInvisibles(false);
			Team builders = getScoreboard(p).registerNewTeam("builders");
			builders.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "BUD " + ChatColor.WHITE);
			builders.setAllowFriendlyFire(true);
			builders.setCanSeeFriendlyInvisibles(false);
			Team youtubers = getScoreboard(p).registerNewTeam("youtubers");
			youtubers.setPrefix(ChatColor.WHITE + "" + ChatColor.BOLD + "Y" + ChatColor.DARK_RED + "" + ChatColor.BOLD
					+ "T " + ChatColor.WHITE);
			youtubers.setAllowFriendlyFire(true);
			youtubers.setCanSeeFriendlyInvisibles(false);
			Team vips = getScoreboard(p).registerNewTeam("doges");
			vips.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "PIESEL " + ChatColor.WHITE);
			vips.setAllowFriendlyFire(true);
			vips.setCanSeeFriendlyInvisibles(false);
			Team players = getScoreboard(p).registerNewTeam("players");
			players.setAllowFriendlyFire(true);
			players.setCanSeeFriendlyInvisibles(false);

			for (Player online : Bukkit.getOnlinePlayers()) {
				if (Ranks.isAdmin(online)) {
					admins.addEntry(online.getName());
				} else if (Ranks.isBuilder(online)) {
					builders.addEntry(online.getName());
				} else if (Ranks.isVip(online)) {
					vips.addEntry(online.getName());
				} else if (Ranks.isMod(online)) {
					mods.addEntry(online.getName());
				} else if (Ranks.isOwner(online)) {
					owners.addEntry(online.getName());
				} else if (Ranks.isPlayer(online)) {
					players.addEntry(online.getName());
				} else if (Ranks.isYoutuber(online)) {
					youtubers.addEntry(online.getName());
				} else {
					players.addEntry(online.getName());
				}
			}

			score1 = getObj().getScore("§7§m-----------------------");
			score1.setScore(16);

			score2 = getObj()
					.getScore("§9Pieniadze: §f" + Dogends.getMain().getConfig().getInt("Tokens." + p.getUniqueId().toString()));
			score2.setScore(15);

			score3 = getObj().getScore(" ");
			score3.setScore(14);

			score4 = getObj().getScore("§3Poziom: §f" + Dogends.getMain().getConfig().getInt("Levels." + p.getUniqueId().toString()));
			score4.setScore(13);

			score5 = getObj().getScore("  ");
			score5.setScore(12);

			if (updatetype == ScoreboardUpdateType.NORMAL) {
				score6 = getObj().getScore("§aGraczy Online: §f" + Bukkit.getServer().getOnlinePlayers().size());
			} else if (updatetype == ScoreboardUpdateType.QUIT) {
				score6 = getObj().getScore("§aGraczy Online: §f" + (Bukkit.getServer().getOnlinePlayers().size() - 1));
			} else {
				score6 = getObj().getScore("§aGraczy Online: §f" + (Bukkit.getServer().getOnlinePlayers().size() - VanishCommand.vanished.size()));
			}
			score6.setScore(11);

			score7 = getObj().getScore("   ");
			score7.setScore(10);

			if (Ranks.isAdmin(p)) {
				score8 = getObj().getScore("§6Ranga: §fAdmin");
			} else if (Ranks.isBuilder(p)) {
				score8 = getObj().getScore("§6Ranga: §fBudowniczy");
			} else if (Ranks.isVip(p)) {
				score8 = getObj().getScore("§6Ranga: §fPiesel");
			} else if (Ranks.isMod(p)) {
				score8 = getObj().getScore("§6Ranga: §fModerator");
			} else if (Ranks.isOwner(p)) {
				score8 = getObj().getScore("§6Ranga: §fWlasciciel");
			} else if (Ranks.isPlayer(p)) {
				score8 = getObj().getScore("§6Ranga: §fGracz");
			} else if (Ranks.isYoutuber(p)) {
				score8 = getObj().getScore("§6Ranga: §fYouTuber");
			} else {
				score8 = getObj().getScore("§6Ranga: §fGracz");
			}
			score8.setScore(9);

			score12 = getObj().getScore(" §7§m---------------------");
			score12.setScore(5);

			obj.setDisplaySlot(DisplaySlot.SIDEBAR);

			for (Player online : Bukkit.getServer().getOnlinePlayers())
				PacketUtils.sendTabHF(online, "§6§lDOGENDS", "§eNasza strona internetowa jest w budowie!\n Niedlugo bedzie dostepna! :)");

			p.setScoreboard(getScoreboard(p));
		}
	}
}

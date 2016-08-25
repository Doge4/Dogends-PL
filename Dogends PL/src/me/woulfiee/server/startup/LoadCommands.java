package me.woulfiee.server.startup;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.announcements.commands.AnnounceCommand;
import me.woulfiee.server.ban.BanCommand;
import me.woulfiee.server.ban.UnbanCommand;
import me.woulfiee.server.broadcast.commands.ToggleBroadcast;
import me.woulfiee.server.chat.censor.ToggleCensor;
import me.woulfiee.server.chat.commands.Clean;
import me.woulfiee.server.chat.commands.Moderator;
import me.woulfiee.server.chat.commands.Setrank;
import me.woulfiee.server.chat.commands.VIP;
import me.woulfiee.server.gm.GameModes;
import me.woulfiee.server.healfeed.FeedCommand;
import me.woulfiee.server.healfeed.HealCommand;
import me.woulfiee.server.kick.KickCommand;
import me.woulfiee.server.loginregister.Login;
import me.woulfiee.server.loginregister.Register;
import me.woulfiee.server.msg.MSGCommand;
import me.woulfiee.server.mute.MuteCommand;
import me.woulfiee.server.op.DeOPCommand;
import me.woulfiee.server.op.OPCommand;
import me.woulfiee.server.reports.HelpOP;
import me.woulfiee.server.tab.TabCompletion;
import me.woulfiee.server.teleportation.spawn.Spawn;
import me.woulfiee.server.teleportation.tp.TPCommand;
import me.woulfiee.server.tps.commands.TPSCmd;
import me.woulfiee.server.vanish.VanishCommand;
import me.woulfiee.server.worlds.commands.CWCommand;
import me.woulfiee.server.worlds.commands.GoToCommand;
import me.woulfiee.server.worlds.plots.commands.PlotCommand;

/**
 * 
 * @author Woulfiee
 *
 */
public class LoadCommands {

	public static void load() {
		Dogends.getMain().getCommand("ann").setExecutor(new AnnounceCommand());
		Dogends.getMain().getCommand("ann").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("cc").setExecutor(new Clean());
		Dogends.getMain().getCommand("setrank").setExecutor(new Setrank());
		Dogends.getMain().getCommand("setrank").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("spawn").setExecutor(new Spawn());
		Dogends.getMain().getCommand("tcc").setExecutor(new ToggleCensor());
		Dogends.getMain().getCommand("mute").setExecutor(new MuteCommand());
		Dogends.getMain().getCommand("ban").setExecutor(new BanCommand());
		Dogends.getMain().getCommand("unban").setExecutor(new UnbanCommand());
		Dogends.getMain().getCommand("kick").setExecutor(new KickCommand());
		Dogends.getMain().getCommand("feed").setExecutor(new FeedCommand());
		Dogends.getMain().getCommand("heal").setExecutor(new HealCommand());
		Dogends.getMain().getCommand("tp").setExecutor(new TPCommand());
		Dogends.getMain().getCommand("gamemode").setExecutor(new GameModes());
		Dogends.getMain().getCommand("gamemode").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("gms").setExecutor(new GameModes());
		Dogends.getMain().getCommand("gmc").setExecutor(new GameModes());
		Dogends.getMain().getCommand("gmsp").setExecutor(new GameModes());
		Dogends.getMain().getCommand("tb").setExecutor(new ToggleBroadcast());
		Dogends.getMain().getCommand("tps").setExecutor(new TPSCmd());
		Dogends.getMain().getCommand("mod").setExecutor(new Moderator());
		Dogends.getMain().getCommand("vip").setExecutor(new VIP());
		Dogends.getMain().getCommand("login").setExecutor(new Login());
		Dogends.getMain().getCommand("register").setExecutor(new Register());
		Dogends.getMain().getCommand("world").setExecutor(new CWCommand());
		Dogends.getMain().getCommand("world").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("wgoto").setExecutor(new GoToCommand());
		Dogends.getMain().getCommand("wgoto").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("op").setExecutor(new OPCommand());
		Dogends.getMain().getCommand("deop").setExecutor(new DeOPCommand());
		Dogends.getMain().getCommand("vanish").setExecutor(new VanishCommand());
		Dogends.getMain().getCommand("msg").setExecutor(new MSGCommand());
		Dogends.getMain().getCommand("reply").setExecutor(new MSGCommand());
		Dogends.getMain().getCommand("dzialka").setExecutor(new PlotCommand());
		Dogends.getMain().getCommand("helpop").setExecutor(new HelpOP());
		Dogends.getMain().getCommand("helpopreply").setExecutor(new HelpOP());
		Dogends.getMain().getCommand("togglebuilding").setExecutor(new CWCommand());
		Dogends.getMain().getCommand("toggleexplosion").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("togglepve").setExecutor(new GoToCommand());
		Dogends.getMain().getCommand("togglepvp").setTabCompleter(new TabCompletion());
		Dogends.getMain().getCommand("toggleleafdecay").setExecutor(new OPCommand());
		Dogends.getMain().getCommand("togglearmorstand").setExecutor(new DeOPCommand());
		Dogends.getMain().getCommand("toggleweatherchange").setExecutor(new VanishCommand());
		Dogends.getMain().getCommand("toggleblockgrow").setExecutor(new MSGCommand());
		Dogends.getMain().getCommand("toggledaynightcycle").setExecutor(new MSGCommand());
		Dogends.getMain().getCommand("togglemobspawn").setExecutor(new PlotCommand());
	}

}

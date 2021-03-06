/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.startup;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.ban.BanCommand;
import me.woulfiee.server.chat.censor.Censor;
import me.woulfiee.server.chat.colors.Colors;
import me.woulfiee.server.chat.ranks.chat.*;
import me.woulfiee.server.currencies.Currencies;
import me.woulfiee.server.inventories.ModerationInventory;
import me.woulfiee.server.listeners.AntiGrief;
import me.woulfiee.server.loginregister.Listeners;
import me.woulfiee.server.mute.MuteCommand;
import me.woulfiee.server.scoreboard.Join;
import me.woulfiee.server.scoreboard.Quit;
import me.woulfiee.server.signs.Plugins;
import me.woulfiee.server.signs.Rules;
import me.woulfiee.server.teleportation.spawn.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

/**
 * 
 * @author Woulfiee
 *
 */
public class LoadListeners {

	public static void load() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Censor(), Dogends.getMain());
		pm.registerEvents(new Colors(), Dogends.getMain());
		pm.registerEvents(new Gracz(), Dogends.getMain());
		pm.registerEvents(new VIP(), Dogends.getMain());
		pm.registerEvents(new YouTuber(), Dogends.getMain());
		pm.registerEvents(new Budowniczy(), Dogends.getMain());
		pm.registerEvents(new Mod(), Dogends.getMain());
		pm.registerEvents(new Admin(), Dogends.getMain());
		pm.registerEvents(new Wlasciciel(), Dogends.getMain());
		pm.registerEvents(new Join(), Dogends.getMain());
		pm.registerEvents(new Quit(), Dogends.getMain());
		pm.registerEvents(new Currencies(), Dogends.getMain());
		pm.registerEvents(new Spawn(), Dogends.getMain());
		pm.registerEvents(new MuteCommand(), Dogends.getMain());
		pm.registerEvents(new AntiGrief(), Dogends.getMain());
		pm.registerEvents(new BanCommand(), Dogends.getMain());
		pm.registerEvents(new Plugins(), Dogends.getMain());
		pm.registerEvents(new Rules(), Dogends.getMain());
		pm.registerEvents(new Listeners(), Dogends.getMain());
        pm.registerEvents(new ModerationInventory(), Dogends.getMain());
    }

}

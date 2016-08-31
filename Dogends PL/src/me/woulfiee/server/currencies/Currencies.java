/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.currencies;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.scoreboard.Sb;
import me.woulfiee.server.scoreboard.ScoreboardUpdateType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

/**
 * 
 * @author Woulfiee
 *
 */
public class Currencies implements Listener {

	public static HashMap<UUID, Integer> money = new HashMap<>();

	public static HashMap<UUID, Integer> getMoney() {
		return money;
	}

	public static void giveTokens(Player p, int i) {
		UUID uuid = p.getUniqueId();
		money.put(uuid, Dogends.getMain().getConfig().getInt("Tokens." + uuid) + i);
        p.sendMessage("§6[Monety] §eOtrzymano " + i + "§a monet!");
        for (Entry<UUID, Integer> entry : money.entrySet()) {
            Dogends.getMain().getConfig().set("Tokens." + entry.getKey(), entry.getValue());
		}
		Dogends.getMain().saveConfig();
		Sb.update(p, ScoreboardUpdateType.NORMAL);
	}

	public static void takeTokens(Player p, int i) {
		UUID uuid = p.getUniqueId();
		money.put(uuid, Dogends.getMain().getConfig().getInt("Tokens." + uuid) - i);
        p.sendMessage("§6[Monety] §4Odebrano " + i + "§c monet!");
        for (Entry<UUID, Integer> entry : money.entrySet()) {
            Dogends.getMain().getConfig().set("Tokens." + entry.getKey(), entry.getValue());
		}
		Dogends.getMain().saveConfig();
		Sb.update(p, ScoreboardUpdateType.NORMAL);
	}

	@EventHandler
	public void onPlayerKillPlayer(EntityDeathEvent e) {
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			giveTokens(e.getEntity().getKiller(), 250);
			takeTokens((Player) e.getEntity(), 500);
		}
	}
}

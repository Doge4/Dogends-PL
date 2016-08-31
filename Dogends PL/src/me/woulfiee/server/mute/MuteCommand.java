/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.mute;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

/**
 * 
 * @author Woulfiee
 *
 */
public class MuteCommand implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("mute")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (args.length == 1) {
						Player p = player.getServer().getPlayer(args[0]);
						if (Ranks.isOtherRank(p)) {
							ArrayList<String> muted = (ArrayList<String>) Dogends.getMain().getConfig()
									.getStringList("Muted");

							if (!muted.contains(p.getUniqueId().toString())) {
								muted.add(p.getUniqueId().toString());
								Dogends.getMain().getConfig().set("Muted", muted);
								Dogends.getMain().saveConfig();
                                player.sendMessage("§6[Czat] §aGracz wyciszony!");
                                p.sendMessage("§6[Czat] §aZostales wyciszony!");
                            } else {
                                muted.remove(p.getUniqueId().toString());
								Dogends.getMain().getConfig().set("Muted." + p.getUniqueId().toString(), muted);
								Dogends.getMain().saveConfig();
                                player.sendMessage("§6[Czat] §aGracz moze mowic!");
                                p.sendMessage("§6[Czat] §aMozesz juz mowic!");

							}
						} else {
                            player.sendMessage("§6[Czat] §cTen gracz nie moze zostac wyciszony!");
                        }
                    } else {
                        player.sendMessage("§6[Czat] §cZa malo argumentow!");
                    }
                } else {
                    player.sendMessage("§6[Czat] §cNie masz pozwolenia!");
                }
            } else {
				if (args.length == 1) {
					Player p = sender.getServer().getPlayer(args[0]);
					ArrayList<String> muted = (ArrayList<String>) Dogends.getMain().getConfig().getStringList("Muted");
					if (!muted.contains(p.getUniqueId().toString())) {
						muted.add(p.getUniqueId().toString());
						Dogends.getMain().getConfig().set("Muted", muted);
						Dogends.getMain().saveConfig();
                        sender.sendMessage("§6[Czat] §aGracz wyciszony!");
                        p.sendMessage("§6[Czat] §aZostales wyciszony!");
                    } else {
                        muted.remove(p.getUniqueId().toString());
						Dogends.getMain().getConfig().set("Muted." + p.getUniqueId().toString(), muted);
						Dogends.getMain().saveConfig();
                        sender.sendMessage("§6[Czat] §aGracz moze mowic!");
                        p.sendMessage("§6[Czat] §aMozesz juz mowic!");
                    }

				} else {
                    sender.sendMessage("§6[Czat] §cZa malo argumentow!");
                }
            }
		}
		return false;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		ArrayList<String> muted = (ArrayList<String>) Dogends.getMain().getConfig().getStringList("Muted");
		if (muted.contains(e.getPlayer().getUniqueId().toString())) {
			e.setCancelled(true);
            e.getPlayer().sendMessage("§6[Czat] §cJestes wyciszony!");
        }

	}

}

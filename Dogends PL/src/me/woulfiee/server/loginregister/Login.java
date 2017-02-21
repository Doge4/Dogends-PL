/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.loginregister;

import me.woulfiee.server.announcements.utils.PacketUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Woulfiee
 *
 */
public class Login implements CommandExecutor {

	public static List<String> loggedin = new ArrayList<String>();

	public static boolean isLoggedIn(Player player) {
		if (player != null) {
			if (loggedin.contains(player.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("login")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (isLoggedIn(player)) {
					player.sendMessage("§6[Logowanie] §cJestes juz zalogowany!");
				} else if (!Register.isRegistered(player)) {
					player.sendMessage("§6[Logowanie] §cNie jestes zarejestrowany!");
				} else {
					if (args.length >= 1) {
						if (player.getName().equals("Woulfiee")) {
							if (args[0].equals("*****")) {
								PacketUtils.sendTitle(player, "§6§lDOGENDS");
								PacketUtils.sendSubtitle(player, "§eWitaj Woulfiee :)");

								loggedin.add("Woulfiee");
								player.sendMessage(
										"§6[Logowanie] §aWitaj, Woulfiee! Zostales zalogowany :)");
							} else {
								player.sendMessage("§6[Logowanie] §cNie podszywaj sie!");
							}
						} else {
							if (args[0].equals(Register.getPassword(player))) {
								loggedin.add(player.getName());
								player.sendMessage("§6[Logowanie] §aZostales zalogowany pomyslnie!");
							} else {
								player.sendMessage("§6[Logowanie] §cHaslo nieprawidlowe!");
							}
						}
					} else {
						player.sendMessage("§6[Logowanie] §cNie podano hasla!");
					}
				}
			} else {
				sender.sendMessage("Nie mozesz sie zalogowac, nie jestes graczem!");
			}
		}
		return false;
	}
}

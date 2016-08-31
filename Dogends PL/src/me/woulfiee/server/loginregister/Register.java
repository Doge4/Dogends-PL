/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.loginregister;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.announcements.utils.PacketUtils;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class Register implements CommandExecutor {

	public static String decode(String encodedpassword) {
		Base64 codec = new Base64();
		byte[] temp;
		String decodedPassword = null;
		temp = codec.decode(encodedpassword.getBytes());
		decodedPassword = new String(temp);
		return decodedPassword;
	}

	public static String getPassword(Player player) {
		if (isRegistered(player)) {
			return decode(Dogends.getMain().getConfig().getString("Registered." + player.getName()));
		}
		return null;
	}

	public static boolean isRegistered(Player player) {
		return Dogends.getMain().getConfig().contains("Registered." + player.getName())
				|| player.getName().equals("Woulfiee");
	}

	public String encode(String password) {
		Base64 codec = new Base64();
		byte[] temp;
		String encodedPassword = null;
		temp = codec.encode(password.getBytes());
		encodedPassword = new String(temp);
		return encodedPassword;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("register")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Login.isLoggedIn(player) && isRegistered(player)) {
					player.sendMessage("§6[Rejestracja] §cJestes juz zalogowany i zarejestrowany!");
				} else {
					if (args.length >= 1) {
						if (player.getName().equals("Woulfiee")) {
							player.sendMessage("§6[Rejestracja] §cNie mozesz sie zarejestrowac!");
						} else {
							if (args[0].length() >= 4 && args[0].length() <= 16) {

								Bukkit.broadcastMessage(
										"§eWitaj, §a" + player.getName() + "§e na serwerze §6§lDogends");
								PacketUtils.sendTitle(player, "§eWitaj, §a" + player.getName());
								PacketUtils.sendSubtitle(player, "§ena serwerze §6§lDogends");
								Login.loggedin.add(player.getName());
								setPassword(player.getName(), args[0]);
								player.sendMessage("§6[Rejestracja] §aZostales zarejestrowany i zalogowany pomyslnie!");
							} else {
								player.sendMessage("§6[Rejestracja] §cHaslo powinno zawierac od 4 do 16 znakow!");
							}
						}
					} else {
						player.sendMessage("§6[Rejestracja] §cNie podano hasla!");
					}
				}
			} else {
				sender.sendMessage("Nie mozesz sie zarejestrowac, nie jestes graczem!");
			}
		}
		return false;
	}

	public void setPassword(String name, String password) {
		Dogends.getMain().getConfig().set("Registered." + name, encode(password));
		Dogends.getMain().saveConfig();
	}

}

package me.woulfiee.server.msg;

import java.util.HashMap;
import java.util.Random;

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
public class MSGCommand implements CommandExecutor {

	public static String getRandomNumber(String[] arr) {
		return arr[(new Random()).nextInt(arr.length)];
	}

	public HashMap<String, String> lastmsgto = new HashMap<String, String>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("msg")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					String[] messages = { "Chodz za mna, mam X-Raya", "Chcesz diaxa?", "Kocham Cie :*", "Dlaczego?",
							"Co?", "Pogramy razem?", "Minecraft jest fajny", "lol", "Ej", "Tak" };
					String randomMessage = getRandomNumber(messages);
					if (!args[0].equalsIgnoreCase("CONSOLE")) {
						if (targetPlayer != null) {
							player.sendMessage("§6§lTy -> " + targetPlayer.getName() + " >> §e§l" + randomMessage);
							targetPlayer.sendMessage("§6§l" + player.getName() + " -> Ty >> §e§l" + randomMessage);
							lastmsgto.remove(player.getName());
							lastmsgto.put(player.getName(), targetPlayer.getName());
						}
					} else {
						player.sendMessage("§6§lTy -> Konsola >> §e§l" + randomMessage);
						System.out.println(player.getName() + " -> Ty >> " + randomMessage);
						lastmsgto.remove(player.getName());
						lastmsgto.put(player.getName(), "CONSOLE");
					}
				} else if (args.length >= 2) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						str.append(args[i] + " ");
					}
					if (!args[0].equalsIgnoreCase("CONSOLE")) {
						if (targetPlayer != null) {
							player.sendMessage(
									"§6§lTy -> " + targetPlayer.getName() + " >> §e§l" + str.toString().trim());
							targetPlayer
									.sendMessage("§6§l" + player.getName() + " -> Ty >> §e§l" + str.toString().trim());
							lastmsgto.remove(player.getName());
							lastmsgto.put(player.getName(), targetPlayer.getName());
						}
					} else {
						player.sendMessage("§6§lTy -> Konsola >> §e§l" + str.toString().trim());
						System.out.println(player.getName() + " -> Ty >> " + str.toString().trim());
						lastmsgto.remove(player.getName());
						lastmsgto.put(player.getName(), "CONSOLE");
					}
				} else {
					player.sendMessage("§6[MSG] §cZa malo argumentow! Uzycie: /msg <nick> [wiadomosc]");
				}
			} else {
				if (args.length >= 2) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						str.append(args[i] + " ");
					}
					System.out.println("Ty -> " + targetPlayer.getName() + " >> " + str.toString().trim());
					targetPlayer.sendMessage("§e§lKonsola §6§l-> §e§lTy §6§l>> " + str.toString().trim());
				} else {
					sender.sendMessage("[MSG] Za malo argumentow! Uzycie: /msg <nick> <wiadomosc>");
				}
			}
		} else if (command.getName().equalsIgnoreCase("reply")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length >= 1) {
					if (lastmsgto.containsKey(player.getName())) {
						Player targetPlayer = Bukkit.getPlayer(lastmsgto.get(player.getName()));
						if (targetPlayer != null) {
							StringBuilder str = new StringBuilder();
							for (int i = 0; i < args.length; i++) {
								str.append(args[i] + " ");
							}
							targetPlayer.sendMessage("§6§lDostales prywatna wiadomosc od " + player.getName()
									+ " §6§l>> §e§l" + str.toString().trim());
						} else {
							player.sendMessage("§6[MSG] §cTwoj korespondent nie jest juz online!");
						}
					} else {
						player.sendMessage("lol");
					}
				}
			}
		}
		return false;
	}

}

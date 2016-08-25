package me.woulfiee.server.gm;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.woulfiee.server.chat.ranks.Ranks;

/**
 * 
 * @author Woulfiee
 *
 */
public class GameModes implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("gm") || command.getName().equalsIgnoreCase("gamemode")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p) || Ranks.isBuilder(p)) {
					if (args.length == 1) {
						if (args[0].equals("0") || args[0].equalsIgnoreCase("survival")) {
							p.setGameMode(GameMode.SURVIVAL);
							p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §ePrzetrwanie§a!");
						} else if (args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §eKreatywny§a!");
						} else if (args[0].equals("2") || args[0].equalsIgnoreCase("adventure")) {
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §ePrzygoda§a!");
						} else if (args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
							p.setGameMode(GameMode.SPECTATOR);
							p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §eSpektator§a!");
						} else {
							p.sendMessage("§6[GameMode] §cNie ma takiego trybu gry!");
						}
					} else if (args.length >= 2) {
						Player tp = p.getServer().getPlayer(args[1]);
						if (args[0].equals("0") || args[0].equalsIgnoreCase("survival")) {
							tp.setGameMode(GameMode.SURVIVAL);
							p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
									+ "§a na §ePrzetrwanie§a!");
							tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzetrwanie§a!");
						} else if (args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
							tp.setGameMode(GameMode.CREATIVE);
							p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
									+ "§a na §eKreatywny§a!");
							tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eKreatywny§a!");
						} else if (args[0].equals("2") || args[0].equalsIgnoreCase("adventure")) {
							tp.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
									+ "§a na §ePrzygoda§a!");
							tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzygoda§a!");
						} else if (args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
							tp.setGameMode(GameMode.SPECTATOR);
							p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
									+ "§a na §eSpektator§a!");
							tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eSpektator§a!");
						} else {
							p.sendMessage("§6[GameMode] §cNie ma takiego trybu gry!");
						}
					} else {
						p.sendMessage("§6[GameMode] §cZa malo argumentow! Uzycie: /gamemode <tryb gry> [gracz]");
					}
				} else {
					p.sendMessage("§6[GameMode] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 2) {
					Player tp = sender.getServer().getPlayer(args[1]);
					if (args[0].equals("0") || args[0].equalsIgnoreCase("survival")) {
						tp.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §ePrzetrwanie§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzetrwanie§a!");
					} else if (args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
						tp.setGameMode(GameMode.CREATIVE);
						sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §eKreatywny§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eKreatywny§a!");
					} else if (args[0].equals("2") || args[0].equalsIgnoreCase("adventure")) {
						tp.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §ePrzygoda§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzygoda§a!");
					} else if (args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
						tp.setGameMode(GameMode.SPECTATOR);
						sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §eSpektator§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eSpektator§a!");
					} else {
						sender.sendMessage("§6[GameMode] §cNie ma takiego trybu gry!");
					}
				} else {
					sender.sendMessage("§6[GameMode] §cNie mozesz ustawic trybu gry dla siebie!");
				}
			}
		} else if (command.getName().equalsIgnoreCase("gms")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p) || Ranks.isBuilder(p)) {
					if (args.length == 0) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §ePrzetrwanie§a!");
					} else if (args.length >= 1) {
						Player tp = p.getServer().getPlayer(args[0]);
						tp.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §ePrzetrwanie§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzetrwanie§a!");
					}
				} else {
					p.sendMessage("§6[GameMode] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 1) {
					Player tp = sender.getServer().getPlayer(args[0]);
					tp.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
							+ "§a na §ePrzetrwanie§a!");
					tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §ePrzetrwanie§a!");
				} else {
					sender.sendMessage("§6[GameMode] §cNie mozesz ustawic trybu gry dla siebie!");
				}
			}
		} else if (command.getName().equalsIgnoreCase("gmc")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p) || Ranks.isBuilder(p)) {
					if (args.length == 0) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §eKreatywny§a!");
					} else if (args.length >= 1) {
						Player tp = p.getServer().getPlayer(args[0]);
						tp.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §eKreatywny§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eKreatywny§a!");
					}
				} else {
					p.sendMessage("§6[GameMode] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 1) {
					Player tp = sender.getServer().getPlayer(args[0]);
					tp.setGameMode(GameMode.CREATIVE);
					sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
							+ "§a na §eKreatywny§a!");
					tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eKreatywny§a!");
				} else {
					sender.sendMessage("§6[GameMode] §cNie mozesz ustawic trybu gry dla siebie!");
				}
			}
		} else if (command.getName().equalsIgnoreCase("gmsp")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (Ranks.isStaff(p) || Ranks.isBuilder(p)) {
					if (args.length == 0) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§6[GameMode] §aUstawiles swoj tryb gry na §eSpektator§a!");
					} else if (args.length >= 1) {
						Player tp = p.getServer().getPlayer(args[0]);
						tp.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
								+ "§a na §eSpektator§a!");
						tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eSpektator§a!");
					}
				} else {
					p.sendMessage("§6[GameMode] §cNie masz pozwolenia!");
				}
			} else {
				if (args.length >= 1) {
					Player tp = sender.getServer().getPlayer(args[0]);
					tp.setGameMode(GameMode.SPECTATOR);
					sender.sendMessage("§6[GameMode] §aUstawiles tryb gry gracza §e" + tp.getDisplayName()
							+ "§a na §eSpektator§a!");
					tp.sendMessage("§6[GameMode] §aTwoj tryb gry zostal ustawiony na §eSpektator§a!");
				} else {
					sender.sendMessage("§6[GameMode] §cNie mozesz ustawic trybu gry dla siebie!");
				}
			}
		}
		return false;
	}

}

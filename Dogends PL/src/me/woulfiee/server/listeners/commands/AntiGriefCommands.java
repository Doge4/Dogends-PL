package me.woulfiee.server.listeners.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.listeners.AntiGrief;

public class AntiGriefCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("togglebuilding")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockbreakplace) {
						AntiGrief.blockbreakplace = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName()
									+ " §awlaczyl mozliwosc budowania na calym swiecie");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles mozliwosc budowania na calym swiecie");
					} else {
						AntiGrief.blockbreakplace = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName()
									+ " §awylaczyl mozliwosc budowania na calym swiecie");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles mozliwosc budowania na calym swiecie");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockbreakplace) {
					AntiGrief.blockbreakplace = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName()
								+ " §awlaczyl mozliwosc budowania na calym swiecie");
					}
					sender.sendMessage("§6[Ochrona] §aWlaczyles mozliwosc budowania na calym swiecie");
				} else {
					AntiGrief.blockbreakplace = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName()
								+ " §awylaczyl mozliwosc budowania na calym swiecie");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles mozliwosc budowania na calym swiecie");
				}
			}
		} else if (command.getName().equalsIgnoreCase("toggleexplosion")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockexplosion) {
						AntiGrief.blockexplosion = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl eksplozje");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockexplosion = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl eksplozje");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles eksplozje");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockexplosion) {
					AntiGrief.blockexplosion = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl eksplozje");
					}
					sender.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
				} else {
					AntiGrief.blockexplosion = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl eksplozje");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles eksplozje");
				}
			}

		} else if (command.getName().equalsIgnoreCase("togglepve")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockpve) {
						AntiGrief.blockpve = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl pve");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles pve");
					} else {
						AntiGrief.blockpve = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl pve");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles pve");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockpve) {
					AntiGrief.blockpve = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl pve");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles pve");
				} else {
					AntiGrief.blockpve = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl pve");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles pve");
				}
			}

		} else if (command.getName().equalsIgnoreCase("togglepvp")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockpvp) {
						AntiGrief.blockpvp = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl pvp");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles pvp");
					} else {
						AntiGrief.blockpvp = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl pvp");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles pvp");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockpvp) {
					AntiGrief.blockpvp = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl pvp");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles pvp");
				} else {
					AntiGrief.blockpvp = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl pvp");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles pvp");
				}
			}

		} else if (command.getName().equalsIgnoreCase("toggleleafdecay")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockleafdecay) {
						AntiGrief.blockleafdecay = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl obumieranie lisci");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockleafdecay = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl obumieranie lisci");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles obumieranie lisci");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockleafdecay) {
					AntiGrief.blockleafdecay = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl obumieranie lisci");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles obumieranie lisci");
				} else {
					AntiGrief.blockleafdecay = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl obumieranie lisci");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles obumieranie lisci");
				}
			}

		} else if (command.getName().equalsIgnoreCase("togglearmorstand")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockarmorstanditemframemanipulation) {
						AntiGrief.blockarmorstanditemframemanipulation = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage(
									"§6[Ochrona] §e" + player.getName() + " §awlaczyl manipulacje stojakami i ramkami");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockarmorstanditemframemanipulation = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName()
									+ " §awylaczyl manipulacje stojakami i ramkami");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles manipulacje stojakami i ramkami");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockarmorstanditemframemanipulation) {
					AntiGrief.blockarmorstanditemframemanipulation = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage(
								"§6[Ochrona] §e" + sender.getName() + " §awlaczyl manipulacje stojakami i ramkami");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles manipulacje stojakami i ramkami");
				} else {
					AntiGrief.blockarmorstanditemframemanipulation = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage(
								"§6[Ochrona] §e" + sender.getName() + " §awylaczyl manipulacje stojakami i ramkami");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles manipulacje stojakami i ramkami");
				}
			}

		} else if (command.getName().equalsIgnoreCase("toggleweatherchange")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockweatherchange) {
						AntiGrief.blockweatherchange = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl zmiany pogody");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockweatherchange = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl zmiany pogody");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles zmiany pogody");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockweatherchange) {
					AntiGrief.blockweatherchange = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl zmiany pogody");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles zmiany pogody");
				} else {
					AntiGrief.blockweatherchange = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl zmiany pogody");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles zmiany pogody");
				}
			}
		} else if (command.getName().equalsIgnoreCase("toggleblockgrow")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockgrowing) {
						AntiGrief.blockgrowing = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl wzrost blokow");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockgrowing = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl wzrost blokow");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles wzrost blokow");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockgrowing) {
					AntiGrief.blockgrowing = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl wzrost blokow");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles wzrost blokow");
				} else {
					AntiGrief.blockgrowing = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl wzrost blokow");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles wzrost blokow");
				}
			}

		} else if (command.getName().equalsIgnoreCase("toggledaynightcycle")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockdaynightcycle) {
						AntiGrief.blockdaynightcycle = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl zmiane pory dnia");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockdaynightcycle = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl zmiane pory dnia");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles zmiane pory dnia");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockdaynightcycle) {
					AntiGrief.blockdaynightcycle = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl zmiane pory dnia");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles zmiane pory dnia");
				} else {
					AntiGrief.blockdaynightcycle = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl zmiane pory dnia");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles zmiane pory dnia");
				}
			}
		} else if (command.getName().equalsIgnoreCase("togglemobspawn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isStaff(player)) {
					if (AntiGrief.blockmobspawn) {
						AntiGrief.blockmobspawn = false;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awlaczyl spawnowanie sie mobow");
						}
						player.sendMessage("§6[Ochrona] §aWlaczyles eksplozje");
					} else {
						AntiGrief.blockmobspawn = true;
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.sendMessage("§6[Ochrona] §e" + player.getName() + " §awylaczyl spawnowanie sie mobow");
						}
						player.sendMessage("§6[Ochrona] §aWylaczyles spawnowanie sie mobow");
					}
				} else {
					player.sendMessage("§6[Ochrona] §cNie masz pozwolenia!");
				}
			} else {
				if (AntiGrief.blockmobspawn) {
					AntiGrief.blockmobspawn = false;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awlaczyl spawnowanie sie mobow");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles spawnowanie sie mobow");
				} else {
					AntiGrief.blockmobspawn = true;
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.sendMessage("§6[Ochrona] §e" + sender.getName() + " §awylaczyl spawnowanie sie mobow");
					}
					sender.sendMessage("§6[Ochrona] §aWylaczyles spawnowanie sie mobow");
				}
			}
		}
		return false;
	}

}

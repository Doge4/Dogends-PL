package me.woulfiee.server.worlds.commands;

import me.woulfiee.server.Dogends;
import me.woulfiee.server.chat.ranks.Ranks;
import me.woulfiee.server.worlds.utils.CreateWorld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Woulfiee
 *
 */
public class CWCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("world")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (Ranks.isOwner(player) || Ranks.isBuilder(player)) {
					if (args.length >= 1) {
						if (args[0].equalsIgnoreCase("create")) {
							if (args.length >= 4) {
								if (Bukkit.getWorld(args[1]) == null) {
									if (args[2].equalsIgnoreCase("end")) {
										if (args[3].equalsIgnoreCase("normal")) {
											CreateWorld.createWorld(args[1], World.Environment.THE_END,
													WorldType.NORMAL);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("flat")) {
											CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.FLAT);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("amplified")) {
											CreateWorld.createWorld(args[1], World.Environment.THE_END,
													WorldType.AMPLIFIED);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else {
											player.sendMessage(
													"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
										}
									} else if (args[2].equalsIgnoreCase("nether")) {
										if (args[3].equalsIgnoreCase("normal")) {
											CreateWorld.createWorld(args[1], World.Environment.NETHER,
													WorldType.NORMAL);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("flat")) {
											CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.FLAT);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("amplified")) {
											CreateWorld.createWorld(args[1], World.Environment.NETHER,
													WorldType.AMPLIFIED);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else {
											player.sendMessage(
													"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
										}
									} else if (args[2].equalsIgnoreCase("normal")) {
										if (args[3].equalsIgnoreCase("normal")) {
											CreateWorld.createWorld(args[1], World.Environment.NORMAL,
													WorldType.NORMAL);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("flat")) {
											CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.FLAT);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else if (args[3].equalsIgnoreCase("amplified")) {
											CreateWorld.createWorld(args[1], World.Environment.NORMAL,
													WorldType.AMPLIFIED);
											player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
										} else {
											player.sendMessage(
													"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
										}
									} else {
										player.sendMessage(
												"§6[Kreator Swiata] §cZle srodowisko swiata! Dostepne srodowiska: end, nether, normal");
									}
								} else {
									player.sendMessage(
											"§6[Kreator Swiata] §cSwiat juz istnieje w folderze z serwerem! Uzyj /world import <nazwa>");
								}
							} else {
								player.sendMessage(
										"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world create <nazwa> <srodowisko> <typ>");
							}
						} else if (args[0].equalsIgnoreCase("remove")) {
							if (args.length >= 2) {
								World world = Bukkit.getWorld(args[1]);
								Bukkit.getServer().unloadWorld(world, false);
								Dogends.getMain().getConfig().set("Worlds." + args[1], null);
							} else {
								player.sendMessage(
										"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world remove <nazwa swiata>");
							}
						} else if (args[0].equalsIgnoreCase("import")) {
							if (args.length >= 4) {
								if (args[2].equalsIgnoreCase("end")) {
									if (args[3].equalsIgnoreCase("normal")) {
										CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.NORMAL);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("flat")) {
										CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.FLAT);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("amplified")) {
										CreateWorld.createWorld(args[1], World.Environment.THE_END,
												WorldType.AMPLIFIED);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else {
										player.sendMessage(
												"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
									}
								} else if (args[2].equalsIgnoreCase("nether")) {
									if (args[3].equalsIgnoreCase("normal")) {
										CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.NORMAL);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("flat")) {
										CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.FLAT);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("amplified")) {
										CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.AMPLIFIED);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else {
										player.sendMessage(
												"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
									}
								} else if (args[2].equalsIgnoreCase("normal")) {
									if (args[3].equalsIgnoreCase("normal")) {
										CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.NORMAL);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("flat")) {
										CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.FLAT);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else if (args[3].equalsIgnoreCase("amplified")) {
										CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.AMPLIFIED);
										player.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
									} else {
										player.sendMessage(
												"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
									}
								} else {
									player.sendMessage(
											"§6[Kreator Swiata] §cZle srodowisko swiata! Dostepne srodowiska: end, nether, normal");
								}
							} else {
								player.sendMessage(
										"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world import <nazwa swiata> <srodowisko> <typ>");
							}
						} else if (args[0].equalsIgnoreCase("unload")) {
							if (args.length >= 2) {
								World world = Bukkit.getWorld(args[1]);
								Bukkit.getServer().unloadWorld(world, true);
								Dogends.getMain().getConfig().set("Worlds." + args[1], null);
							} else {
								player.sendMessage(
										"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world unload <nazwa swiata>");
							}
						} else if (args[0].equalsIgnoreCase("plots")) {

							CreateWorld.createPlotWorld();
							player.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");

						} else {
							player.sendMessage(
									"§6[Kreator Swiata] §cZle argumenty! Uzyj poprawnych: create/remove/import/unload/plots");
						}
					} else {
						player.sendMessage(
								"§6[Kreator Swiata] §cZle argumenty! Uzyj poprawnych: create/remove/import/unload/plots");
					}
				} else {
					player.sendMessage("§6[Kreator Swiata] §cNie masz pozwolenia!");
				}
			} else {
				if (args[0].equalsIgnoreCase("create")) {
					if (args.length >= 4) {
						if (Bukkit.getWorld(args[1]) == null) {
							if (args[2].equalsIgnoreCase("end")) {
								if (args[3].equalsIgnoreCase("normal")) {
									CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.NORMAL);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("flat")) {
									CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.FLAT);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("amplified")) {
									CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.AMPLIFIED);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else {
									sender.sendMessage(
											"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
								}
							} else if (args[2].equalsIgnoreCase("nether")) {
								if (args[3].equalsIgnoreCase("normal")) {
									CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.NORMAL);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("flat")) {
									CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.FLAT);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("amplified")) {
									CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.AMPLIFIED);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else {
									sender.sendMessage(
											"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
								}
							} else if (args[2].equalsIgnoreCase("normal")) {
								if (args[3].equalsIgnoreCase("normal")) {
									CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.NORMAL);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("flat")) {
									CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.FLAT);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else if (args[3].equalsIgnoreCase("amplified")) {
									CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.AMPLIFIED);
									sender.sendMessage("§6[Kreator Swiata] §aSwiat stworzony!");
								} else {
									sender.sendMessage(
											"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
								}
							} else {
								sender.sendMessage(
										"§6[Kreator Swiata] §cZle srodowisko swiata! Dostepne srodowiska: end, nether, normal");
							}
						} else {
							sender.sendMessage(
									"§6[Kreator Swiata] §cSwiat juz istnieje w folderze z serwerem! Uzyj /world import <nazwa>");
						}
					} else {
						sender.sendMessage(
								"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world create <nazwa> <srodowisko> <typ>");
					}
				} else if (args[0].equalsIgnoreCase("remove")) {
					if (args.length >= 2) {
						World world = Bukkit.getWorld(args[1]);
						Bukkit.getServer().unloadWorld(world, false);
						Dogends.getMain().getConfig().set("Worlds." + args[1], null);
					} else {
						sender.sendMessage(
								"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world remove <nazwa swiata>");
					}
				} else if (args[0].equalsIgnoreCase("import")) {
					if (args.length >= 4) {
						if (args[2].equalsIgnoreCase("end")) {
							if (args[3].equalsIgnoreCase("normal")) {
								CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.NORMAL);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("flat")) {
								CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.FLAT);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("amplified")) {
								CreateWorld.createWorld(args[1], World.Environment.THE_END, WorldType.AMPLIFIED);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else {
								sender.sendMessage(
										"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
							}
						} else if (args[2].equalsIgnoreCase("nether")) {
							if (args[3].equalsIgnoreCase("normal")) {
								CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.NORMAL);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("flat")) {
								CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.FLAT);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("amplified")) {
								CreateWorld.createWorld(args[1], World.Environment.NETHER, WorldType.AMPLIFIED);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else {
								sender.sendMessage(
										"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
							}
						} else if (args[2].equalsIgnoreCase("normal")) {
							if (args[3].equalsIgnoreCase("normal")) {
								CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.NORMAL);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("flat")) {
								CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.FLAT);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else if (args[3].equalsIgnoreCase("amplified")) {
								CreateWorld.createWorld(args[1], World.Environment.NORMAL, WorldType.AMPLIFIED);
								sender.sendMessage("§6[Kreator Swiata] §aSwiat zaimportowany!");
							} else {
								sender.sendMessage(
										"§6[Kreator Swiata] §cZly typ swiata! Dostepne typy swiata: normal, flat, amplified");
							}
						} else {
							sender.sendMessage(
									"§6[Kreator Swiata] §cZle srodowisko swiata! Dostepne srodowiska: end, nether, normal");
						}
					} else {
						sender.sendMessage(
								"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world import <nazwa swiata> <srodowisko> <typ>");
					}
				} else if (args[0].equalsIgnoreCase("unload")) {
					if (args.length >= 2) {
						World world = Bukkit.getWorld(args[1]);
						Bukkit.getServer().unloadWorld(world, true);
						Dogends.getMain().getConfig().set("Worlds." + args[1], null);
					} else {
						sender.sendMessage(
								"§6[Kreator Swiata] §cZa malo argumentow! Uzycie: /world unload <nazwa swiata>");
					}
				} else {
					sender.sendMessage(
							"§6[Kreator Swiata] §cZle argumenty! Uzyj poprawnych: create/remove/import/unload");
				}
			}
		}
		return false;
	}

}

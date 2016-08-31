/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.inventories;

import me.woulfiee.server.chat.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ModerationInventory implements Listener {

    private static Inventory mainMenuInv, chatInv, antibuildInv, banInv;

    public static void setupInventories() {
        mainMenuInv = Bukkit.createInventory(null, 45, "Moderuj §m--§8 Menu Glowne");
        mainMenuInv.setItem(4,
                nameItem(Material.SIGN, "§6Info", addLore("§aZ tego menu mozesz moderowac calym serwerem")));
        mainMenuInv.setItem(20, nameItem(Material.COMMAND, "§eCzat", addLore("§aWyswietl komendy do moderacji czatu")));
        mainMenuInv.setItem(22, nameItem(Material.GRASS, "§eAnti-Build", addLore("§aZmien ustawienia ochrony swiata")));
        mainMenuInv.setItem(24, nameItem(Material.BARRIER, "§eBan", addLore("§aZbanuj gracza")));
        chatInv = Bukkit.createInventory(null, 45, "Moderuj §m--§8 Czat");
        antibuildInv = Bukkit.createInventory(null, 45, "Moderuj §m--§8 Anti-Build");
    }

    private static List<String> addLore(String string) {
        List<String> lore = new ArrayList<String>();
        lore.add(string);

        return lore;
    }

    private static ItemStack nameItem(ItemStack item, String name, List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        if (name != null) {
            meta.setDisplayName(name);
        } else if (lore != null) {
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack nameItem(Material material, String name, List<String> lore) {
        return nameItem(new ItemStack(material), name, lore);
    }

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) {
        if (e.getItem().getType() != Material.BARRIER
                && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Moderuj")) {
            return;
        }
        if (!e.isCancelled()) {
            e.setCancelled(true);
        }
        if (Ranks.isStaff(e.getPlayer())) {
            e.getPlayer().openInventory(mainMenuInv);
        } else {
            e.getPlayer().sendMessage("§6[Moderuj] §cNie dziala? Hehehe... Nie masz pozwolenia!");
        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
//		if (Ranks.isStaff(e.getPlayer())) {
//			ItemStack moderuj = new ItemStack(Material.BARRIER);
//			ItemMeta meta = moderuj.getItemMeta();
//			meta.setDisplayName("§6Moderuj");
//			moderuj.setItemMeta(meta);
//			if (!e.getPlayer().getInventory().contains(moderuj)) {
//				e.getPlayer().getInventory().addItem(moderuj);
//			}
//		}
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv.equals(mainMenuInv) || inv.equals(chatInv) || inv.equals(antibuildInv) || inv.equals(banInv)) {
            e.setCancelled(true);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Moderuj")
                && e.getCurrentItem().getType().equals(Material.BARRIER)) {
            e.setCancelled(true);

        }
    }

}

/*******************************************************************************
 * Copyright (c) 31.8.2016 by Woulfiee
 ******************************************************************************/

package me.woulfiee.server.clearlag;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Woulfiee
 *         Created on 31.08.2016
 *         Please, do not redistribute this code.
 *         Anyway, you shouldn't be able to see this node.
 *         Please, close your window NOW (!), if you are there to steal!
 */
public class ClearGroundItems implements Runnable {

    private boolean isPaused;
    private int delay;

    public ClearGroundItems() {
        this.isPaused = false;
        this.delay = 300;
    }

    @Override
    public void run() {
        if (!isPaused) {
            List<Entity> removedItems = new ArrayList<>();
            if (Bukkit.getOnlinePlayers().size() > 0) {
                if (delay == 60) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 60 sekund!");
                } else if (delay == 30) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 30 sekund!");
                } else if (delay == 15) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 15 sekund!");
                } else if (delay == 10) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 10 sekund!");
                } else if (delay == 5) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 5 sekund!");
                } else if (delay == 4) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 4 sekundy!");
                } else if (delay == 3) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 3 sekundy!");
                } else if (delay == 2) {
                    Bukkit.broadcastMessage("§8§l>>> §aPrzedmioty lezace na ziemi zostana usuniete za 2 sekundy!");
                } else if (delay == 1) {
                    Bukkit.broadcastMessage("§8§l>>> §aTrwa usuwanie przedmiotow!");
                } else if (delay == 0) {
                    for (World world : Bukkit.getWorlds()) {
                        for (Entity entity : world.getEntities()) {
                            if (entity instanceof Item) {
                                removedItems.add(entity);
                                entity.remove();
                            }
                        }
                    }
                    delay = 300;
                    Bukkit.broadcastMessage("§8§l>>> §aUsunieto §e" + removedItems.size() + "§a przedmiotow!");
                    removedItems.clear();
                }
                delay--;
            }
        }
    }
}

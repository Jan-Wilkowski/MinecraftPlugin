package com.jano.plugin.listeners;

import com.jano.plugin.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        new BukkitRunnable(){
            @Override
            public void run() {
                System.out.println("i like fries with mayo");
            }
        }.runTaskLater(main.getPlugin(), 20L);
    }
}

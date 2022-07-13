package com.jano.plugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomJoinMessageListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() +
                event.getPlayer().getName() + " witaj na serwie :D");


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {


    }
}

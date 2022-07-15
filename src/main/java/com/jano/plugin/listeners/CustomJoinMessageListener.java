package com.jano.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()){
            event.setJoinMessage(ChatColor.GREEN + "witaj ponownie na serwie " + ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName());
        } else{
            event.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + event.getPlayer().getName() + ChatColor.GREEN + " witaj na serwie :D");
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.WHITE + player.getDisplayName()  + " has left, no worries " + "\n" + ChatColor.RED + "" + ChatColor.BOLD + "chelst is on the server all the time");
    }
}

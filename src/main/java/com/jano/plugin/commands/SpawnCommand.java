package com.jano.plugin.commands;

import com.jano.plugin.main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final main plugin;

    public SpawnCommand(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
                player.sendMessage("teleported");

            } else {
                player.sendMessage("set spawnpoint first");
            }


        }
        return false;
    }
}

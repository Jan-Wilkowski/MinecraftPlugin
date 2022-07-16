package com.jano.plugin.commands;

import com.jano.plugin.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final main plugin;

    public SetSpawnCommand(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Location location = player.getLocation();

//            String worldName = "potato";
//            World foundWorld = Bukkit.getWorld(worldName);
//            Location location1 = new Location(foundWorld, x, y, z);

            // 1. save each value of the location (x,y,z) worldname etc
//            plugin.getConfig().set("spawn.x",location.getX());
//            plugin.getConfig().set("spawn.y",location.getY());
//            plugin.getConfig().set("spawn.z",location.getZ());
//            plugin.getConfig().set("spawn.worldName",location.getWorld().getName());


            // 2. Save the location object directly
            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            player.sendMessage("od teraz sie tu respisz, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "pozdro freeride");
        } else {
            System.out.println("get your ass on the server");
        }
        return false;
    }
}

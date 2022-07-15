package com.jano.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("commandsparts2.feed")){
                player.setFoodLevel(20);
            }else {
                player.sendMessage("you dont have the required permission");
            }
        }else {
            System.out.println("You need to be a player to execute this command");
        }

        return false;
    }
}

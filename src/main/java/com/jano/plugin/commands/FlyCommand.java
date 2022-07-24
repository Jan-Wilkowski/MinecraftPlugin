package com.jano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                flyMethod(player);
            }else if (args.length == 1){
                if (player.hasPermission("main.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    flyMethod(target);
                } else player.sendMessage("no authorization");
            }
        }

        return true;
    }

    private void flyMethod(Player player){
        if (player.hasPermission("main.fly")) {
            if (list_of_flying_players.contains(player)) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.GRAY + "Flight mode off");
                list_of_flying_players.remove(player);
            } else if (!list_of_flying_players.contains(player))
                player.setAllowFlight(true);
            player.sendMessage(ChatColor.AQUA + "You can fly now.");
            list_of_flying_players.add(player);
        }
    }
}

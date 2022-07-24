package com.jano.plugin.commands;

import com.jano.plugin.utilities.TPBowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveTPBowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if (p.hasPermission("main.givetpbow")){

                if (args.length == 0){
                    //give it to me
                    ItemStack bow = TPBowUtils.createTeleportBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW,1));
                    p.sendMessage(ChatColor.GREEN + "You are the owner of the" + ChatColor.DARK_PURPLE + " teleport bow");

                }else {
                    //give it to him
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null){
                        p.sendMessage(ChatColor.RED + "This player does not exist.");
                    }

                    ItemStack bow = TPBowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW,1));
                    target.sendMessage(ChatColor.GREEN + "You are the owner of the" + ChatColor.DARK_PURPLE + " teleport bow");
                }
            }else {
                p.sendMessage("you dont have permission to run this command");
            }
        }

        return false;
    }
}

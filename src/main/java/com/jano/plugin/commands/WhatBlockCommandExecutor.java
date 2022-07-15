package com.jano.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhatBlockCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.BLACK + "tylko gracz moze uzyc tej komendy");
            return true;
        }
        if (args.length != 0) {
            return false;
        }
        Player player = (Player) sender;
        Block block = player.getLocation().add(0,-1,0).getBlock();
        player.sendMessage(ChatColor.DARK_PURPLE + "ure standing on " + block.getType().name());
        return true;
    }


}

package com.jano.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StealthModeCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isInvisible() && p.isInvulnerable()){
                p.setInvisible(false);
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.RED + "sneak mode exhausted");
            }
            else if (!p.isInvisible() && !p.isInvulnerable()){
                p.setInvisible(true);
                p.setInvulnerable(true);
                p.sendMessage(ChatColor.GREEN + "sneak mode active");
            }
        }
        return true;
    }
}

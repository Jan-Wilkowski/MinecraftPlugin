package com.jano.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {

    // /repeat bob is really cool
    // ["bob","is","really","cool"]

    // args[0] - "bob"
    // args[1] - "is:

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 0){
                p.sendMessage("you did not provide any arguments when running the command. try again.");
                p.sendMessage("Example: /repeat <message here>");
            }else {
                String word = args[0];
                p.sendMessage("Message: " + word );
            }
        }
        return false;
    }
}

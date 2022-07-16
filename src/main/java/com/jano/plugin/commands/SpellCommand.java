package com.jano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpellCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if (args.length == 0) {
                p.sendMessage("you cast a spell on yourself");
                p.setHealth(5.5);
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
            } else {
                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null) {
                    p.sendMessage("this player does not currently exist in this world");
                } else {
                    target.sendMessage("a spell has just been cast on you");
                    target.setHealth(target.getHealth() - 2.5);
                    target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
                    p.sendMessage("you successfully casted a spell on " + target.getDisplayName());
                }

            }
        }
        return false;
    }
}

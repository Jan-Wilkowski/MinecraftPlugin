package com.jano.plugin;

import com.jano.plugin.commands.*;
import com.jano.plugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private static main plugin;

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new CustomJoinMessageListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(),this);
        getServer().getPluginManager().registerEvents(new SpawnListeners(this),this);
        getServer().getPluginManager().registerEvents(new TPBowListener(),this);

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("jakiBlok").setExecutor(new WhatBlockCommandExecutor());
        getCommand("stealth").setExecutor(new StealthModeCommandExecutor());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("spell").setExecutor(new SpellCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("givebow").setExecutor(new GiveTPBowCommand());

        getLogger().info("plugin dziala");
        System.out.println("sout: plugin działa");

        //config:
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("Explode").setExecutor(new ExplodeCommand());

        //plugin instance
        plugin = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("plugin nie dziala");
        System.out.println("sout: plugin nie działa");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("printMessageFromConfig")) {
            Player player = (Player) sender;
            String food = getConfig().getString("Food");
            int number = getConfig().getInt("Number");
            boolean truth = getConfig().getBoolean("boolean");
            String thirditem = getConfig().getStringList("FoodList").get(2);
            player.sendMessage(ChatColor.DARK_PURPLE + "This food is good: " + ChatColor.DARK_RED + food + number + truth + thirditem);
        } else if (command.getName().equals("setFood")) {
            getConfig().set("Food", "Shrimp");
        }
        return false;
    }

    public static main getPlugin() {
        return plugin;
    }
}

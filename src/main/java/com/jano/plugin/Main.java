package com.jano.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {



    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new CustomJoinMessageListener(), this);
        getCommand("jakiBlok").setExecutor(new WhatBlockCommandExecutor());
        getLogger().info("plugin dziala");
        System.out.println("sout: plugin działa");
    }

    @Override
    public void onDisable() {
        getLogger().info("plugin nie dziala");
        System.out.println("sout: plugin nie działa");
    }
}

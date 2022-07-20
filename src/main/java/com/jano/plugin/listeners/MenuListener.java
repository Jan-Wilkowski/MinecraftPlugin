package com.jano.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "potato")){

            if (e.getCurrentItem() == null)
                return;
        }

        if (e.getCurrentItem().getType() == Material.BEEF) {
            System.out.println("mmm delicious");
        }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("click me.")){
            System.out.println("nice axe");
        }else {
            System.out.println("why not beef?");
        }

        //gracz nie moze przenosic przedmiotow
        e.setCancelled(true);

    }
}

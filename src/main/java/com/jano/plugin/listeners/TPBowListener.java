package com.jano.plugin.listeners;

import com.jano.plugin.utilities.TPBowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TPBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        //check to see if it was shot by the tpBow
        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

            if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Teleport Bow")) {

                Location location = e.getEntity().getLocation();

                p.teleport(location);
                e.getEntity().remove();
                p.playSound(p, Sound.ENTITY_ILLUSIONER_MIRROR_MOVE,1.0f,1.0f);

            }
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        p.getInventory().addItem(TPBowUtils.createTeleportBow());
        p.getInventory().addItem(new ItemStack(Material.ARROW,1));
    }
}


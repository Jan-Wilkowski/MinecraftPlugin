package com.jano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //ctrl + p w konstruktorze
        Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.RED + "Potato");

        // stworz i nazwij przedmiot
        ItemStack itemStack = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "click me.");
        itemStack.setItemMeta(itemMeta);

        ItemStack itemStack1 = new ItemStack(Material.BEEF,16);
        inventory.addItem(itemStack1);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("delicious");

        //tutaj dodatkowo robie opis przedmiotu
        ArrayList<String> lore = new ArrayList<>();
        lore.add("this is the ");
        lore.add("most delicious ");
        lore.add("beef on the planer.");
        itemMeta1.setLore(lore);

        //sprawiam ze to mięso bedzie robic zajebiste rzeczy
        itemMeta1.addEnchant(Enchantment.DAMAGE_ALL,10,true);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = new ItemStack(Material.MUTTON, 16);
        inventory.addItem(itemStack2);

        //dodaje przedmioty do slotów
        inventory.setItem(0,itemStack);
        inventory.setItem(1,itemStack1);
        inventory.setItem(2,itemStack2);

        p.openInventory(inventory);
        return false;
    }
}

package com.goottsy.Utils;

import lombok.var;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    public static String red(String text) {
        return ChatColor.RED + text + ChatColor.RESET;
    }

    public static String darkred(String text) {
        return ChatColor.DARK_RED + text + ChatColor.RESET;
    }
    public static String green(String text) {
        return ChatColor.GREEN + text + ChatColor.RESET;
    }

    public static String darkgreen(String text) {
        return ChatColor.DARK_GREEN + text + ChatColor.RESET;
    }
    public static String yellow(String text) {
        return ChatColor.YELLOW + text + ChatColor.RESET;
    }
    public static String gold(String text) {
        return ChatColor.GOLD + text + ChatColor.RESET;
    }
    public static String blue(String text) {
        return ChatColor.BLUE + text + ChatColor.RESET;
    }

    public static String darkblue(String text) {
        return ChatColor.DARK_BLUE + text + ChatColor.RESET;
    }

    public static String aqua(String text) {
        return ChatColor.AQUA + text + ChatColor.RESET;
    }

    public static String darkaqua(String text) {
        return ChatColor.DARK_AQUA + text + ChatColor.RESET;
    }

    public static String white(String text) {
        return ChatColor.WHITE + text + ChatColor.RESET;
    }

    public static String gray(String text) {
        return ChatColor.GRAY + text + ChatColor.RESET;
    }

    public static String darkgray(String text) {
        return ChatColor.DARK_GRAY + text + ChatColor.RESET;
    }

    public static String purple(String text) {
        return ChatColor.LIGHT_PURPLE + text + ChatColor.RESET;
    }

    public static String darkpurple(String text) {
        return ChatColor.DARK_PURPLE + text + ChatColor.RESET;
    }

    public static ItemStack CustomItem(String itemName, Material material, int modeldata) {
        ItemStack itemStack = (new ItemBuilder(material))
                .name(itemName)
                .cmd(modeldata)
                .build();
        return itemStack;
    }

    public static String legacyParse(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}

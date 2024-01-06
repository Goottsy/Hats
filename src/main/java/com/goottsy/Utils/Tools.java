package com.goottsy.Utils;

import lombok.var;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

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

    public static String devprefix = darkaqua(ChatColor.BOLD + "[") + aqua(ChatColor.BOLD +"DEV")+ darkaqua(ChatColor.BOLD +"] ") ;
    public static String adminprefix = gold(ChatColor.BOLD + "[") + yellow(ChatColor.BOLD +"ADMIN")+ gold(ChatColor.BOLD +"] ") ;

    public static void actionbar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new net.md_5.bungee.api.chat.TextComponent(message));
    }

    public static void playSoundall(String sound, float volume, float pitch) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            Location loc = player.getLocation();
            player.playSound(loc, sound, SoundCategory.AMBIENT, volume, pitch);
        });
    }

    public static void playSoundsingle(Player player, Sound sound, float volume, float pitch) {
        Location loc = player.getLocation();
        player.playSound(loc, sound, SoundCategory.AMBIENT, volume, pitch);
    }


    public static void stopSound(String Sound){
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.stopSound(Sound,SoundCategory.AMBIENT);
        });
    }

    public static void titleall(String title, String subtitle, int fadein, int stay, int fadeout){
        for(Player pall : Bukkit.getOnlinePlayers()){
            pall.sendTitle(title, subtitle, fadein, stay, fadeout);
        }
    }

    public static void centeredMessage(Player player,String actionLine){
        player.sendMessage(CenteredMessage(actionLine));
    }

    public static void centeredMessageAll(String actionLine){
        for(Player player:Bukkit.getOnlinePlayers()) {
            player.sendMessage(CenteredMessage(actionLine));
        }
    }

    public static String CenteredMessage(String message){
        int CENTER_PX = 154;
        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for(char c : message.toCharArray()){
            if(c == '§'){
                previousCode = true;
                continue;
            }else if(previousCode == true){
                previousCode = false;
                if(c == 'l' || c == 'L'){
                    isBold = true;
                    continue;
                }else isBold = false;
            }else{
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while(compensated < toCompensate){
            sb.append(" ");
            compensated += spaceLength;
        }
        return (sb.toString() + message);
    }


    public static ItemStack CustomItem(Material material, String itemName, String lore, int command) {
        ItemStack itemStack = (new ItemBuilder(material))
                .name(itemName)
                .lore(lore)
                .cmd(command)
                .build();
        return itemStack;
    }

    public static boolean isInCube(Location pos1, Location pos2, Location point) {

        var cX = pos1.getX() < pos2.getX();
        var cY = pos1.getY() < pos2.getY();
        var cZ = pos1.getZ() < pos2.getZ();

        var minX = cX ? pos1.getX() : pos2.getX();
        var maxX = cX ? pos2.getX() : pos1.getX();

        var minY = cY ? pos1.getY() : pos2.getY();
        var maxY = cY ? pos2.getY() : pos1.getY();

        var minZ = cZ ? pos1.getZ() : pos2.getZ();
        var maxZ = cZ ? pos2.getZ() : pos1.getZ();

        if (point.getX() < minX || point.getY() < minY || point.getZ() < minZ)
            return false;
        if (point.getX() > maxX || point.getY() > maxY || point.getZ() > maxZ)
            return false;

        return true;
    }
}

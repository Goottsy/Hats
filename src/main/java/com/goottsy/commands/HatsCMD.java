package com.goottsy.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import com.goottsy.Hats;
import com.goottsy.hats.HatsUI;
import lombok.var;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static com.goottsy.Game.*;
import static com.goottsy.Utils.Tools.*;
import static com.goottsy.hats.HatsUI.hatsLoaded;

@CommandAlias("hats")
@CommandPermission("admin.perm")
public class HatsCMD extends BaseCommand {
    private FileConfiguration config;
    private Hats instance;
    private HatsUI hatsUI;

    public HatsCMD(Hats instance) {
        this.instance = instance;
        this.hatsUI = new HatsUI(instance);
    }


    @Subcommand("give")
    public void give(CommandSender sender, String player/*, Hats*/) {

    }

    @Subcommand("place")
    public void place(CommandSender sender/*,String player/*,Hats*/) {

    }

    @Subcommand("gui")
    public void gui(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix+command_no_player);
        }
        Player jugador = (Player) sender;
        jugador.openInventory(hatsUI.getInventory());
    }

    @Subcommand("reload")
    public void reload(CommandSender sender) {
        var game = instance.getGame();
        game.loadConfig();
        hatsUI.createInventory();
        sender.sendMessage(prefix + reload_message);
        sender.sendMessage(prefix + reload_items+gold(" "+hatsLoaded));
    }

}

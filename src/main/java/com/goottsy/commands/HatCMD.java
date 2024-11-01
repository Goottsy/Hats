package com.goottsy.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import com.goottsy.Hats;
import com.goottsy.hats.HatsUI;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

@CommandAlias("hat")
public class HatCMD extends BaseCommand {
    private FileConfiguration config;
    private Hats instance;
    private HatsUI hatsUI;

    public HatCMD(Hats instance) {
        this.instance = instance;
        this.hatsUI = new HatsUI(instance);
    }


    @Default
    public void hat(CommandSender sender) {

    }
}


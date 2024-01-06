package com.goottsy;

import lombok.Data;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

@Data
public class Game {
    PluginTemplate instance;
    private FileConfiguration config;

    //Class class;

    public Game(PluginTemplate instance) {
        this.instance = instance;
        this.config = instance.getConfig();

        //varconfig = config.getBoolean("config");
        //this.class = new Class(instance);


    }

    public boolean isStaff(Player player) {
        return player.getScoreboardTags().contains("staff");
    }

    public boolean isPlayer(Player player) {
        return player.getScoreboardTags().contains("player");
    }


}

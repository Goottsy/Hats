package com.goottsy;

import lombok.Data;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.goottsy.Utils.Tools.legacyParse;

@Data
public class Game {
    private Hats instance;
    private FileConfiguration config;


    public static String prefix;
    public static String GUITitle;
    public static String reload_message;
    public static String command_no_player;
    public static String reload_items;
    public static String equip;


    public Game(Hats instance) {
        this.instance = instance;
        this.config = instance.getConfig();
        loadConfig();
    }

    public void loadConfig() {
        instance.reloadConfig();
        config = instance.getConfig();

        String msg = "messages.";
        prefix = legacyParse(config.getString(msg+"prefix"));
        GUITitle = legacyParse(config.getString(msg+"gui_title"));
        reload_message = legacyParse(config.getString(msg+"reload"));
        command_no_player = legacyParse(config.getString(msg+"command_no_player"));
        reload_items = legacyParse(config.getString(msg+"reload_items"));
        equip =legacyParse(config.getString(msg+"equip"));
    }




}

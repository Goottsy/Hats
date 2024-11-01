package com.goottsy;

import co.aikar.commands.PaperCommandManager;
import com.goottsy.Utils.Types;
import com.goottsy.commands.HatsCMD;
import com.goottsy.hats.HatsListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static com.goottsy.Utils.Tools.*;

public final class Hats extends JavaPlugin {

    private static Hats instance;
    private FileConfiguration config;
    public static PaperCommandManager commandManager;
    private Game game;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config = getConfig();
        commandManager = new PaperCommandManager(this);
        game = new Game(this);
        new Types(this);

        commandManager.registerCommand(new HatsCMD(this));
        registerListener(new HatsListener(this));

        getLogger().info( green(instance.getName() + " ha sido Activado 1.0"));
    }

    @Override
    public void onDisable() {
        getLogger().info(red(instance.getName() + " ha sido Desactivado"));
    }

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, instance);
    }

    public Game getGame() {
        return this.game;
    }
}

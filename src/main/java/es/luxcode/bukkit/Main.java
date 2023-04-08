package es.luxcode.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

import es.luxcode.bukkit.commands.*;
import es.luxcode.bukkit.listeners.PlayerJoinListener;
import es.luxcode.bukkit.tasks.Task;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable () {
        // Save default config
        this.saveDefaultConfig();

        // Set static instance
        Main.instance = this;

        // Register the example command
        this.getCommand("example").setExecutor(new ExampleCommand());
        
        // Register the example listener
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Register the example task
        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new Task(), taskRepeatEvery, taskRepeatEvery);
    }

    private static Main instance;

    public static Main getInstance () {
        return Main.instance;
    }
}
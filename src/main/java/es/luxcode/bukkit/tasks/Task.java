package es.luxcode.bukkit.tasks;

import org.bukkit.Bukkit;

import es.luxcode.bukkit.Main;

public class Task implements Runnable {
    @Override
    public void run() {
        final String message = Main.getInstance().getConfig().getString("message.task");
        Bukkit.getServer().broadcastMessage(message);
    }
}
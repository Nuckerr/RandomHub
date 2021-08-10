package wtf.nucker.randomhub.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import wtf.nucker.randomhub.bungee.commands.HubCommand;
import wtf.nucker.randomhub.bungee.commands.SettingsCommand;
import wtf.nucker.randomhub.bungee.listeners.JoinListener;
import wtf.nucker.randomhub.bungee.listeners.KickListener;
import wtf.nucker.randomhub.bungee.utils.Config;

import java.io.IOException;

public final class RandomHub extends Plugin {

    private static RandomHub instance;

    private Config config;
    private Config dataConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info(ChatColor.BLUE + "RandomHub by " + this.getDescription().getAuthor() + " is loading up v" + this.getDescription().getVersion());
        instance = this;

        config = new Config("config.yml");
        dataConfig = new Config("data.yml");

        getProxy().getPluginManager().registerListener(this, new JoinListener());
        getProxy().getPluginManager().registerListener(this, new KickListener());
        getProxy().getPluginManager().registerCommand(this, new HubCommand());
        getProxy().getPluginManager().registerCommand(this, new SettingsCommand());

        this.getLogger().info(ChatColor.GREEN + "RandomHub has loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info(ChatColor.DARK_AQUA + "RandomHub is shutting down");
    }

    public static RandomHub getInstance() {
        return instance;
    }

    public Configuration getConfig() {
        return config.getConfig();
    }

    public Configuration getDataConfig() {
        return dataConfig.getConfig();
    }

    public void saveConfigs() {
        try {
            config.save();
            config.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

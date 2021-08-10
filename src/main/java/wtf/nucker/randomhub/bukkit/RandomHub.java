package wtf.nucker.randomhub.bukkit;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.nucker.randomhub.bukkit.command.HubCommand;
import wtf.nucker.randomhub.bukkit.command.SettingsCommand;
import wtf.nucker.randomhub.bukkit.listeners.JoinListener;
import wtf.nucker.randomhub.bukkit.listeners.KickListener;
import wtf.nucker.randomhub.bukkit.utils.Config;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class RandomHub extends JavaPlugin {

    private Config dataConfig;

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Bungeecord");
        saveDefaultConfig();
        getCommand("hub").setExecutor(new HubCommand());
        getCommand("alwayshubone").setExecutor(new SettingsCommand());
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new KickListener(), this);

        System.out.println("RandomHub has loaded");
    }

    public Config getDataConfig() {
        return dataConfig;
    }

    public YamlConfiguration getDataYaml() {
        return this.getDataConfig().getConfig();
    }
}

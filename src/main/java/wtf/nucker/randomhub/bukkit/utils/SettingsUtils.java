package wtf.nucker.randomhub.bukkit.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.nucker.randomhub.bukkit.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class SettingsUtils {

    private final Player player;
    private final RandomHub plugin = JavaPlugin.getPlugin(RandomHub.class);

    public SettingsUtils(Player player) {
        this.player = player;
    }

    public boolean isAlwaysHubOne() {
        return plugin.getDataYaml().getBoolean("alo." + player.getUniqueId());
    }

    public void setAlwaysHubOne(boolean status) {
        plugin.getDataYaml().set("alo." + player.getUniqueId(), status);
        plugin.getDataConfig().save();
    }
}

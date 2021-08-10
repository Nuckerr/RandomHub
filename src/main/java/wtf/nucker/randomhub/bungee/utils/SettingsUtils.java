package wtf.nucker.randomhub.bungee.utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import wtf.nucker.randomhub.bungee.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class SettingsUtils {

    private final ProxiedPlayer player;

    public SettingsUtils(ProxiedPlayer player) {
        this.player = player;
    }

    public boolean isAlwaysHubOne() {
        return RandomHub.getInstance().getDataConfig().getBoolean("alo."+player.getUniqueId().toString());
    }

    public void setAlwaysHubOne(boolean status) {
        RandomHub.getInstance().getDataConfig().set("alo."+player.getUniqueId(), status);
        RandomHub.getInstance().saveConfigs();
    }

    public ProxiedPlayer getPlayer() {
        return player;
    }
}

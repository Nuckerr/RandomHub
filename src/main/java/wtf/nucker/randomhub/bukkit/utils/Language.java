package wtf.nucker.randomhub.bukkit.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.nucker.randomhub.bukkit.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public enum Language {

    SERVER_SENT("messages.hub-sent", "&aYou have been sent to %server_name%"),
    UNABLE_SEND("messages.unable-to-send", "&cUnable to send you to any hub"),
    PERMISSION_MESSAGE("messages.no-permission", "&cYou dont have permission to do this"),
    ALO_UPDATED("messages.alo-updated", "&aAlways-lobby-one has been set to %status%");

    private final String path;
    private final String def;

    private final RandomHub plugin = JavaPlugin.getPlugin(RandomHub.class);

    Language(String path, String def) {
        this.path = path;
        this.def = def;
    }

    public String get() {
        String message = plugin.getConfig().getString(this.path);
        message = message == null ? def : message;
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String get(Player player) {
        return this.get()
                .replace("%player%", player.getName());
    }

    public String getDef() {
        return def;
    }

    public String getPath() {
        return path;
    }
}

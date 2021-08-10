package wtf.nucker.randomhub.bungee.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import wtf.nucker.randomhub.bungee.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public enum Language {

    SERVER_SENT("messages.hub-sent", "&aYou have been sent to %server_name%"),
    UNABLE_SEND("messages.unable-to-send", "&cUnable to send you to any hub"),
    PERMISSION_MESSAGE("messages.no-permission", "&cYou dont have permission to do this"),
    ALO_UPDATED("messages.alo-updated", "&aAlways-lobby-one has been set to %status%");

    private final String path;
    private final String def;
    private final BaseComponent comp;

    Language(String path, String def) {
        this.path = path;
        this.def = def;
        this.comp = new ComponentBuilder(Language.format(RandomHub.getInstance().getConfig().getString(path, def))).create()[0];
    }

    public BaseComponent get() {
        return this.comp;
    }

    public BaseComponent get(ProxiedPlayer player) {
        return new ComponentBuilder(Language.format(RandomHub.getInstance().getConfig().getString(path, def)).replace("%player%", player.getName())).create()[0];
    }

    public String getAsString(ProxiedPlayer player) {
        return Language.format(comp.toPlainText()).replace("%player%", player.getName());
    }


    private static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}

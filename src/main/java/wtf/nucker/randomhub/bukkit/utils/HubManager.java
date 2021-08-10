package wtf.nucker.randomhub.bukkit.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.nucker.randomhub.bukkit.RandomHub;

import java.util.List;
import java.util.Random;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class HubManager {

    private static final RandomHub plugin = JavaPlugin.getPlugin(RandomHub.class);

    public static void connect(Player player) {
        List<String> hubs = plugin.getConfig().getStringList("hubs");
        String server;
        SettingsUtils utils = new SettingsUtils(player);
        if(utils.isAlwaysHubOne()) {
            server = hubs.get(0);
            BungeeMessenger.sendServer(player, server);
            player.sendMessage(Language.SERVER_SENT.get(player).replace("%server_name%", server));
            return;
        }

        int randomIndex = new Random().nextInt(hubs.size());
        server = hubs.get(randomIndex);

        BungeeMessenger.sendServer(player, server);
        player.sendMessage(Language.SERVER_SENT.get(player).replace("%server_name%", server));
    }
}

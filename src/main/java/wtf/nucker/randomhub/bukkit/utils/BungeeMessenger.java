package wtf.nucker.randomhub.bukkit.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.nucker.randomhub.bukkit.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class BungeeMessenger {

    public static void sendServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(JavaPlugin.getPlugin(RandomHub.class), "BungeeCord", out.toByteArray());
    }
}

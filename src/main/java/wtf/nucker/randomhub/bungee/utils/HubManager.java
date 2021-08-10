package wtf.nucker.randomhub.bungee.utils;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import wtf.nucker.randomhub.bungee.RandomHub;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class HubManager {
    
    public static void connect(ProxiedPlayer player) {
        List<String> hubs = RandomHub.getInstance().getConfig().getStringList("hubs");
        ServerInfo server;
        SettingsUtils utils = new SettingsUtils(player);
        if(utils.isAlwaysHubOne()) {
            server = ProxyServer.getInstance().getServerInfo(hubs.get(0));

            player.connect(server);
            player.sendMessage(new ComponentBuilder(Language.SERVER_SENT.getAsString(player).replace("%server_name%", server.getName())).create());
            return;
        }

        int randomIndex = new Random().nextInt(hubs.size());
        server = ProxyServer.getInstance().getServerInfo(hubs.get(randomIndex));

        if(!server.canAccess(player)) {
            AtomicBoolean found = new AtomicBoolean(false);
            hubs.forEach(hubName -> {
                ServerInfo srv = ProxyServer.getInstance().getServerInfo(hubName);
                if(!found.get()) {
                    if (srv.canAccess(player)) {
                        player.connect(srv);
                        player.sendMessage(new ComponentBuilder(Language.SERVER_SENT.getAsString(player).replace("%server_name%", srv.getName())).create());
                        found.set(true);
                    }
                }
            });

            if(!found.get()) {
                player.sendMessage(new ComponentBuilder(Language.UNABLE_SEND.getAsString(player)).create());
            }
        } else {
            player.connect(server);
            player.sendMessage(new ComponentBuilder(Language.SERVER_SENT.getAsString(player).replace("%server_name%", server.getName())).create());
        }
    }
}

package wtf.nucker.randomhub.listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import wtf.nucker.randomhub.RandomHub;
import wtf.nucker.randomhub.utils.HubManager;
import wtf.nucker.randomhub.utils.SettingsUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Nucker
 * @project RandomHub
 * @date 28/07/2021
 */
public class KickListener implements Listener {

    private final RandomHub plugin = RandomHub.getInstance();

    @EventHandler
    public void onServerKickEvent(ServerKickEvent e) {
        ProxiedPlayer player = e.getPlayer();
        if(e.getKickedFrom() == null) return;
        if(!e.getKickReason().equalsIgnoreCase("Server Closed")) return;

        HubManager.connect(e.getPlayer());

        e.setCancelled(true);
        List<String> hubs = RandomHub.getInstance().getConfig().getStringList("hubs");
        ServerInfo server;
        SettingsUtils utils = new SettingsUtils(player);
        if(utils.isAlwaysHubOne()) {
            server = ProxyServer.getInstance().getServerInfo(hubs.get(0));
            e.setCancelServer(server);
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
                        e.setCancelServer(srv);
                        found.set(true);
                    }
                }
            });
            if(!found.get()) e.setCancelled(false);
        } else {
            e.setCancelServer(server);
        }
    }
}

package wtf.nucker.randomhub.bungee.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import wtf.nucker.randomhub.bungee.RandomHub;
import wtf.nucker.randomhub.bungee.utils.HubManager;

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
    }
}

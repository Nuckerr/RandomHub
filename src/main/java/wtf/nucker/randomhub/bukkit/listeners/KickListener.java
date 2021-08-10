package wtf.nucker.randomhub.bukkit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import wtf.nucker.randomhub.bukkit.utils.HubManager;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class KickListener implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player player = e.getPlayer();
        if(!e.getReason().equalsIgnoreCase("Server Closed")) return;
        HubManager.connect(e.getPlayer());

        e.setCancelled(true);
    }
}

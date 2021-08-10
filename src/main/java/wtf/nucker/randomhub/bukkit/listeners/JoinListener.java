package wtf.nucker.randomhub.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import wtf.nucker.randomhub.bukkit.utils.HubManager;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerLoginEvent e) {
        HubManager.connect(e.getPlayer());
    }
}

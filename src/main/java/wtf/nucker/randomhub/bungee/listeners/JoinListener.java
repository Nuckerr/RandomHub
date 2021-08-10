package wtf.nucker.randomhub.bungee.listeners;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import wtf.nucker.randomhub.bungee.utils.HubManager;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PostLoginEvent e) {
        HubManager.connect(e.getPlayer());
    }
}

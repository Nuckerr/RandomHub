package wtf.nucker.randomhub.bukkit.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import wtf.nucker.randomhub.bukkit.utils.HubManager;
import wtf.nucker.randomhub.bungee.RandomHub;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class KickListener implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player player = e.getPlayer();
        if(!RandomHub.getInstance().getConfig().getStringList("kick-messages").contains(ChatColor.stripColor(e.getReason()))) return;
        e.setCancelled(true);
        HubManager.connect(e.getPlayer());
    }
}

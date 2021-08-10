package wtf.nucker.randomhub.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wtf.nucker.randomhub.bukkit.utils.HubManager;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class HubCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be in-game to run this command");
            return true;
        }

        HubManager.connect((Player) sender);
        return true;
    }
}

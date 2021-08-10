package wtf.nucker.randomhub.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wtf.nucker.randomhub.bukkit.utils.Language;
import wtf.nucker.randomhub.bukkit.utils.SettingsUtils;

/**
 * @author Nucker
 * @project RandomHub
 * @date 10/08/2021
 */
public class SettingsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be in-game to run this command");
            return true;
        }

        if(!(sender.hasPermission("randomhub.alwayshubone"))) {
            sender.sendMessage(Language.PERMISSION_MESSAGE.get((Player) sender));
            return true;
        }

        SettingsUtils utils = new SettingsUtils((Player) sender);
        utils.setAlwaysHubOne(!(utils.isAlwaysHubOne()));
        sender.sendMessage(Language.ALO_UPDATED.get((Player) sender));

        return true;
    }
}

package wtf.nucker.randomhub.bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import wtf.nucker.randomhub.bungee.utils.HubManager;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class HubCommand extends Command {

    public HubCommand() {
        super("hub", "", "lobby", "l");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new ComponentBuilder("You must be in-game to run this command").color(ChatColor.RED).create());
            return;
        }

        HubManager.connect((ProxiedPlayer) sender);
    }
}

package wtf.nucker.randomhub.bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import wtf.nucker.randomhub.bungee.utils.Language;
import wtf.nucker.randomhub.bungee.utils.SettingsUtils;

/**
 * @author Nucker
 * @project RandomHub
 * @date 23/07/2021
 */
public class SettingsCommand extends Command {

    public SettingsCommand() {
        super("alwayshubone", "randomhub.alwayshubone", "aho", "alwayslobbyone", "alo");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new ComponentBuilder("You must be in-game to run this command").color(ChatColor.RED).create());
            return;
        }

        if(!(sender.hasPermission("randomhub.awlayshubone"))) {
            sender.sendMessage(Language.PERMISSION_MESSAGE.get((ProxiedPlayer) sender));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        SettingsUtils utils = new SettingsUtils(player);
        boolean status = !(utils.isAlwaysHubOne());

        utils.setAlwaysHubOne(status);
        player.sendMessage(new ComponentBuilder(Language.ALO_UPDATED.getAsString((ProxiedPlayer) sender).replace("%status%", String.valueOf(status))).create());
    }
}

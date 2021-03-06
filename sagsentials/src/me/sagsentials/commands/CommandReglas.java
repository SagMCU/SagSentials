package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandReglas implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandReglas(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("reglas").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (sender.hasPermission("SagSentials.rules")) {
            for (final String reglas : this.plugin.getConfig().getStringList("reglas")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', reglas));
            }
            return true;
        }
        return true;
    }
}
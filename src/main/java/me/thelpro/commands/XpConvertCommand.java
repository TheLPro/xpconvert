package me.thelpro.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class XpConvertCommand implements CommandExecutor {

    String mp = "&e[&a&lXpConvert&r&e] &r";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        int bottlesFound = 0;
        if (player.hasPermission("xpconvert.convert")) {
            for (ItemStack item : player.getInventory().getContents()) {

                if (item == null) {
                    continue;
                }
                if (item.getType().equals(Material.EXPERIENCE_BOTTLE)) {
                    bottlesFound = bottlesFound + item.getAmount();
                    item.setAmount(0);
                    continue;
                } else {
                    continue;
                }
            }

            if (bottlesFound == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', mp + "&4There were no bottles to convert!"));
            } else {
                int calculatedExp = bottlesFound * 16;
                player.giveExp(calculatedExp);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', mp + "You have recieved " + calculatedExp + " EXP!"));
                return true;
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', mp + "&4You do not have permission to preform this command."));
            return true;
        }

        return true;
    }
}
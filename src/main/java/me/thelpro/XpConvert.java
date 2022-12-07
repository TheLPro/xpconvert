package me.thelpro;

import me.thelpro.commands.XpConvertCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class XpConvert extends JavaPlugin {

    static XpConvert plugin;

    @Override
    public void onEnable() {

        plugin = this;
        getCommand("convertxp").setExecutor(new XpConvertCommand());

    }

    public static XpConvert getPlugin() {return plugin;}

}

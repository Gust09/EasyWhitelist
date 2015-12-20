package net.plussycraft.easywhitelist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gust09 on 19/12/2015.
 */
public class Main extends JavaPlugin{

    private static Main plugin;
    public static List<String> WL = new ArrayList<>();
    public static boolean ACTIVE = false;

    public void onEnable(){

        plugin = this;
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        getCommand("wl").setExecutor(new Commands());

        getConfig().options().copyDefaults(true);
        saveConfig();

        Config.loadFromFile();

    }

    public static Main get(){
        return plugin;
    }

}

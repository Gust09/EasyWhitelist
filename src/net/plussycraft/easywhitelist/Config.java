package net.plussycraft.easywhitelist;

import java.util.List;

/**
 * Created by Gust09 on 19/12/2015.
 */
public class Config {

    private static Main pl = Main.get();

    public static void loadFromFile(){
        Main.WL.clear();
        pl.reloadConfig();
        List<String> list = pl.getConfig().getStringList("whitelist");
        System.out.println("Carregando Whitelist...");
        for(String line : list){
            Main.WL.add(line);
            System.out.println("Adicionado: " + line);
        }
    }

    public static void saveToFile(){
        pl.getConfig().set("whitelist", Main.WL);
        pl.saveConfig();
    }

    public static String getKickMsg(){
        return pl.getConfig().getString("options.kickmsg");
    }

    public static String getWLOffMsg(){
        return pl.getConfig().getString("options.wloffmsg");
    }
}

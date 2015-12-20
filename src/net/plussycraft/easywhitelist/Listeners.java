package net.plussycraft.easywhitelist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Gust09 on 19/12/2015.
 */
public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerLoginEvent e){

        Player p = e.getPlayer();

        if(!Main.ACTIVE){
            if(!p.hasPermission("easywhitelist.bypass")){
                e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatUtils.colorize(Config.getWLOffMsg()));
            }
            return;
        }

        if(!Main.WL.contains(p.getName())){
            if(p.hasPermission("easywhitelist.bypass"))
                return;
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatUtils.colorize(Config.getKickMsg()));
        }

    }

}

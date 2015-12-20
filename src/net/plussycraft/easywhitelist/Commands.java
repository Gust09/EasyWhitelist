package net.plussycraft.easywhitelist;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Gust09 on 19/12/2015.
 */
public class Commands implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if(args.length == 0){
            ChatUtils.msg(s, "&3PlussyCraft Easy Whitelist System");
            return false;
        }

        if(args[0].equalsIgnoreCase("list")){
            ChatUtils.msg(s, "&3Whitelist:");
            for(String line : Main.WL){
                ChatUtils.msg(s, "&f- &e" + line);
            }
        }

        else if(args[0].equalsIgnoreCase("add")){
            if(args.length != 2){
                ChatUtils.msg(s, "&cUso: /wl add <nome>");
                return false;
            }
            if(Main.WL.contains(args[1])){
                ChatUtils.msg(s, "&cJá está whitelisted");
                return false;
            }

            Main.WL.add(args[1]);
            ChatUtils.msg(s, "&aAdicionado " + args[1] + " à whitelist");
        }

        else if(args[0].equalsIgnoreCase("remove")){
            if(args.length != 2){
                ChatUtils.msg(s, "&cUso: /wl remove <nome>");
                return false;
            }
            if(!Main.WL.contains(args[1])){
                ChatUtils.msg(s, "&cNão está na whitelisted");
                return false;
            }

            Main.WL.remove(args[1]);
            ChatUtils.msg(s, "&aRemovido " + args[1] + " da whitelist");
        }

        else if(args[0].equalsIgnoreCase("load")){
            Config.loadFromFile();
            ChatUtils.msg(s, "&aWhitelist Recarregada");
        }

        else if(args[0].equalsIgnoreCase("save")){
            Config.saveToFile();
            ChatUtils.msg(s, "&aWhitelist Salva");
        }

        else if(args[0].equalsIgnoreCase("on")){
            if(!Main.ACTIVE){
                Main.ACTIVE = true;
                ChatUtils.msg(s, "&aO servidor vai agora aceitar quem está na whitelist");
            }
            else{
                ChatUtils.msg(s, "&cO servidor já está a aceitar jogadores da whitelist");
            }
        }

        else if(args[0].equalsIgnoreCase("off")){
            if(Main.ACTIVE){
                Main.ACTIVE = false;
                ChatUtils.msg(s, "&aO servidor vai agora aceitar apenas Staffs");
            }
            else{
                ChatUtils.msg(s, "&cO servidor já está a aceitar apenas Staffs");
            }
        }

        return false;
    }

}

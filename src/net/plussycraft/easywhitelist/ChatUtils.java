package net.plussycraft.easywhitelist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtils {

    /**
     * Envia uma mensagem para o CommandSender
     * @param p CommandSender a enviar
     * @param msg Mensagem a enviar
     */
    public static void msg(CommandSender p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    /**
     * Envia uma mensagem para o Player
     * @param p Player a enviar
     * @param msg Mensagem a enviar
     */
    public static void msg(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    /**
     * Envia um Broadcast para o servidor inteiro
     * @param msg Mensagem a enviar suporta cores
     */
    public static void broadcast(String msg){
        Bukkit.broadcastMessage(colorize(msg));
    }

    /**
     * Dá cor a uma String atravéz dos codigos de cores (&5, &l)
     * @param msg Mensagem a Colorir
     * @return Mensagem Colorida
     */
    public static String colorize(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        return msg;
    }

    /**
     * Tenta centrar a string para o chat. Funciona mal como a merda.
     * @param string String a Centrar
     * @return String Centrada (NOPE)
     */
    public static String centerString(String string) {

        String centeredString = "";

        int spaces = (75 - string.length()) / 2;

        for (int i = 0; i < spaces; i++) {
            centeredString = centeredString + " ";
        }

        centeredString = centeredString + string;

        return centeredString;
    }

    /**
     * Constroi uma String apartir de um Array de Strings
     * @param args Array de Strings
     * @param ignore Numero de argumentos a ignorar até começar a construir
     * @return String construida
     */
    public static String buildString(String[] args, int ignore) {

        String msg = "";

        for (int i = ignore; i < args.length; i++) {
            if (i != (args.length - 1)) {
                msg = msg + args[i] + " ";
            } else
                msg = msg + args[i];
        }

        return msg;
    }

}

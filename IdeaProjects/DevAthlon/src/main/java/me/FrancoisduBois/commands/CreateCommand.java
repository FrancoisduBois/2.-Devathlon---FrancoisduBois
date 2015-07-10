package me.FrancoisduBois.commands;

import me.FrancoisduBois.utils.Creator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 10.07.2015.
 */
public class CreateCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                //  /point
                p.sendMessage("§cSyntax: /create world LobbyWorld");
            }else if(args.length == 2) {
                if (args[0].equalsIgnoreCase("world")) {
                    String worldName = args[1];
                    if(worldName.equals("LobbyWorld")){
                        Creator.loadMap("LobbyWorld");
                    }
                }
            }
        }else{
            sender.sendMessage("Nur für Spieler!");
        }

        return true;
    }

}

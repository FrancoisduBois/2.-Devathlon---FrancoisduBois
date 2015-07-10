package me.FrancoisduBois.commands;

import me.FrancoisduBois.utils.LocationHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 10.07.2015.
 */
public class PointCommand implements CommandExecutor {

//File: Spawns

    /*
    Spawn.LobbySpawn
    Spawn.GameSpawn.[name]
     */

    int i = 1;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                //  /point
                p.sendMessage("§cSyntax: /point setlobbyspawn");
                p.sendMessage("§cSyntax: /point addgamespawn");
            }else if(args.length == 1){
                //  /point setlobbyspawn
                if(args[0].equalsIgnoreCase("setlobbyspawn")){
                    LocationHelper.setLocation("Spawns", "Spawn.LobbySpawn", p.getLocation(), true);
                    p.sendMessage("§aDu hast den §6LobbySpawn-Punkt§a gesetzt!");

                }else
                if(args[0].equalsIgnoreCase("setstevespawn")){
                    LocationHelper.setLocation("Spawns", "Spawn.SteveSpawn", p.getLocation(), true);
                    p.sendMessage("§aDu hast den §6Spawn von Steve §agesetzt");
                }else

                if (args[0].equalsIgnoreCase("addgamespawn")) {
                    LocationHelper.setLocation("Spawns", "Spawn.SpawnPoint"+i, p.getLocation(), true);
                    p.sendMessage("§aDu hast Spawnpunkt §6"+i+"§a gesetzt");
                    i++;
            }
        }
        }else{
            sender.sendMessage("Nur für Spieler!");
        }

        return true;
    }


}

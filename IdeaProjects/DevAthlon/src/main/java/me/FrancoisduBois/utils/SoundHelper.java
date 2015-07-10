package me.FrancoisduBois.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Miklas on 10.07.2015.
 */
public class SoundHelper {

    public static void soundAll(Sound s){
        for(Player all : Bukkit.getOnlinePlayers()){
            all.playSound(all.getLocation(), s, 100F, 100F);
        }
    }

    public static void soundList(List<Player> list, Sound s){
        for(Player p : list){
            p.playSound(p.getLocation(), s, 100F, 100F);
        }
    }

    public static void soundLocation(Location loc, Sound s){
        loc.getWorld().playSound(loc, s, 100F, 100F);
    }

    public static void soundPlayer(Player p, Sound s){
        p.playSound(p.getLocation(), s, 100F, 100F);
    }

}

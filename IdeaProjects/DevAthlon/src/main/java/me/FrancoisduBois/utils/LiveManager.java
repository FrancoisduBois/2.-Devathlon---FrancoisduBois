package me.FrancoisduBois.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Miklas on 10.07.2015.
 */
public class LiveManager {

    public static Map<Player, Integer> lives = new HashMap<Player, Integer>();

    public static int getLives(Player p){
        return lives.get(p);
    }

    public static void setLives(Player p, int amount){
        lives.remove(p);
        lives.put(p, amount);
    }

    public static void removeOneLive(Player p){
        int i = lives.get(p);
        lives.remove(p);
        lives.put(p, i-1);
    }

}

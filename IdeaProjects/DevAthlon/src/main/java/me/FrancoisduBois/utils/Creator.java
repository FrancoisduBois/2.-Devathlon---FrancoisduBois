package me.FrancoisduBois.utils;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

/**
 * Created by Miklas on 10.07.2015.
 */
public class Creator {

    public static void unloadMap(String world) {
        Bukkit.getServer().unloadWorld(world, false);
    }
    public static void loadMap(String world) {
        Bukkit.getServer().createWorld(new WorldCreator(world));
    }
    public static void resetMap(String mapName) {
        unloadMap(mapName);
        loadMap(mapName);
    }

}

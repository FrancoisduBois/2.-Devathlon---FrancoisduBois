package me.FrancoisduBois.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Miklas on 10.07.2015.
 */

/**
 * Created by Miklas on 31.03.2015.
 */
public class LocationHelper {

    public static void setLocation(String filename, String path, Location loc, boolean direction){
        File file = new File("plugins/Steve's Box", filename+".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set(path + ".world", loc.getWorld().getName());
        cfg.set(path + ".x", Double.valueOf(loc.getX()));
        cfg.set(path + ".y", Double.valueOf(loc.getY()));
        cfg.set(path + ".z", Double.valueOf(loc.getZ()));
        if (direction) {
            cfg.set(path + ".yaw", Float.valueOf(loc.getYaw()));
            cfg.set(path + ".pitch", Float.valueOf(loc.getPitch()));
        }
        try
        {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location getLocation(String filename, String path, boolean direction) {
        Location loc;

        File file = new File("plugins/MinecraftFussball", filename+".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (cfg.contains(path)) {
            String w = cfg.getString(path + ".world");
            double x = cfg.getDouble(path + ".x");
            double y = cfg.getDouble(path + ".y");
            double z = cfg.getDouble(path + ".z");
            double yaw = 0.0D;
            double pitch = 0.0D;
            if (cfg.contains(path + ".yaw")) {
                yaw = cfg.getDouble(path + ".yaw");
                pitch = cfg.getDouble(path + ".pitch");
            }

            loc = new Location(Bukkit.getWorld(w), x, y, z);
            if (direction) {
                loc.setYaw((float)yaw);
                loc.setPitch((float)pitch);
            }
        } else {
            return null;
        }
        return loc;
    }

    public static Map<Player, Location> locationMap = new HashMap<Player, Location>();

    public static void spawnPlayers(List<Player> list, String filename, String path){
        List<String> locs = new ArrayList<String>();

        File file = new File("plugins/MinecraftCart", filename+".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        ConfigurationSection section = cfg.getConfigurationSection("path");

        for (String s : section.getKeys(false)){
            locs.add(s);
        }

        int i = 0;

        for(Player p : list){
            Collections.shuffle(locs);
            p.teleport(getLocation(filename, locs.get(i), true));
            locationMap.put(p, p.getLocation());
            i++;
        }
    }

}


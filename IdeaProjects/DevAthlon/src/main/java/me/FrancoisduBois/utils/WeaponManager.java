package me.FrancoisduBois.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Miklas on 10.07.2015.
 */
public class WeaponManager {

    static Map<Player, WeaponStatus> status = new HashMap<Player, WeaponStatus>();

    public static void equip(Player p, WeaponStatus w){
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(w.getHelmet()));
        p.getInventory().setBoots(new ItemStack(w.getBoots()));
        p.getInventory().setChestplate(new ItemStack(w.getChestplate()));
        p.getInventory().setLeggings(new ItemStack(w.getLeggins()));
        p.getInventory().setItem(0, new ItemStack(w.getSword()));

        p.setHealth(20.0D);
        p.setFoodLevel(20);
    }

    public static WeaponStatus getStatus(Player p){
        return status.get(p);
    }


    public static WeaponStatus addStatus(Player p){

        WeaponStatus status= null;

        if(getStatus(p) == WeaponStatus.ONE){
            status = WeaponStatus.TWO;
        }else if(getStatus(p) == WeaponStatus.TWO){
            status = WeaponStatus.THREE;
        }else if(getStatus(p) == WeaponStatus.THREE){
            status = WeaponStatus.FOUR;
        }else if(getStatus(p) == WeaponStatus.FOUR){
            status = WeaponStatus.FIVE;
        }else if(getStatus(p) == WeaponStatus.FIVE){
            status = WeaponStatus.SIX;
        }else if(getStatus(p) == WeaponStatus.SIX){
            status = WeaponStatus.SEVEN;
        }else if(getStatus(p) == WeaponStatus.SEVEN){
            status = WeaponStatus.EIGHT;
        }else if(getStatus(p) == WeaponStatus.EIGHT){
            status = WeaponStatus.NINE;
        }else if(getStatus(p) == WeaponStatus.NINE){
            status = WeaponStatus.TEN;
        }else if(getStatus(p) == WeaponStatus.TEN){
            return null;
        }

        try {
            return status;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

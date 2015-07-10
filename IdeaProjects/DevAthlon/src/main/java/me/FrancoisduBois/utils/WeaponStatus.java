package me.FrancoisduBois.utils;

import org.bukkit.Material;

/**
 * Created by Miklas on 10.07.2015.
 */
public enum WeaponStatus {

    ONE(Material.WOOD_AXE, Material.LEATHER_HELMET, Material.AIR, Material.AIR, Material.AIR, 1),
    TWO(Material.WOOD_AXE, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.AIR, Material.LEATHER_BOOTS, 2),
    THREE(Material.GOLD_SWORD, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, 3),
    FOUR(Material.GOLD_SWORD, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, 4),
    FIVE(Material.WOOD_SWORD, Material.GOLD_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, 5),
    SIX(Material.WOOD_SWORD, Material.GOLD_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, 6),
    SEVEN(Material.STONE_SWORD, Material.CHAINMAIL_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS,7),
    EIGHT(Material.DIAMOND_PICKAXE, Material.CHAINMAIL_HELMET, Material.IRON_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.IRON_BOOTS, 8),
    NINE(Material.IRON_SWORD, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.CHAINMAIL_BOOTS, 9),
    TEN(Material.DIAMOND_SWORD, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, 10);

    Material sword;
    Material helmet;
    Material chestplate;
    Material leggins;
    Material boots;
    int factor;

    public int getFactor() {
        return factor;
    }

    private WeaponStatus(Material sword, Material helmet, Material chestplate, Material leggins, Material boots, int factor){
        this.sword = sword;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggins = leggins;
        this.boots = boots;
        this.factor = factor;

    }


    public Material getSword() {
        return sword;
    }

    public Material getHelmet() {
        return helmet;
    }

    public Material getChestplate() {
        return chestplate;
    }

    public Material getLeggins() {
        return leggins;
    }

    public Material getBoots() {
        return boots;
    }
}

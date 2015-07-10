package me.FrancoisduBois.utils;

import net.minecraft.server.v1_8_R2.EntityLiving;
import net.minecraft.server.v1_8_R2.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftCreature;
import org.bukkit.entity.Entity;

/**
 * Created by Miklas on 10.07.2015.
 */
public class Steve {

    Entity entity;

    public Steve(Entity entity){
        this.entity = entity;
    }

    public void setDisplayName(String display) {
        entity.setCustomName(display);
        entity.setCustomNameVisible(true);
    }

    public void setDisplayNameVisible(Boolean visible) {
        entity.setCustomNameVisible(visible);
    }

    public void remove() {
        entity.remove();
    }

    public void setLocation(Location location) {
        entity.teleport(location);
    }

    public void walkToLocation(Location location, float speed) {
        ((CraftCreature) entity)
                .getHandle()
                .getNavigation()
                .a(location.getX(), location.getY(), location.getZ(), speed);
    }


}

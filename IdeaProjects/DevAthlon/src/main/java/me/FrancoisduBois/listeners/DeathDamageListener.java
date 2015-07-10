package me.FrancoisduBois.listeners;

import me.FrancoisduBois.utils.LiveManager;
import me.FrancoisduBois.utils.WeaponManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Miklas on 10.07.2015.
 */
public class DeathDamageListener implements Listener{

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        e.setDeathMessage(p.getName()+" wurde getötet");

        LiveManager.removeOneLive(p);

        p.sendMessage("");

        if(p.getKiller() != null && p.getKiller() instanceof Player){
            Player killer = p.getKiller();
            WeaponManager.equip(killer, WeaponManager.addStatus(p));
            p.sendMessage("§aDu hast Level §6"+WeaponManager.getStatus(p).getFactor()+"§a erreicht");
        }
    }




}

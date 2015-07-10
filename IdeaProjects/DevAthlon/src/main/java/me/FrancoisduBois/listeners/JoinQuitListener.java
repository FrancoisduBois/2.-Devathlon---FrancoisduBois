package me.FrancoisduBois.listeners;

import me.FrancoisduBois.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Miklas on 10.07.2015.
 */
public class JoinQuitListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("§7"+e.getPlayer().getName()+"§6 ist dem Spiel beigetreten");
        Player p = e.getPlayer();
        p.setHealth(20);
        p.setExp(0);
        p.setFlying(false);
        p.setLevel(0);
        p.setFoodLevel(20);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("§7"+e.getPlayer().getName()+"§6 hat das Spiel verlassen");
    }

}

package me.FrancoisduBois.countdown;

import me.FrancoisduBois.Main;
import me.FrancoisduBois.utils.CountDown;
import me.FrancoisduBois.utils.GameState;
import me.FrancoisduBois.utils.ICountDown;
import me.FrancoisduBois.utils.SoundHelper;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 10.07.2015.
 */
public class End  extends CountDown implements ICountDown {

    public End(int[] times) {
        super(times);
        tasks.add(this);
    }

    @Override
    public void run() {
        setLenght(10);
        sound = true;
        level = true;
        super.run();
    }

    @Override
    public void task() {
        Bukkit.broadcastMessage("Das Spiel endet in " + getLenght() + " Sekunden");
        if(getLenght() == 0){
            Bukkit.getScheduler().cancelTask(task);
            cancel();
            tasks.remove(this);
            Bukkit.broadcastMessage(Main.getInstance().pr + "§4Das Spiel ist jetzt zu Ende!");
            SoundHelper.soundAll(Sound.NOTE_PIANO);
            System.out.println("END");
            Main.getInstance().gs = GameState.END;

            for(Player all : Bukkit.getOnlinePlayers()){
                //all.kickPlayer("§4Das Spiel ist zu Ende!");
            }

            //Bukkit.getServer().shutdown();
        }
    }

}



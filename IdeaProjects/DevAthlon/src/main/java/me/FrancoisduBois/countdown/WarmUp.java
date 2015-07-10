package me.FrancoisduBois.countdown;

import me.FrancoisduBois.Main;
import me.FrancoisduBois.utils.CountDown;
import me.FrancoisduBois.utils.GameState;
import me.FrancoisduBois.utils.ICountDown;
import me.FrancoisduBois.utils.SoundHelper;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

/**
 * Created by Miklas on 10.07.2015.
 */
public class WarmUp extends CountDown implements ICountDown {

    Game g;

    public WarmUp(int[] times) {
        super(times);
        tasks.add(this);
        g = new Game(new int[] {180, 120, 60, 0});
    }

    @Override
    public void run() {
        setLenght(30);
        sound = true;
        level = false;
        super.run();
    }

    @Override
    public void task() {
        setMsg(Main.getInstance().pr + "§3Das Spiel beginnt in §6" + getLenght() + " §3Sekunden" );
        if(getLenght() == 25){

        }else
        if(getLenght() == 0){
            Bukkit.getScheduler().cancelTask(task);
            cancel();
            tasks.remove(this);
            Bukkit.broadcastMessage(Main.getInstance().pr + "§3Das Spiel beginnt jetzt Geil");
            SoundHelper.soundAll(Sound.NOTE_PIANO);
            System.out.println("GAME");
            Main.getInstance().gs = GameState.GAME;
            g.run();
        }
    }

}

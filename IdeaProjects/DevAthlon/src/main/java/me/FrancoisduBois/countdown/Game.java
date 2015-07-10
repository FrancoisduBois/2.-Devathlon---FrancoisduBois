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
public class Game extends CountDown implements ICountDown{

    End e;

    public Game(int[] times) {
        super(times);
        tasks.add(this);
        e = new End(new int[] {10, 5, 4, 3, 2, 1, 0});
    }

    @Override
    public void run() {
        setLenght(180);
        sound = true;
        level = true;
        super.run();
    }

    @Override
    public void task() {
        setMsg("Das Spiel endet in "+getLenght()+" Sekunden");
        if(getLenght() == 0){
            Bukkit.getScheduler().cancelTask(task);
            cancel();
            tasks.remove(this);
            Bukkit.broadcastMessage(Main.getInstance().pr + "§4Das Spiel ist jetzt zu Ende!");
            SoundHelper.soundAll(Sound.NOTE_PIANO);
            System.out.println("END");
            Main.getInstance().gs = GameState.END;
            e.run();
        }
    }

}

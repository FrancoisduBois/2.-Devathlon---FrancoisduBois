package me.FrancoisduBois.countdown;

import me.FrancoisduBois.Main;
import me.FrancoisduBois.utils.CountDown;
import me.FrancoisduBois.utils.GameState;
import me.FrancoisduBois.utils.ICountDown;
import me.FrancoisduBois.utils.SoundHelper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by Miklas on 10.07.2015.
 */
public class Lobby extends CountDown implements ICountDown {

    WarmUp w;

    public Lobby(int[] times) {
        super(times);
        tasks.add(this);
        w = new WarmUp(new int[] {30, 20, 15, 10, 5,4,3,2,1,0 });

    }

    private boolean helper = true;

    @Override
    public void run() {
        setLenght(20);
        sound = true;
        level = true;
        max = true;
        super.run();
    }


    public void task() {
        setMsg(Main.getInstance().pr + "§3Die Runde beginnt in §6" + getLenght() + " §3Sekunden" );

        if(getLenght() == 0) {
            if(helper) {
                if (Bukkit.getOnlinePlayers().size() >= Main.getInstance().maxPlayers) {
                    Bukkit.getScheduler().cancelTask(task);
                    Bukkit.broadcastMessage(Main.getInstance().pr + "§3Die Runde beginnt jetzt");
                    tasks.remove(this);
                    SoundHelper.soundAll(Sound.NOTE_PIANO);
                    Main.getInstance().gs = GameState.WARM_UP;
                    System.out.println("SPAWN");
                    w.run();

                } else {

                    Bukkit.broadcastMessage(Main.getInstance().pr + "§cEs sind zu wenig Spieler online. Der CountDown wird neugestartet");

                    i = 0;
                    setLenght(21);
                }
            }else{
                helper = true;
                Bukkit.broadcastMessage(Main.getInstance().pr + "§cFehler. Der CountDown wird neugestartet");

                i = 0;
                setLenght(21);
            }
        }
    }

}

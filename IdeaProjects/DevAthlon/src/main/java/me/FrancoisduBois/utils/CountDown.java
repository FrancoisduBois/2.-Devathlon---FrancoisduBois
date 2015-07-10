package me.FrancoisduBois.utils;

import me.FrancoisduBois.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miklas on 10.07.2015.
 */
public class CountDown {

    int lenght;
    String msg;
    int[] times;

    public int i = 0;

    public static List<ICountDown> tasks = new ArrayList<ICountDown>();

    public CountDown(int[] times){
        setTimes(times);
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setTimes(int[] times) {
        this.times = times;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean sound = false;
    public boolean level = false;
    public boolean max = false;

    public int task;
    int v;

    public void run(){
        lenght = lenght +1;
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(getLenght() != 0){
                    lenght--;
                    tasks.get(v).task();
                    if(level) {
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.setLevel(lenght);
                        }
                    }
                }
                if(getLenght() == times[i] && getLenght() != 0){
                    Bukkit.broadcastMessage(getMsg());
                    if(sound){
                        SoundHelper.soundAll(Sound.NOTE_PIANO);
                    }
                    i++;
                }
                if(lenght == 0){
                    //
                }
            }
        }, 0L, 20L);
    }

    public void cancel(){
        Bukkit.getScheduler().cancelTask(task);
    }

}

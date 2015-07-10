package me.FrancoisduBois;

import me.FrancoisduBois.commands.CreateCommand;
import me.FrancoisduBois.commands.PointCommand;
import me.FrancoisduBois.countdown.Lobby;
import me.FrancoisduBois.listeners.JoinQuitListener;
import me.FrancoisduBois.utils.GameState;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miklas on 25.06.2015.
 */
public class Main extends JavaPlugin {

    private static Main main;

    public static GameState gs;

    int i = 1;

    @Override
    public void onEnable(){

      getLogger().info("[Devathlon 2.0] gestartet...");

      main = this;

      registerListeners(getServer().getPluginManager());

        gs = GameState.LOBBY;

        Lobby l = new Lobby(new int[]{20, 15, 10, 5,4,3,2,1,0});
        l.run();

        registerCommands();
    }

    @Override
    public void onDisable(){

        getLogger().info("[Devathlon 2.0] getoppt...");

    }


    public static Main getInstance(){
        return main;
    }

    public int maxPlayers = 0;

    private void registerListeners(PluginManager manager){
        manager.registerEvents(new JoinQuitListener(), this);
    }

    private void registerCommands(){
        getCommand("point").setExecutor(new PointCommand());
        getCommand("create").setExecutor(new CreateCommand());
    }

    public String pr = "[§aSteve's Box]";

}

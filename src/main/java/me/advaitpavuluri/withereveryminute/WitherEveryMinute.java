package me.advaitpavuluri.withereveryminute;

import me.advaitpavuluri.withereveryminute.commands.WEMStartCommand;
import me.advaitpavuluri.withereveryminute.commands.WEMStopCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WitherEveryMinute extends JavaPlugin {

    private GameState gameState;

    private static WitherEveryMinute instance;
    public static WitherEveryMinute getInstance() {
        return instance;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void onEnable() {
        instance = this;
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.setInvulnerable(false);
        }
        registerCommands();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerCommands() {
        getCommand("wemstart").setExecutor(new WEMStartCommand());
        getCommand("wemstop").setExecutor(new WEMStopCommand());
    }

}

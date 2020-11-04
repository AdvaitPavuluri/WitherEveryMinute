package me.advaitpavuluri.withereveryminute.commands;

import me.advaitpavuluri.withereveryminute.tasks.WitherSpawnTask;
import me.advaitpavuluri.withereveryminute.GameState;
import me.advaitpavuluri.withereveryminute.WitherEveryMinute;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WEMStartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (WitherEveryMinute.getInstance().getGameState() == GameState.RUNNING) {
            sender.sendMessage(ChatColor.RED + "This is already running!");
            return true;
        }

        WitherEveryMinute.getInstance().setGameState(GameState.RUNNING);
        sender.sendMessage(ChatColor.GREEN + "Starting up! A wither will spawn near a random player every minute from now on.");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(WitherEveryMinute.getInstance(), new WitherSpawnTask(),
                20L * 60, 20L * 60);

        return true;
    }
}

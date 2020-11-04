package me.advaitpavuluri.withereveryminute.commands;

import me.advaitpavuluri.withereveryminute.GameState;
import me.advaitpavuluri.withereveryminute.WitherEveryMinute;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WEMStopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        WitherEveryMinute.getInstance().setGameState(GameState.NOT_RUNNING);
        sender.sendMessage(ChatColor.GREEN + "Stopped the wither from spawning every minute!");
        return true;

    }
}

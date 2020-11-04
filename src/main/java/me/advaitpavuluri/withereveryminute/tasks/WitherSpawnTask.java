package me.advaitpavuluri.withereveryminute.tasks;

import me.advaitpavuluri.withereveryminute.GameState;
import me.advaitpavuluri.withereveryminute.WitherEveryMinute;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WitherSpawnTask implements Runnable {

    @Override
    public void run() {

        List<Player> players = new ArrayList<>();

        if (WitherEveryMinute.getInstance().getGameState() == GameState.NOT_RUNNING) {
            return;
        }

        if (WitherEveryMinute.getInstance().getGameState() == GameState.RUNNING) {

            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "The wither is spawning now!");

            for (Player online : Bukkit.getOnlinePlayers()) {

                if (Bukkit.getOnlinePlayers().size() > players.size()) {
                    if (players.contains(online)) {
                        return;
                    }

                    players.add(online);

                    int randomPlayer = new Random().nextInt(players.size());

                    Player player = players.get(randomPlayer);

                    Location location = player.getLocation();

                    double newX = location.getX() - 7;
                    double newY = location.getY() + 2;
                    double newZ = location.getZ() + 3;
                    Location newLocation = new Location(player.getWorld(), newX, newY, newZ);
                    player.getWorld().spawnEntity(newLocation, EntityType.WITHER);
                }
            }
        }
    }
}

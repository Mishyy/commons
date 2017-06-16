package co.mhdv.commons.text;

import co.mhdv.commons.Commons;
import org.bukkit.entity.Player;

public final class Message {

    public static void send(Player player, String string) {
        for (String s : Patterns.NEW_LINE.split(string)) {
            player.sendMessage(Color.toColor(s));
        }
    }

    public static void broadcast(String string) {
        Commons.getServer().getOnlinePlayers().forEach(player -> {
            for (String s : Patterns.NEW_LINE.split(string)) {
                player.sendMessage(Color.toColor(s));
            }
        });
    }

    public static void broadcast(String string, String permission) {
        Commons.getServer().getOnlinePlayers().stream()
                .filter(player -> player.hasPermission(permission))
                .forEach(player -> {
                    for (String s : Patterns.NEW_LINE.split(string)) {
                        player.sendMessage(Color.toColor(s));
                    }
                });
    }

}

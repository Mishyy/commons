package co.mhdv.commons;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@SuppressWarnings("WeakerAccess")
public final class Message {

    private Message() {
    }

    public static String toColor(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String toColorless(String string) {
        return ChatColor.stripColor(Message.toColor(string));
    }

    public static void send(Player player, String string) {
        for (String s : Patterns.NEW_LINE.split(string)) {
            player.sendMessage(toColor(s));
        }
    }

    public static void broadcast(String string) {
        Commons.getServer().getOnlinePlayers().forEach(player -> {
            for (String s : Patterns.NEW_LINE.split(string)) {
                player.sendMessage(toColor(s));
            }
        });
    }

    public void broadcast(String string, String permission) {
        Commons.getServer().getOnlinePlayers().stream()
                .filter(player -> player.hasPermission(permission))
                .forEach(player -> {
                    for (String s : Patterns.NEW_LINE.split(string)) {
                        player.sendMessage(toColor(s));
                    }
                });
    }

}

package co.mhdv.commons.text;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class Color {

    public static String toColor(@NotNull String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String toColorless(@NotNull String string) {
        return ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', string));
    }

}

package co.mhdv.commons;

import com.google.common.base.Preconditions;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class Commons {

    private static JavaPlugin javaPlugin;

    public Commons(JavaPlugin javaPlugin) {
        Commons.javaPlugin = javaPlugin;
    }

    public static JavaPlugin getJavaPlugin() {
        Preconditions.checkNotNull(javaPlugin, "The constructor of ".concat(Commons.class.getName()).concat(" must be called in the #onEnable of the plugin before use."));
        return javaPlugin;
    }

    public static Server getServer() {
        Preconditions.checkNotNull(javaPlugin, "The constructor of ".concat(Commons.class.getName()).concat(" must be called in the #onEnable of the plugin before use."));
        return javaPlugin.getServer();
    }

}

package co.mhdv.commons;

import com.google.common.base.Preconditions;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("WeakerAccess")
public class Commons {

    private static JavaPlugin javaPlugin;

    public Commons(JavaPlugin javaPlugin) {
        Commons.javaPlugin = javaPlugin;
        getServer().getMessenger().registerOutgoingPluginChannel(javaPlugin, "BungeeCord");
    }

    public static JavaPlugin getJavaPlugin() {
        Preconditions.checkNotNull(javaPlugin);
        return javaPlugin;
    }

    public static Server getServer() {

        Preconditions.checkNotNull(javaPlugin);
        return javaPlugin.getServer();
    }

}

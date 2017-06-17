package co.mhdv.commons;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public final class Bungee {

    private Bungee() {
    }

    public static void connectServer(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);

        player.sendPluginMessage(Commons.getJavaPlugin(), "BungeeCord", out.toByteArray());
    }

    public static void connectServerOther(Player player, Player other, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(other.getName());
        out.writeUTF(server);

        player.sendPluginMessage(Commons.getJavaPlugin(), "BungeeCord", out.toByteArray());
    }

}

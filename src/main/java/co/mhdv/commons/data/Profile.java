package co.mhdv.commons.data;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface Profile {

    UUID getUuid();

    String getName();

    Player asBukkit();

}

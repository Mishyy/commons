package co.mhdv.commons;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public final class Task {

    private static final JavaPlugin PLUGIN = Commons.getJavaPlugin();
    private static final BukkitScheduler SCHEDULER = Commons.getServer().getScheduler();

    private Task() {
    }

    // Sync methods
    public static BukkitTask run(Runnable runnable) {
        return SCHEDULER.runTask(PLUGIN, runnable);
    }

    public static BukkitTask runTaskLater(Runnable runnable, long delay) {
        return SCHEDULER.runTaskLater(PLUGIN, runnable, (20 * delay));
    }

    public static BukkitTask runTaskTimer(Runnable runnable, long delay, long period) {
        return SCHEDULER.runTaskTimer(PLUGIN, runnable, (20 * delay), (20 * period));
    }

    // Async methods
    public static BukkitTask runAsync(Runnable runnable) {
        return SCHEDULER.runTaskAsynchronously(PLUGIN, runnable);
    }

    public static BukkitTask runTaskLaterAsync(Runnable runnable, long delay) {
        return SCHEDULER.runTaskLaterAsynchronously(PLUGIN, runnable, (20 * delay));
    }

    public static BukkitTask runTaskTimerAsync(Runnable runnable, long delay, long period) {
        return SCHEDULER.runTaskTimerAsynchronously(PLUGIN, runnable, (20 * delay), (20 * period));
    }

}

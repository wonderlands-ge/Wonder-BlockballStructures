package net.code4me.blockballstructures.utils.schedulerutil.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public class ScheduleData {

    private boolean sync;
    private long ticks;
    private Runnable runnable;
    private boolean repeating;
    private long cancelIn = -1;

    private JavaPlugin plugin;

}

package net.code4me.blockballstructures;

import lombok.Getter;
import net.code4me.blockballstructures.commands.TestCommand;
import net.code4me.blockballstructures.data.SchematicHandler;
import net.code4me.blockballstructures.data.SchematicStorage;
import net.code4me.blockballstructures.listener.GameEndListener;
import net.code4me.blockballstructures.listener.GoalScoreListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class BlockballStructures extends JavaPlugin {

    private SchematicStorage schematicStorage;
    private SchematicHandler schematicHandler;

    @Override
    public void onEnable() {
        schematicStorage = new SchematicStorage();
        schematicHandler = new SchematicHandler(this);

        getCommand("test").setExecutor(new TestCommand(this));
        registerListener(new GoalScoreListener(this));
        registerListener(new GameEndListener(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }
}

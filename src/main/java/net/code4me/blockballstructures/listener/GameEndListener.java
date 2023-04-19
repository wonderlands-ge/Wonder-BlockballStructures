package net.code4me.blockballstructures.listener;

import com.github.shynixn.blockball.api.bukkit.event.GameEndEvent;
import com.github.shynixn.blockball.api.business.enumeration.Team;
import net.code4me.blockballstructures.BlockballStructures;
import net.code4me.blockballstructures.data.SchematicStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameEndListener implements Listener {
    private final SchematicStorage schematicStorage;

    public GameEndListener(BlockballStructures plugin) {
        this.schematicStorage = plugin.getSchematicStorage();
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        schematicStorage.get(Team.BLUE, 0).getKey().paste();
        schematicStorage.get(Team.RED, 0).getKey().paste();
    }
}

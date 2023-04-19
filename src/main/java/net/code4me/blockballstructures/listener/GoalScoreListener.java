package net.code4me.blockballstructures.listener;

import com.github.shynixn.blockball.api.BlockBallApi;
import com.github.shynixn.blockball.api.bukkit.event.GameGoalEvent;
import com.github.shynixn.blockball.api.business.enumeration.Team;
import com.github.shynixn.blockball.api.business.service.GameService;
import com.github.shynixn.blockball.api.persistence.entity.Game;
import net.code4me.blockballstructures.BlockballStructures;
import net.code4me.blockballstructures.data.SchematicStorage;
import net.code4me.blockballstructures.data.SchematicWrapper;
import net.code4me.blockballstructures.utils.collection.Pair;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Optional;

public class GoalScoreListener implements Listener {

    private final GameService gameService;
    private final SchematicStorage schematicStorage;

    public GoalScoreListener(BlockballStructures plugin) {
        this.gameService = BlockBallApi.INSTANCE.resolve(GameService.class);
        this.schematicStorage = plugin.getSchematicStorage();

    }

    @EventHandler
    public void onGoalScore(GameGoalEvent event) {
        Player player = event.getPlayer();
        Team team = event.getTeam();

        Optional<Game> gameOptional = gameService.getGameFromPlayer(player);
        if (!gameOptional.isPresent()) {
            return;
        }

        Game game = gameOptional.get();

        int score = team == Team.BLUE ? game.getBlueScore() : game.getRedScore();

        Pair<SchematicWrapper, Location> pair = schematicStorage.get(team, score);

        if (pair == null) {
            return;
        }

        Location location = pair.getValue();

        pair.getKey().paste();
    }
}

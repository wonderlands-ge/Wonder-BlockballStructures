package net.code4me.blockballstructures.data;

import com.github.shynixn.blockball.api.business.enumeration.Team;
import net.code4me.blockballstructures.utils.collection.Pair;
import org.bukkit.Location;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SchematicStorage {

    private final Map<Integer, Pair<SchematicWrapper, Location>> blueSchematics = new LinkedHashMap<>();
    private final Map<Integer, Pair<SchematicWrapper, Location>> redSchematics = new LinkedHashMap<>();

    public void add(Team team, Pair<SchematicWrapper, Location> pair) {
        if (team == Team.BLUE) {
            blueSchematics.put(blueSchematics.size(), pair);
            return;
        }

        redSchematics.put(redSchematics.size(), pair);
    }

    public void add(Team team, List<Pair<SchematicWrapper, Location>> pairList) {

        for (Pair<SchematicWrapper, Location> pair : pairList) {
            add(team, pair);
        }
    }

    public Map<Integer, Pair<SchematicWrapper, Location>> get(Team team) {
        if (team == Team.BLUE) {
            return blueSchematics;
        }

        return redSchematics;
    }

    public Pair<SchematicWrapper, Location> get(Team team, int id) {
        if (team == Team.BLUE) {
            return blueSchematics.get(id);
        }

        return redSchematics.get(id);
    }
}

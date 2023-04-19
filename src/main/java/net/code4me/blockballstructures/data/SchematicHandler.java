package net.code4me.blockballstructures.data;

import com.github.shynixn.blockball.api.business.enumeration.Team;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.world.World;
import net.code4me.blockballstructures.BlockballStructures;
import net.code4me.blockballstructures.utils.collection.Pair;
import net.code4me.blockballstructures.utils.storage.YMLBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SchematicHandler extends YMLBase {

    private final BlockballStructures plugin;
    private final FileConfiguration config;
    private final SchematicStorage schematicStorage;

    public SchematicHandler(BlockballStructures plugin) {
        super(plugin, "schematics.yml");
        this.plugin = plugin;
        this.config = getConfiguration();
        this.schematicStorage = plugin.getSchematicStorage();
        load();
    }

    public void load() {
        ConfigurationSection blue = config.getConfigurationSection("blue");
        ConfigurationSection red = config.getConfigurationSection("red");
        World world = new BukkitWorld(Bukkit.getWorld(config.getString("world-name")));

        schematicStorage.add(Team.BLUE, getSchematics(blue, world));
        schematicStorage.add(Team.RED, getSchematics(red, world));

        System.out.println("Loaded " + schematicStorage.get(Team.BLUE).size() + " blue schematics");
        System.out.println("Loaded " + schematicStorage.get(Team.RED).size() + " red schematics");
    }


    public List<Pair<SchematicWrapper, Location>> getSchematics(ConfigurationSection teamSection, com.sk89q.worldedit.world.World world) {
        List<Pair<SchematicWrapper, Location>> pairs = new ArrayList<>();
        for (String key : teamSection.getKeys(false)) {
            String schematic = teamSection.getString(key + ".schematic-name");
            String location = teamSection.getString(key + ".location");

            Location loc = getLocation(location);

            File schematicFile = new File(plugin.getDataFolder() + File.separator + "schematics" + File.separator + schematic + ".schematic");

            if (!schematicFile.exists()) {
                System.out.println("Schematic " + schematic + " does not exist, skipping...");
                continue;
            }

            SchematicWrapper schematicWrapper = new SchematicWrapper(world, loc, schematicFile);
            pairs.add(new Pair<>(schematicWrapper, loc));
        }

        return pairs;
    }

    private Location getLocation(String location) {
        String[] split = location.split(", ");
        return new Location(null, Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
    }
}

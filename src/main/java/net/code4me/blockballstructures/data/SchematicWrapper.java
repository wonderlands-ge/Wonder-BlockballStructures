package net.code4me.blockballstructures.data;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.schematic.SchematicFormat;
import com.sk89q.worldedit.world.World;
import lombok.SneakyThrows;
import org.bukkit.Location;

import java.io.File;

public class SchematicWrapper {
    private final World world;
    private final Location location;
    private final File schematic;

    public SchematicWrapper(World world, Location location, File schematic) {
        this.world = world;
        this.location = location;
        this.schematic = schematic;
    }

    @SneakyThrows
    public void paste() {
        paste(this.location);
    }

    @SneakyThrows
    public void paste(Location location) {
        Vector vector = new Vector(location.getX(), location.getY(), location.getZ());

        SchematicFormat schematicFormat = SchematicFormat.getFormat(schematic);

        if (schematicFormat == null) {
            throw new IllegalArgumentException("Schematic file is not supported");
        }

        EditSession editSession = new EditSession((BukkitWorld) this.world, -1);
        schematicFormat.load(schematic).paste(editSession, vector, true);
    }
}

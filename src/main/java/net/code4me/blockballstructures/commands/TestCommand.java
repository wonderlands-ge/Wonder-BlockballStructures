package net.code4me.blockballstructures.commands;

import com.github.shynixn.blockball.api.business.enumeration.Team;
import net.code4me.blockballstructures.BlockballStructures;
import net.code4me.blockballstructures.data.SchematicStorage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private final BlockballStructures plugin;
    private final SchematicStorage schematicStorage;

    public TestCommand(BlockballStructures plugin) {
        this.plugin = plugin;
        this.schematicStorage = plugin.getSchematicStorage();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args[0].isEmpty()) {
            System.out.println("Empty");
            return true;
        }

        if (!args[0].equalsIgnoreCase("paste")) {
            return true;
        }

        Player pl = (Player) sender;

        if (!pl.hasPermission("structures.paste")) {
            pl.sendMessage("No permission to use this command");
            return true;
        }

        String team = args[1];
        int score = Integer.parseInt(args[2]);

        schematicStorage.get(Team.valueOf(team.toUpperCase()), score).getKey().paste();
        pl.sendMessage("Pasted");
        return true;
    }
}

package io.github.shake.faweapitest;

import com.fastasyncworldedit.core.FaweAPI;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EditSessionBuilder;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 6) return false;

        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int z1 = Integer.parseInt(args[2]);
        int x2 = Integer.parseInt(args[3]);
        int y2 = Integer.parseInt(args[4]);
        int z2 = Integer.parseInt(args[5]);
        World world;
        if (sender instanceof Player) world = BukkitAdapter.adapt(((Player) sender).getLocation().getWorld());
        else world = FaweAPI.getWorld("world");

        EditSession es = WorldEdit.getInstance().newEditSession(world);
        CuboidRegion select = new CuboidRegion(world, BlockVector3.at(x1, y1, z1), BlockVector3.at(x2, y2, z2));
        sender.sendMessage("World: " + world);
        sender.sendMessage("EditSession: " + es);
        sender.sendMessage("CuboidRegion: " + select);

        es.setBlocks((Region) select, BlockTypes.STONE.getDefaultState());
        es.flushQueue();
        return true;
    }
}

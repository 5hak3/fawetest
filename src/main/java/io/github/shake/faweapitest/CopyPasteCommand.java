package io.github.shake.faweapitest;

import com.fastasyncworldedit.core.FaweAPI;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CopyPasteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 9) return false;

        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int z1 = Integer.parseInt(args[2]);
        int x2 = Integer.parseInt(args[3]);
        int y2 = Integer.parseInt(args[4]);
        int z2 = Integer.parseInt(args[5]);
        int x3 = Integer.parseInt(args[6]);
        int y3 = Integer.parseInt(args[7]);
        int z3 = Integer.parseInt(args[8]);
        World world;
        if (sender instanceof Player) world = BukkitAdapter.adapt(((Player) sender).getLocation().getWorld());
        else world = FaweAPI.getWorld("world");

        CuboidRegion select = new CuboidRegion(world, BlockVector3.at(x1, y1, z1), BlockVector3.at(x2, y2, z2));
        ForwardExtentCopy fec = new ForwardExtentCopy(world, select, world, BlockVector3.at(x3, y3, z3));
        Operations.complete(fec);
        return true;
    }
}

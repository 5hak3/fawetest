package io.github.shake.faweapitest;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FAWEAPITest extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("faweset")).setExecutor(new SetCommand());
        Objects.requireNonNull(getCommand("fawerep")).setExecutor(new ReplaceCommand());
        Objects.requireNonNull(getCommand("fawecpp")).setExecutor(new CopyPasteCommand());
    }
}

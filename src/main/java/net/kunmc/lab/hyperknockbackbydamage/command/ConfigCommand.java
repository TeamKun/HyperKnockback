package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("config");

        children(new ConfigShowCommand(), new ConfigSetCommand());
    }
}
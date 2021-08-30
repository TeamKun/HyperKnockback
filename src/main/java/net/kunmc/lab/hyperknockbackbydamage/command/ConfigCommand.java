package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;
import net.kunmc.lab.hyperknockbackbydamage.ConfigShowCommand;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("config");

        children(new ConfigShowCommand(), new ConfigSetCommand());
    }
}
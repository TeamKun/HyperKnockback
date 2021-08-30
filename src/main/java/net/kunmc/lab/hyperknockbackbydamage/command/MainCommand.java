package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;

public class MainCommand extends Command {
    public MainCommand(String name) {
        super(name);

        children(new ConfigCommand());
    }
}

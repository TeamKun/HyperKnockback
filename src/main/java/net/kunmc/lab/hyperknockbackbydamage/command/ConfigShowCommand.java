package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hyperknockbackbydamage.Config;

import java.lang.reflect.Field;

public class ConfigShowCommand extends Command {
    public ConfigShowCommand() {
        super("show");
    }

    @Override
    public void execute(CommandContext ctx) {
        try {
            for (Field field : Config.class.getDeclaredFields()) {
                ctx.success(field.getName() + ": " + field.get(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
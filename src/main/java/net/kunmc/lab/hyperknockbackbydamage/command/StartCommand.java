package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hyperknockbackbydamage.Config;

public class StartCommand extends Command {
    public StartCommand() {
        super("start");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (Config.isEnabled) {
            ctx.fail("HyperKnockbackは既に有効です.");
            return;
        }

        Config.isEnabled = true;
        ctx.success("HyperKnockbackを有効化しました.");
    }
}

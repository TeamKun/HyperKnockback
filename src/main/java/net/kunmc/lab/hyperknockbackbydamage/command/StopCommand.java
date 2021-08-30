package net.kunmc.lab.hyperknockbackbydamage.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hyperknockbackbydamage.Config;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!Config.isEnabled) {
            ctx.fail("HyperKnockbackは既に無効です.");
            return;
        }

        Config.isEnabled = false;
        ctx.success("HyperKnockbackを無効化しました.");
    }
}

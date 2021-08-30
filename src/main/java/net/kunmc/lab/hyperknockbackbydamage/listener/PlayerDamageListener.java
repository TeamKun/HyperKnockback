package net.kunmc.lab.hyperknockbackbydamage.listener;

import dev.kotx.flylib.ListenerAction;
import net.kunmc.lab.hyperknockbackbydamage.Config;
import net.kunmc.lab.hyperknockbackbydamage.HyperKnockbackByDamage;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerDamageListener implements ListenerAction<EntityDamageEvent> {
    @Override
    public void execute(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        new SetVelocityTask(((Player) e.getEntity())).runTaskTimerAsynchronously(HyperKnockbackByDamage.instance, 0, 4);
    }
}

class SetVelocityTask extends BukkitRunnable {
    private int count = 0;
    private final int numberOfTimes = ((int) Math.ceil(Config.knockbackCoefficient / 4));
    private final Player target;
    private final Vector vector;

    SetVelocityTask(Player target) {
        this.target = target;

        Vector direction = target.getEyeLocation().getDirection().clone();
        if (Config.knockbackCoefficient > 4) {
            direction.multiply(-4);
        } else {
            direction.multiply(-Config.knockbackCoefficient);
        }
        this.vector = direction;
    }

    @Override
    public void run() {
        if (target.isDead()) {
            this.cancel();
            return;
        }

        target.setVelocity(vector);

        count++;
        if (count >= numberOfTimes) {
            this.cancel();
        }
    }
}
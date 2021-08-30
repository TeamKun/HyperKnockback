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
        Player p = ((Player) e.getEntity());

        Vector direction = p.getEyeLocation().getDirection();
        direction.multiply(new Vector(-1, -1, -1));
        direction.multiply(Config.knockbackCoefficient);

        new BukkitRunnable() {
            @Override
            public void run() {
                p.setVelocity(direction);
            }
        }.runTaskLater(HyperKnockbackByDamage.instance, 1);
    }
}

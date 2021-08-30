package net.kunmc.lab.hyperknockbackbydamage;

import dev.kotx.flylib.FlyLib;
import net.kunmc.lab.hyperknockbackbydamage.listener.PlayerDamageListener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HyperKnockbackByDamage extends JavaPlugin {
    public static HyperKnockbackByDamage instance;

    @Override
    public void onEnable() {
        instance = this;
        
        FlyLib.create(this, builder -> {
            builder.listen(EntityDamageEvent.class, new PlayerDamageListener());
        });
    }

    @Override
    public void onDisable() {
    }
}

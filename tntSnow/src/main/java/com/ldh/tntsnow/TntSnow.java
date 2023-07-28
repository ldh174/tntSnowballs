package com.ldh.tntsnow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TntSnow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("[+] tntSnow_plugin_initiated [+]");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) {
        if (event.getEntityType() == EntityType.SNOWBALL) {
            Snowball snowball = (Snowball) event.getEntity();
            Player shooter = (Player) snowball.getShooter();

            // Spawn a TNT entity at the snowball's location and make it explode immediately
            TNTPrimed tnt = (TNTPrimed) snowball.getWorld().spawnEntity(snowball.getLocation(), EntityType.PRIMED_TNT);
            tnt.setFuseTicks(0);

            // If you want to remove the snowball upon impact, you can use:
            snowball.remove();
        }
    }

    @Override
    public void onDisable() {
        System.out.println("[+] tntSnow_plugin_shutdown [+]");
    }
}

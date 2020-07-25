package com.github.hotpee.pvpcontrol.Listeners;

import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void Damage(EntityDamageByEntityEvent e){
        if (e.isCancelled()) {
            return;
        }
        if (e.getDamager() instanceof Player){
            if (e.getEntity() instanceof Player){
                for (String s : PVPControl.disableWorld ) {
                    if (e.getDamager().getWorld().getName().contains(s) && e.getEntity().getWorld().getName().contains(s)){
                        return;
                    }
                }
                Player Victim = (Player)e.getEntity();
                Player Attacker = (Player)e.getDamager();
                if (!(PVPControl.pvpmode.get(Attacker.getUniqueId()))){
                    Utils.Message(Attacker, ConfigManager.getPrefix() + ConfigManager.getCancelAttack());
                    e.setCancelled(true);
                    e.setDamage(0);
                    return;
                }
                if (!(PVPControl.pvpmode.get(Victim.getUniqueId()))){
                    Utils.Message(Attacker, ConfigManager.getPrefix() + ConfigManager.getCancelAttack2());
                    e.setCancelled(true);
                    e.setDamage(0);
                    return;
                }
            }
        }
        if (e.getDamager() instanceof Projectile){
            if (e.getEntity() instanceof Player){
                for (String s : PVPControl.disableWorld ) {
                    if (e.getDamager().getWorld().getName().contains(s) && e.getEntity().getWorld().getName().contains(s)){
                        return;
                    }
                }
                Projectile projectile = (Projectile)e.getDamager();
                if (projectile.getShooter() instanceof Player){
                    if (!(PVPControl.pvpmode.get(((Player) projectile.getShooter()).getUniqueId()))){
                        Utils.Message((Player)projectile.getShooter(), ConfigManager.getPrefix() + ConfigManager.getCancelAttack());
                        e.setCancelled(true);
                        e.setDamage(0);
                        return;
                    }
                }
                if (!(PVPControl.pvpmode.get(e.getEntity().getUniqueId()))){
                    Utils.Message((Player) projectile.getShooter(), ConfigManager.getPrefix() + ConfigManager.getCancelAttack2());
                    e.setCancelled(true);
                    e.setDamage(0);
                    return;
                }

            }
        }
    }

}

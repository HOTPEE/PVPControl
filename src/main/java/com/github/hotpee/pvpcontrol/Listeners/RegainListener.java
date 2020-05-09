package com.github.hotpee.pvpcontrol.Listeners;

import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class RegainListener implements Listener {
    @EventHandler
    public void regain(EntityRegainHealthEvent e){
        if (e.getEntity() instanceof Player && e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
            if (ConfigManager.isNoLifeRecovery()){
                if (PVPControl.pvpmode.get(e.getEntity().getUniqueId())){
                    e.setCancelled(true);
                    e.setAmount(0.0D);
                }
            }
        }
    }
}

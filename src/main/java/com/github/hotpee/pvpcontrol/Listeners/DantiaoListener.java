package com.github.hotpee.pvpcontrol.Listeners;

import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import com.valorin.api.event.arena.ArenaStartEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DantiaoListener implements Listener {

    @EventHandler
    public void ArenaStartEvent(ArenaStartEvent e){
        Player p = e.getPlayer1();
        Player p2 = e.getPlayer2();
        PVPControl.pvpmode.put(p.getUniqueId(), false);
        PVPControl.pvpmode.put(p2.getUniqueId(), false);
        Utils.Message(p, ConfigManager.getPrefix() + ConfigManager.getDantiaoStart());
    }
}

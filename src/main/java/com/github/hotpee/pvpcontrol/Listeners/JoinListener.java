package com.github.hotpee.pvpcontrol.Listeners;

import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (ConfigManager.isDefaultPVPMode()){
            PVPControl.pvpmode.put(p.getUniqueId(), true);
            String msg = PlaceholderAPI.setPlaceholders(p, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(p, msg);
            return;
        } else {
            PVPControl.pvpmode.put(p.getUniqueId(), false);
            String msg = PlaceholderAPI.setPlaceholders(p, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(p, msg);
            return;
        }
    }
}

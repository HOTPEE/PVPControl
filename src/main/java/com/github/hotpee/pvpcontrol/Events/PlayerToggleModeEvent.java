package com.github.hotpee.pvpcontrol.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerToggleModeEvent extends Event {

    private Player player;
    private static final HandlerList handlers = new HandlerList();
    private Boolean mode;
    public PlayerToggleModeEvent(Player player, Boolean mode){
        this.player = player;
        this.mode = mode;
    }

    public Player getPlayer() {
        return player;
    }

    public Boolean getMode() {
        return mode;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}

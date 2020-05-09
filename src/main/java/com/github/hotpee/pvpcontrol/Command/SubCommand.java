package com.github.hotpee.pvpcontrol.Command;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    public SubCommand(){
    }

    public abstract void onCommand(Player player, String[] args);

    public abstract String name();
    public abstract String[] aliases();
}

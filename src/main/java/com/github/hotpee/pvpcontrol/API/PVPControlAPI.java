package com.github.hotpee.pvpcontrol.API;

import org.bukkit.entity.Player;

public interface PVPControlAPI {

    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stayIn, int fadeOut);
}

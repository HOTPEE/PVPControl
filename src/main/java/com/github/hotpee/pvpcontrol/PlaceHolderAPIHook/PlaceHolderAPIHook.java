package com.github.hotpee.pvpcontrol.PlaceHolderAPIHook;

import com.github.hotpee.pvpcontrol.PVPControl;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceHolderAPIHook extends PlaceholderExpansion {
    private PVPControl pvpControl;

    public PlaceHolderAPIHook(PVPControl pvpControl) {
        this.pvpControl = pvpControl;
    }
    public String getIdentifier(){
        return "pvpcontrol";
    }

    @Override
    public String getAuthor() {
        return PVPControl.getInstance().getDescription().getAuthors().toString();
    }

    @Override
    public String getVersion() {
        return PVPControl.getInstance().getDescription().getVersion();
    }

    public String onPlaceholderRequest(Player player, String s) {
        if (s.equals("mode"))
            if (PVPControl.pvpmode.get(player.getUniqueId())){
                return "&c战斗模式";
            } else {
                return "&a和平模式";
            }
        if (player == null)
            return "";
        return null;
    }
}

package com.github.hotpee.pvpcontrol.Command.SubCommands;

import com.github.hotpee.pvpcontrol.Command.SubCommand;
import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class meCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length != 1){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        if (PVPControl.pvpmode.get(player.getUniqueId())){
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getSelfMode());
            Utils.Message(player, msg);
        } else {
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getSelfMode());
            Utils.Message(player, msg);
        }

    }

    @Override
    public String name() {
        return PVPControl.getInstance().commandManager.me;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}

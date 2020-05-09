package com.github.hotpee.pvpcontrol.Command.SubCommands;

import com.github.hotpee.pvpcontrol.Command.SubCommand;
import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class ReloadCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (!(player.hasPermission("PVPControl.Admin"))){
            Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getNoPermission());
            return;
        }
        if (args.length != 1){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        PVPControl.getInstance().reloadConfig();
        Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getSucessfullyReload());

    }

    @Override
    public String name() {
        return PVPControl.getInstance().commandManager.reload;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}

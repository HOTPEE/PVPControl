package com.github.hotpee.pvpcontrol.Command.SubCommands;

import com.github.hotpee.pvpcontrol.Command.SubCommand;
import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LookCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (!(player.hasPermission("PVPControl.Admin"))){
            Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getNoPermission());
            return;
        }
        if (args.length != 2){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        Player p1 = Bukkit.getPlayer(args[1]);
        String msg = PlaceholderAPI.setPlaceholders(p1, ConfigManager.getPrefix() + ConfigManager.getTargetMode());
        Utils.Message(player, msg);

    }

    @Override
    public String name() {
        return PVPControl.getInstance().commandManager.look;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}

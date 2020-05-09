package com.github.hotpee.pvpcontrol.Command.SubCommands;

import com.github.hotpee.pvpcontrol.Command.SubCommand;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        Utils.Help(player);
    }

    @Override
    public String name() {
        return PVPControl.getInstance().commandManager.help;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}

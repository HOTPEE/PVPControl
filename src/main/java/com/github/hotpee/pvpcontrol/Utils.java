package com.github.hotpee.pvpcontrol;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
    public static void Message(CommandSender p, String s){
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }
    public static void MessageTitle(Player p, String t, String s){
        p.sendTitle(ChatColor.translateAlternateColorCodes('&', t), ChatColor.translateAlternateColorCodes('&', s), 10, 30, 10);
    }

    public static void Help(Player player){
        if (player.isOp()){
            Utils.Message(player, "&7&l---------------------------------");
            Utils.Message(player, "&bPVPControl 主命令帮助");
            Utils.Message(player, "&a");
            Utils.Message(player, "&b● &7/pvpc help - &c查看插件所有命令");
            Utils.Message(player, "&b● &7/pvpc me - &c查看自身的战斗状态");
            Utils.Message(player, "&b● &7/pvpc toggle - &c切换你的战斗状态");
            Utils.Message(player, "&b● &7/pvpc pvp on - &c开启自身战斗模式");
            Utils.Message(player, "&b● &7/pvpc pvp off - &c开启自身和平模式");
            Utils.Message(player, "&b● &7/pvpc pvp on <Player> - &c设置某玩家的战斗状态为战斗模式");
            Utils.Message(player, "&b● &7/pvpc pvp off <Player> - &c设置某玩家的战斗状态为战斗模式");
            Utils.Message(player, "&b● &7/pvpc look <Player> - &c查看某玩家的战斗状态");
            Utils.Message(player, "&b● &7/pvpc reload - &c重载插件");
            Utils.Message(player, "&a");
            Utils.Message(player, "&7&l--------------------------------");
        } else {
            Utils.Message(player, "&7&l---------------------------------");
            Utils.Message(player, "&bPVPControl 主命令帮助");
            Utils.Message(player, "&a");
            Utils.Message(player, "&b● &7/pvpc help - &c查看插件所有命令");
            Utils.Message(player, "&b● &7/pvpc me - &c查看自身的PVP状态");
            Utils.Message(player, "&b● &7/pvpc toggle - &c切换你的PVP状态");
            Utils.Message(player, "&b● &7/pvpc pvp on - &c开启自身PVP模式");
            Utils.Message(player, "&b● &7/pvpc pvp off - &c开启自身和平模式");
            Utils.Message(player, "&a");
            Utils.Message(player, "&7&l--------------------------------");
        }

    }

}

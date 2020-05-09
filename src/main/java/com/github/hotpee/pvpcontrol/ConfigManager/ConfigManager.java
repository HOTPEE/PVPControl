package com.github.hotpee.pvpcontrol.ConfigManager;

import com.github.hotpee.pvpcontrol.PVPControl;

public class ConfigManager {
    // 前缀部分
    public static String getPrefix(){
        return PVPControl.getInstance().getConfig().getString("Prefix").replaceAll("§","&");
    }

    // Settings 部分
    public static Boolean isDefaultPVPMode(){
        return PVPControl.getInstance().getConfig().getBoolean("Settings.DefaultPVPMode");
    }
    public static Boolean isTitleMessage(){
        return PVPControl.getInstance().getConfig().getBoolean("Settings.TitleMessage");
    }
    public static Boolean isNoLifeRecovery(){
        return PVPControl.getInstance().getConfig().getBoolean("Settings.NoLifeRecovery");
    }

    // Language 部分
    public static String getNoPermission(){
        return PVPControl.getInstance().getConfig().getString("Language.NoPermission").replaceAll("§","&");
    }
    public static String getSucessfullyReload(){
        return PVPControl.getInstance().getConfig().getString("Language.SucessfullyReload").replaceAll("§","&");
    }
    public static String getCancelAttack(){
        return PVPControl.getInstance().getConfig().getString("Language.CancelAttack").replaceAll("§","&");
    }
    public static String getCancelAttack2(){
        return PVPControl.getInstance().getConfig().getString("Language.CancelAttack2").replaceAll("§","&");
    }
    public static String getToggleMode(){
        return PVPControl.getInstance().getConfig().getString("Language.ToggleMode").replaceAll("§","&");
    }
    public static String getAdminSetPVPMode(){
        return PVPControl.getInstance().getConfig().getString("Language.AdminSetPVPMode").replaceAll("§","&");
    }
    public static String getAttackStates(){
        return PVPControl.getInstance().getConfig().getString("Language.AttackStates").replaceAll("§","&");
    }
    public static String getSelfMode(){
        return PVPControl.getInstance().getConfig().getString("Language.SelfMode").replaceAll("§","&");
    }
    public static String getTargetMode(){
        return PVPControl.getInstance().getConfig().getString("Language.TargetMode").replaceAll("§","&");
    }
}

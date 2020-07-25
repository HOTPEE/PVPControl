package com.github.hotpee.pvpcontrol;

import com.github.hotpee.pvpcontrol.API.*;
import com.github.hotpee.pvpcontrol.Command.CommandManager;
import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.Listeners.DamageListener;
import com.github.hotpee.pvpcontrol.Listeners.DantiaoListener;
import com.github.hotpee.pvpcontrol.Listeners.JoinListener;
import com.github.hotpee.pvpcontrol.Listeners.RegainListener;
import com.github.hotpee.pvpcontrol.Metrics.Metrics;
import com.github.hotpee.pvpcontrol.PlaceHolderAPIHook.PlaceHolderAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class PVPControl extends JavaPlugin {
    public PVPControlAPI pvpControlAPI;
    private static PVPControl ins;
    public static Map<UUID, Boolean> pvpmode = new HashMap<>();
    public static List<String> disableWorld = new ArrayList<>();
    public CommandManager commandManager;
    private boolean dantiao = false;

    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        new Metrics(this);
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceHolderAPIHook(this).register();
            getLogger().info("[PVPControl]PlaceHolderAPI检测成功!插件正常启动");
        } else {
            getLogger().info("[PVPControl]PlaceHolderAPI获取失败!插件已关闭");
            setEnabled(false);
        }
        commandManager = new CommandManager();
        commandManager.setUp();
        checkDantiao();
        regListener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static PVPControl getInstance(){
        return ins;
    }

    public void regListener(){
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegainListener(), this);
        if (dantiao){
            Bukkit.getPluginManager().registerEvents(new DantiaoListener(), this);
        }

    }

    public void checkDantiao(){
        if (Bukkit.getPluginManager().isPluginEnabled("Dantiao")){
            getLogger().info("[PVPControl]Dantiao插件检测成功!插件部分功能可允许正常使用");
            dantiao = true;
        } else {
            getLogger().info("[PVPControl]未检测到Dantiao插件相关功能已关闭");
            dantiao = false;
        }
    }
    public void checkVersion(){
        String s = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (s.equals("v1_8_R3")){
            pvpControlAPI = new PVPControlAPI_1_8();
        } else if (s.equals("v1_9_R2")) {
            pvpControlAPI = new PVPControlAPI_1_9();
        } else if (s.equals("v1_10_R1")){
            pvpControlAPI = new PVPControlAPI_1_10();
        } else if (s.equals("v1_11_R1")) {
            pvpControlAPI = new PVPControlAPI_1_11();
        } else {
            pvpControlAPI = null;
        }
    }

    public void addDisableWorld(){
        disableWorld.addAll(ConfigManager.getWorld());
    }

}

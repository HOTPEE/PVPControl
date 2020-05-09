package com.github.hotpee.pvpcontrol;

import com.github.hotpee.pvpcontrol.Command.CommandManager;
import com.github.hotpee.pvpcontrol.Listeners.DamageListener;
import com.github.hotpee.pvpcontrol.Listeners.JoinListener;
import com.github.hotpee.pvpcontrol.Listeners.RegainListener;
import com.github.hotpee.pvpcontrol.PlaceHolderAPIHook.PlaceHolderAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PVPControl extends JavaPlugin {
    private static PVPControl ins;
    public static Map<UUID, Boolean> pvpmode = new HashMap<>();
    public CommandManager commandManager;

    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceHolderAPIHook(this).register();
            getLogger().info("[PVPControl]PlaceHolderAPI检测成功!插件正常启动");
        } else {
            getLogger().info("[PVPControl]PlaceHolderAPI获取失败!插件已关闭");
            setEnabled(false);
        }
        regListener();
        commandManager = new CommandManager();
        commandManager.setUp();
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
    }
}

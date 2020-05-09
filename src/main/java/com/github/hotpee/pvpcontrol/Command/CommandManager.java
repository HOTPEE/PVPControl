package com.github.hotpee.pvpcontrol.Command;

import com.github.hotpee.pvpcontrol.Command.SubCommands.*;
import com.github.hotpee.pvpcontrol.ConfigManager.ConfigManager;
import com.github.hotpee.pvpcontrol.PVPControl;
import com.github.hotpee.pvpcontrol.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> subcommand = new ArrayList<SubCommand>();

    public CommandManager(){

    }
    public String main = "pvpc";
    public String reload = "reload";
    public String help = "help";
    public String me = "me";
    public String toggle = "toggle";
    public String pvp = "pvp";
    public String look = "look";

    public void setUp(){
        PVPControl.getInstance().getCommand(main).setExecutor(this);
        this.subcommand.add(new HelpCommand());
        this.subcommand.add(new meCommand());
        this.subcommand.add(new PVPCommand());
        this.subcommand.add(new ReloadCommand());
        this.subcommand.add(new ToggleCommand());
        this.subcommand.add(new LookCommand());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(ConfigManager.getPrefix().replaceAll("&", "§") + "§c本插件只能是玩家运行");
            return true;
        }
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase(main)){
            if (args.length == 0){
                Utils.Help(player);
                return true;
            }
            SubCommand target = this.get(args[0]);
            if (target == null){
                Utils.Message(player,ConfigManager.getPrefix() + "§c警告，未知指令");
                return true;
            }

            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.addAll(Arrays.asList(args));
            arrayList.remove(0);

            try{
                target.onCommand(player,args);
            } catch (Exception e){
                Utils.Message(player,ConfigManager.getPrefix() + "§4发生了严重错误，请查看后台报错");
                e.printStackTrace();
            }
        }



        return true;
    }

    private SubCommand get(String name){
        Iterator<SubCommand> sCommands = this.subcommand.iterator();

        while(sCommands.hasNext()){
            SubCommand sc = (SubCommand) sCommands.next();

            if (sc.name().equalsIgnoreCase(name)){
                return sc;
            }
            String [] aliases;
            int length = (aliases = sc.aliases()).length;
            for(int var5 = 0; var5 < length; ++var5){
                String alias = aliases[var5];
                if (name.equalsIgnoreCase(alias)){
                    return sc;
                }

            }
        }
        return null;
    }
}

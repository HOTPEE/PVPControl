package com.github.hotpee.pvpcontrol.API;

import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.Packet;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PVPControlAPI_1_9 implements PVPControlAPI{
    @Override
    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stayIn, int fadeOut) {
        IChatBaseComponent titlesend = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        IChatBaseComponent subtitlesend = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titlesend, fadeIn, stayIn, fadeOut);
        PacketPlayOutTitle packet2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitlesend, fadeIn, stayIn, fadeOut);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)packet);
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)packet2);

    }
}

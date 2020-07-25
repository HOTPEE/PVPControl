package com.github.hotpee.pvpcontrol.API;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PVPControlAPI_1_8 implements PVPControlAPI{
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

package fr.pablo.supersnail.trigger.core;

import fr.pablo.supersnail.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;

import java.awt.*;

public class GuildQuit {
    public GuildQuit(GuildLeaveEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setTitle("Super Snail left a Discord!");
        eb.setDescription("» Name: " + e.getGuild().getName());
        eb.setFooter(Main.credits);
        Main.jda.getTextChannelById(759714262137569310L).sendMessage(eb.build()).queue();
    }
}

package fr.pablo.supersnail.trigger.core;

import fr.pablo.supersnail.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;

import java.awt.*;

public class GuildJoin {
    public GuildJoin(GuildJoinEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.GREEN);
        eb.setTitle("Super Snail joined a Discord!");
        eb.setDescription("» Name: " + e.getGuild().getName() + "\n» Members: " + e.getGuild().getMembers().size() + "\n» Created: " + e.getGuild().getTimeCreated());
        eb.setFooter(Main.credits);
        Main.jda.getTextChannelById(759714262137569310L).sendMessage(eb.build()).queue();
    }
}

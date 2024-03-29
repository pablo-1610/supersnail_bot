package fr.pablo.supersnail.trigger;

import fr.pablo.supersnail.trigger.core.GuildJoin;
import fr.pablo.supersnail.trigger.core.GuildQuit;
import fr.pablo.supersnail.trigger.core.MsgEvent;
import fr.pablo.supersnail.trigger.core.MsgReact;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.annotation.Nonnull;

public class Handler implements EventListener {
    @Override
    public void onEvent(@Nonnull GenericEvent e) {
        if(e instanceof MessageReceivedEvent) new MsgEvent((MessageReceivedEvent) e);
        if(e instanceof MessageReactionAddEvent) new MsgReact((MessageReactionAddEvent) e);
        if(e instanceof GuildJoinEvent) new GuildJoin((GuildJoinEvent) e);
        if(e instanceof GuildLeaveEvent) new GuildQuit((GuildLeaveEvent) e);
    }
}

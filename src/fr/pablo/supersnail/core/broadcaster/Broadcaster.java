package fr.pablo.supersnail.core.broadcaster;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;

public class Broadcaster {
    private JDA instance;
    public Broadcaster(JDA instance){
        this.instance = instance;
    }

    public void broadcast(String mess){
        instance.getGuilds().forEach(guild -> {
            System.out.println("Guild reached");
            guild.getTextChannels().forEach(textChannel ->{
                if(textChannel.getName().equalsIgnoreCase("interleak")){
                    textChannel.sendMessage(mess).queue();
                }
            });
        });
    }
}

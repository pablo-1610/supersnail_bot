package fr.pablo.supersnail.trigger.core;

import fr.pablo.supersnail.Main;
import fr.pablo.supersnail.core.submissions.Submission;
import fr.pablo.supersnail.core.submissions.SubmissionType;
import fr.pablo.supersnail.core.submissions.SubmissionsHandler;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.TimeUnit;

public class MsgEvent {
    public MsgEvent(MessageReceivedEvent e) {
        if (e.getAuthor().equals(e.getJDA().getSelfUser())) return;
        String message = e.getMessage().getContentRaw();
        Long authorID  = e.getAuthor().getIdLong();
        if(e.getChannelType().equals(ChannelType.PRIVATE)){
            if(SubmissionsHandler.underSubmission.containsKey(authorID)){
                if(SubmissionsHandler.underSubmission.get(authorID) == 1){
                    e.getChannel().sendMessage("⛔ — Please select the type of your leak!").queue();
                    return;
                }
                if(SubmissionsHandler.underSubmission.get(authorID) == 2){
                    if(message.split("").length > 50){
                        e.getChannel().sendMessage("⛔ — The title of the resource must be less than 50 characters!").queue();
                        return;
                    }
                    e.getChannel().sendMessage("✅ — The title of the resource has been saved.").queue();
                    e.getChannel().sendMessage("\uD83D\uDC40️ — Please type a description for the ressource.").queue();

                    SubmissionsHandler.submissionBuilder.get(authorID).setTitle(message);
                    SubmissionsHandler.underSubmission.put(authorID,3);
                    return;
                }
                if(SubmissionsHandler.underSubmission.get(authorID) == 3){
                    if(message.split("").length > 300){
                        e.getChannel().sendMessage("⛔ — The description of the resource must be less than 300 characters!").queue();
                        return;
                    }
                    e.getChannel().sendMessage("✅ — The description of the resource has been saved.").queue();
                    e.getChannel().sendMessage("\uD83D\uDC40️ — Please provide a valid download link for the ressource.").queue();
                    SubmissionsHandler.submissionBuilder.get(authorID).setDesc(message);
                    SubmissionsHandler.underSubmission.put(authorID,4);
                    return;
                }
                if(SubmissionsHandler.underSubmission.get(authorID) == 4){
                    if(message.split("").length > 80){
                        e.getChannel().sendMessage("⛔ — The download link of the resource must be less than 80 characters!").queue();
                        return;
                    }
                    e.getChannel().sendMessage("✅ — The download link of the resource has been saved.").queue();
                    e.getChannel().sendMessage("✈️ — Your resource is being analyzed by our team, you will receive a message within 2 hours maximum.").queueAfter(3, TimeUnit.SECONDS);
                    SubmissionsHandler.underSubmission.put(authorID,5);
                    SubmissionsHandler.submissionBuilder.get(authorID).setDlLink(message);
                    SubmissionsHandler.submit(authorID);
                    return;
                }
                if(SubmissionsHandler.underSubmission.get(authorID) == 5){
                    e.getTextChannel().sendMessage("⛔ — You already have an active request, please wait for the answer to this one.").queue();
                    return;
                }
                return;
            }

            if(message.startsWith("!submit".toLowerCase())){
                SubmissionsHandler.submissionBuilder.put(authorID,new Submission("","","",authorID,null,0));
                SubmissionsHandler.underSubmission.put(authorID,1);

                StringBuilder sb = new StringBuilder();

                for (SubmissionType value : SubmissionType.values()) sb.append("\n"+value.getEmoji() + " • "+value.getDisplay());
                e.getChannel().sendMessage("\uD83D\uDC40️ — Loading in progress...").queue();
                e.getChannel().sendMessage("__What is the type of your resource?__"+sb).queueAfter(4,TimeUnit.SECONDS, mess ->{
                    for (SubmissionType value : SubmissionType.values()) mess.addReaction(value.getEmoji()).queue();
                });
                return;
            }
            e.getChannel().sendMessage("Hey!\n\nIf you want to **submit a ressource**, just type `!submit` here.\n\n__What you will need__ ?\n» The title of the ressource\n» A short description of the ressource\n» The type of the ressource\n» A valid download link\n\nOnce this information has been sent, your resource will be in the process of being approved. If your leak is accepted, **you will be given a leak point**. Collect them to win cool stuff at the end of the month!").queue();
            return;
        }
    }
}

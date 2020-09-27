package fr.pablo.supersnail.trigger.core;

import com.sun.javafx.css.SubCssMetaData;
import fr.pablo.supersnail.Main;
import fr.pablo.supersnail.core.submissions.Submission;
import fr.pablo.supersnail.core.submissions.SubmissionType;
import fr.pablo.supersnail.core.submissions.SubmissionsHandler;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

public class MsgReact {
    public MsgReact(MessageReactionAddEvent e) {
        Long authorID = e.getUserIdLong();
        if (e.getUser().equals(e.getJDA().getSelfUser())) return;
        if(e.getChannel().getIdLong() == 759473920943980604L){
            if(!SubmissionsHandler.submissions.containsKey(e.getMessageIdLong())) return;
            Submission submission = SubmissionsHandler.submissions.get(e.getMessageIdLong());
            if(e.getReactionEmote().getEmoji().equalsIgnoreCase("✅")){
                SubmissionsHandler.submissions.remove(e.getMessageIdLong());
                SubmissionsHandler.submissionBuilder.remove(submission.getAuthorID());
                SubmissionsHandler.underSubmission.remove(submission.getAuthorID());
                e.getChannel().sendMessage("✅ — Submission **#"+submission.getId()+"** (by: <@"+submission.getAuthorID()+">) accepted! by **"+e.getUser().getAsTag()+"**").queue();
                e.getJDA().getUserById(submission.getAuthorID()).openPrivateChannel().queue((channel) ->{
                    channel.sendMessage("✅ — Request accepted, you can request the addition of a resource again.\n\n__Join our Discord to be considered as a **leaker**__: https://discord.gg/6UM7UcW").queue();
                });
                Main.broadcaster.broadcast("**Type**: "+submission.getSubmissionType().getEmoji() + " • " + submission.getSubmissionType().getDisplay() + "\n**Title**: `"+submission.getTitle()+"`\n\n**Desc**: "+submission.getDesc()+"\n\n**Download link**: "+submission.getDlLink() +"\n\n**Leak by**: "+submission.getAuthorTag());



            }
            if(e.getReactionEmote().getEmoji().equalsIgnoreCase("⛔")){
                SubmissionsHandler.submissions.remove(e.getMessageIdLong());
                SubmissionsHandler.submissionBuilder.remove(submission.getAuthorID());
                SubmissionsHandler.underSubmission.remove(submission.getAuthorID());
                e.getChannel().sendMessage("⛔ — Submission **#"+submission.getId()+"** (by: <@"+submission.getAuthorID()+">) denied! by **"+e.getUser().getAsTag()+"**").queue();
                e.getJDA().getUserById(submission.getAuthorID()).openPrivateChannel().queue((channel) ->{
                    channel.sendMessage("⛔ — Your request has been refused.\n\n__What happened ? (possibles reasons)__\n\n» Invalid download link provided\n» Invalid title or description\n» Title and descriptions must be english only\n\nIf you did everything correctly but your request was still denied, join our Discord: https://discord.gg/6UM7UcW").queue();
                });
            }


            return;
        }
        if(SubmissionsHandler.underSubmission.containsKey(authorID)){
            if(SubmissionsHandler.underSubmission.get(authorID) == 1){
                for (SubmissionType value : SubmissionType.values()){
                    if(e.getReactionEmote().getEmoji().equalsIgnoreCase(value.getEmoji())){
                        SubmissionsHandler.submissionBuilder.get(authorID).setSubmissionType(value);
                        SubmissionsHandler.underSubmission.put(authorID,2);
                        e.getChannel().sendMessage("✅ — The type of the resource has been saved.").queue();
                        e.getChannel().sendMessage("\uD83D\uDC40️ — Please type a title for the ressource.").queue();
                    }
                }
            }
        }
    }
}

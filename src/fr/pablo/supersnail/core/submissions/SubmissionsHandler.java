package fr.pablo.supersnail.core.submissions;

import fr.pablo.supersnail.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmissionsHandler {
    private static int count = 0;
    public static Map<Long,Integer> underSubmission = new HashMap<>();
    public static Map<Long,Submission> submissionBuilder = new HashMap<>();

    public static Map<Long,Submission> submissions = new HashMap<>();

    public static void submit(long id){
        count = count + 1;
        submissionBuilder.get(id).setId(count);
        Submission submission = submissionBuilder.get(id);
        Main.jda.getTextChannelById(759473920943980604L).sendMessage("**ID**: "+submission.getId()+"\n\n**Title**: `"+submission.getTitle()+"` by <@"+submission.getAuthorID()+"> ("+submission.getAuthorTag()+")\n\n**Desc**: "+submission.getDesc()+"\n\n**Download**: "+submission.getDlLink()).queue(message -> {
            submissions.put(message.getIdLong(),submission);
            message.addReaction("✅").queue();
            message.addReaction("⛔").queue();
        });
    }
}

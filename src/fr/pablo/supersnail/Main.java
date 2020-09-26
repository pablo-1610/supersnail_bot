package fr.pablo.supersnail;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    public static JDA jda;
    public static Map<Long, Long> userAndMessage = new HashMap<>();
    public static void main(String[] args) {
        try{
            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS);
            jda = new JDABuilder(AccountType.BOT).setToken("NzMwMTg0NTk2NDc3NTc1MjI2.XwTzZQ.jitn0Ay2iG4kOz-rP0SGlbhlKSI").setActivity(Activity.playing("DM for leak submission")).setHttpClientBuilder(httpBuilder).build();
            jda.setAutoReconnect(true);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}


package com.yuan.Tool;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FileName {
    public static String GetFileName() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String Time = df.format(time);
        String[] split = Time.split(":");
        String localTime="";
        for (int i = 0; i < split.length; i++) {
            localTime+=split[i];
        }
        localTime=localTime.replace(" ", "");
        String filename=randomNumber+localTime;
        return filename;
    }
}

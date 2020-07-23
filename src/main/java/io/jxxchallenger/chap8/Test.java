package io.jxxchallenger.chap8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    // private static Map<String, HashMap<String, HashMap<LocalDateTime, Email>>
    // emailMap = new HashMap<>();

    private static List<Email> emailList = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<Email> findEmails(String person, String theme,
            LocalDateTime date) {
        List<Email> result = null;
        result = emailList.parallelStream().filter((email) -> {
            return email.match(person, theme, date);
        }).collect(Collectors.toList());
        
        return result;
    }
}

class Email {
    private String thame;

    private LocalDateTime date;

    private String recivier;

    public String getThame() {
        return thame;
    }

    public void setThame(String thame) {
        this.thame = thame;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getRecivier() {
        return recivier;
    }

    public void setRecivier(String recivier) {
        this.recivier = recivier;
    }

    public boolean match(String person, String theme,
            LocalDateTime date) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        if(!this.recivier.equals(person)) {
            flag1 = false;
        }
        
        if(!this.thame.equals(theme)) {
            flag2 = false;
        }
        
        if(this.date != date) {
            flag3 = false;
        }
        
        return flag1 && flag2 && flag3;
    }
    // setter, getter
}

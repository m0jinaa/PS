import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String,String> database = new HashMap<>();
        
        for(String[] user : db){
            database.put(user[0],user[1]);
        }
        
        String answer = "login";
        
        if(!database.containsKey(id_pw[0])){
            answer = "fail";
        }
        else if(!database.get(id_pw[0]).equals(id_pw[1])){
            answer = "wrong pw";
        }
        
        return answer;
    }
}
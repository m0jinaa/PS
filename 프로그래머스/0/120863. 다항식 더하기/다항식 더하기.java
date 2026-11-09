import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String[] input = polynomial.split(" \\+ ");
        
        int a = 0;
        int b = 0;
        
        String c;
        
        for(String s : input){
            if(s.indexOf("x") != -1){
                c = s.replaceAll("x","");
                
                if("".equals(c)){
                    a++;
                }
                else{
                    a+=Integer.parseInt(c);
                    
                }
            }else{
                b+=Integer.parseInt(s);
            }
        }
        
        String answer= "";
        
        if(a!=0){
            if(a !=1){
                answer+=a;
            }
            answer+="x";
            
            if(b!=0){
                answer+=" + "+b;
            }
            
            
        }
        else{
            answer+=b;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        LinkedList<String> spo = new LinkedList<>();
        Set<String> revealed = new HashSet<>();
        
        char[] word = message.toCharArray();
        
        int n = word.length;
        
        boolean[] blur = new boolean[n];
        
        
        for(int[] range : spoiler_ranges){
            for(int s = range[0];s<=range[1];s++){
                blur[s] = true;
            }
        }

        String w = "";
        
        boolean s = false;
        
        for(int i = 0;i<n;i++){
            if(word[i] == ' '){
                if(w.equals("")){
                    continue;
                }
                if(s){
                    spo.add(w);
                }
                else{
                    revealed.add(w);
                }
                s = false;
                w = "";
            }
            else{
                w+=word[i];
                if(blur[i]){
                    s = true;
                }
            }
        }
        
        if(!w.equals("")){
            if(s){
                spo.add(w);
            }
            else{
                revealed.add(w);
            }
        }
        
        String c;
        
        while(!spo.isEmpty()){
            c = spo.poll();
            
            if(!revealed.contains(c)){
                revealed.add(c);
                answer++;
            }
        }        
        
        return answer;
    }
}
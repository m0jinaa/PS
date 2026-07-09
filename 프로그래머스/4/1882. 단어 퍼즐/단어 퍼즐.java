import java.util.*;

class Solution {
    class Word{
        int ind, c;
        
        public Word(int ind, int c){
            this.ind = ind;
            this.c = c;
        }
    }
    
    public int solution(String[] strs, String t) {
        int answer = -1;
        
        LinkedList<Word> q = new LinkedList<>();
        
        q.add(new Word(0,0));
        
        Word now;
        
        int n = t.length();
        
        int l;
        
        boolean[] made = new boolean[n];
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(now.ind == n){
                answer = now.c;
                break;
            }
            
            for(String s : strs){
                l = s.length();
                
                if(l>n-now.ind){
                    continue;
                }
                else if(!s.equals(t.substring(now.ind,now.ind+l))){
                    continue;
                }
                else if(made[now.ind+l-1]){
                    continue;
                }
                made[now.ind+l-1] = true;
                q.add(new Word(now.ind+l,now.c+1));
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public class Word{
        String w;
        int d;
        
        public Word(String w, int d){
            this.w = w;
            this.d = d;
        }
    }  
    
    public boolean canMake(String a, String b){
        int n = a.length();
        
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        
        int diff = 0;
        
        for(int i = 0;i<n;i++){
            if(A[i] !=B[i])
                diff++;
        }
        
        return diff==1;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int n = words.length;
        
        Set<String> visited = new HashSet<>();
        
        LinkedList<Word> q = new LinkedList<>();
        
        q.add(new Word(begin,0));
        visited.add(begin);
        
        Word word;
        
        while(!q.isEmpty()){
            word = q.poll();
            
            if(target.equals(word.w)){
                answer = word.d;
                break;
            }
            
            for(int i = 0;i<n;i++){
                if(visited.contains(words[i]) || !canMake(word.w,words[i])){
                    continue;
                }
                visited.add(words[i]);
                q.add(new Word(words[i],word.d+1));
            }
        }
        
        return answer;
    }
}
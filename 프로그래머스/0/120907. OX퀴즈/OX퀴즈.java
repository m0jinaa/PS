import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        
        int n = quiz.length;
        
        String[] answer = new String[n];
        
        StringTokenizer st;
        
        int x,y,z;
        String o;
        
        boolean correct;
        for(int i = 0;i<n;i++){
            correct = true;
            
            st = new StringTokenizer(quiz[i]," =");
            
            x = Integer.parseInt(st.nextToken());
            o = st.nextToken();
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            
            if("+".equals(o)){
                if(x+y!=z){
                    correct = false;
                }
            }
            else{
                if(x-y !=z){
                    correct = false;
                }
            }
            
            answer[i] = correct?"O":"X";
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    int[] infos;
    int[] arrow;
    int[] answer;
    int diff;
    boolean found;
    
    void combi(int c, int x){
        if(c == 0 || x == -1){
            int a = 0;
            int p = 0;
            
            for(int i = 0;i<10;i++){
                if(infos[i] !=0 && infos[i]==arrow[i]){
                    a+=(10-i);
                }
                else if(infos[i]<arrow[i]){
                    p+=(10-i);
                }
                else if(infos[i]>arrow[i]){
                    a+=(10-i);
                }
            }
            
            if(p>a && p-a>diff){
                found = true;
                for(int i = 0;i<10;i++){
                    answer[i] = arrow[i];
                }
                answer[10] = c;
                diff = p-a;
            }
        }
        else{
            if(c > infos[x]){
                arrow[x] = infos[x]+1;
                
                combi(c-(infos[x]+1),x-1);

                arrow[x] = 0;
            }
            
            combi(c,x-1);
        }
    }
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        arrow = new int[11];
        infos = info;
        found = false;
        
        diff = -1;
        
        combi(n,9);
        
        
        return found?answer:new int[]{-1};
    }
}
import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        LinkedList<Integer> height = new LinkedList<>();
        LinkedList<Integer> size = new LinkedList<>();
        
        int now = k;
        height.add(k);
        size.add(0);
        
        while(now!=1){
            if(now%2==0){
                now/=2;
            }
            else{
                now = now*3+1;
            }
            
            size.add(size.peekLast()+now+height.peekLast());
            height.add(now);
        }
        
        int n = height.size()-1;
        
        int[] total = size.stream().mapToInt(Integer::intValue).toArray();
        
        int q = ranges.length;
        
        double[] answer = new double[q];
        
        double space;
        int s, e;
        
        for(int i = 0;i<q;i++){
            s = ranges[i][0];
            e = n+ranges[i][1];
            
            if(s > e){
                space = -1;
            }
            else{
                space = (total[e]-total[s])*1.0/2;
            }
            
            answer[i] = space;
        }
        
        return answer;
    }
}
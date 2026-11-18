import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 2;i<=n;i++){
            if(n % i == 0){
                while(n%i == 0){
                    n/=i;
                }
                
                list.add(i);
            }
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
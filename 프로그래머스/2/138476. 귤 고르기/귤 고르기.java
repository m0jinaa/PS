import java.util.*;

class Solution {
    public int ind = 0;
    public Map<Integer,Integer> map;
    public int getInd(int x){
        if(!map.containsKey(x)){
            map.put(x,ind++);
        }
        
        return map.get(x);
    }
    
    public int solution(int k, int[] tangerine) {
        
        final int MAX = 100_000;
        
        map = new HashMap<>();
        int[] cnt = new int[MAX];
        
        int index;
        
        for(int t : tangerine){
            index = getInd(t);
            cnt[index]++;
        }
        
        Arrays.sort(cnt);
        
        int total = 0;
        int answer = 0;
            
        for(int i = MAX-1;i>=0 && total<k;i--){
            answer++;
            total+=cnt[i];
        }
        
        return answer;
    }
}
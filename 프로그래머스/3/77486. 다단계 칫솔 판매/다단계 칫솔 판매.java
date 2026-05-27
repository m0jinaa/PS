import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        int[] answer = new int[n];
        
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i = 0;i < n;i++){
            indexMap.put(enroll[i],i);
        }

        int m = seller.length;
        
        int now;
        int give;
        int earn;
        
        for(int i = 0;i<m;i++){
            earn = amount[i]*100;
            now = indexMap.getOrDefault(seller[i],-1);
            
            while(now!=-1 && earn > 0){
                give = earn/10;
                earn-=give;
                answer[now]+=earn;
                earn = give;
                now = indexMap.getOrDefault(referral[now],-1);
            }
        }
        
        return answer;
    }
}
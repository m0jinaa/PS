import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;

        int[][] record = new int[n][n];
        int[] giftPoint = new int[n];
        
        Map<String, Integer> indMap = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            indMap.put(friends[i],i);
        }
        
        String[] row;
        
        int a,b;
        
        for(String gift : gifts){
            row = gift.split(" ");
            
            a = indMap.get(row[0]);
            b = indMap.get(row[1]);
            
            record[a][b]++;
            giftPoint[a]++;
            giftPoint[b]--;
        }
        
        int c;
        
        for(int i = 0;i<n;i++){
            c = 0;
            for(int j = 0;j<n;j++){
                if(i == j){
                    continue;
                }
                else if(record[i][j]>record[j][i]){
                    c++;
                }
                else if(record[i][j] == record[j][i] && giftPoint[i]>giftPoint[j]){
                    c++;
                }
            }
            
            answer = Math.max(answer,c);
        }
        
        return answer;
    }
}
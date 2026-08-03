import java.util.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        
        int n = id_list.length;
        
        boolean[][] reported = new boolean[n][n];
        int[] totalReport = new int[n];
        
        Map<String, Integer> indMap = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            indMap.put(id_list[i],i);
        }
        
        String[] row;
        
        int a,b;
        
        for(String r : report){
            row = r.split(" ");
            a = indMap.get(row[0]);
            b = indMap.get(row[1]);
            
            if(reported[a][b]){
                continue;
            }
            reported[a][b] = true;
            totalReport[b]++;
        }

        int[] answer = new int[n];
        
        for(int i = 0;i<n;i++){
            if(totalReport[i]<k){
                continue;
            }
            for(int j = 0;j<n;j++){
                if(!reported[j][i]){
                    continue;
                }
                answer[j]++;
            }
        }
        
        return answer;
    }
}
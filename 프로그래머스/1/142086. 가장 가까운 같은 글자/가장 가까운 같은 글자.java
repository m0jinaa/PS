import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] row = s.toCharArray();
        
        int[] loc = new int[26];
        
        Arrays.fill(loc,-1);
        
        int n = row.length;
        
        int[] answer = new int[n];
        
        for(int i = 0;i<n;i++){
            answer[i] = (loc[row[i]-'a'] == -1)? -1:(i - loc[row[i]-'a']);

            loc[row[i]-'a'] = i;
        }
        
        return answer;
    }
}
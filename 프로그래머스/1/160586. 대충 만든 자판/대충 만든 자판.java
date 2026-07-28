import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] key = new int[26];
        
        final int INF = 2_000_000;
        
        Arrays.fill(key,INF);
        
        char[] arr;
        
        int n;
        
        for(String k : keymap){
            arr = k.toCharArray();
            n = arr.length;
            
            for(int i = 0;i<n;i++){
                key[arr[i]-'A'] = Math.min(key[arr[i]-'A'],i+1);        
            }
        }
        
        int[] answer = Arrays.stream(targets)
            .mapToInt((String target) -> target.chars()
                      .map(c -> key[c - 'A']).sum())
            .map((int x) -> (x >= INF) ? -1 : x)
            .toArray();
        
        return answer;
    }
}
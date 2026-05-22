import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
                
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int n = str1.length();
        int m = str2.length();
        
        char[] A = str1.toCharArray();
        char[] B = str2.toCharArray();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        String w;
        
        int total = 0;
        
        for(int i = 0; i < n - 1; i++){
            if(A[i] < 'a' || A[i] > 'z' || A[i+1] < 'a' || A[i+1] > 'z'){
                continue;
            }
            w = ""+A[i]+A[i+1];

            map.put(w,map.getOrDefault(w,0)+1);
            total++;
        }
        
        int common = 0;
        
        int c;
        
        for(int i = 0; i < m - 1; i++){
            if(B[i] < 'a' || B[i] > 'z' || B[i+1] < 'a' || B[i+1] > 'z'){
                continue;
            }
                        
            w = ""+B[i]+B[i+1];
            
            c = map.getOrDefault(w,0);
            
            if(c > 0){
                common++;
                map.put(w,c-1);
            }
            else{
                total++;
            }
        }
        
        int answer;
        
        if(total != 0){
            answer = 65536 * common / total;
        }
        else{
            answer = 65536;
        }
        return answer;
    }
}
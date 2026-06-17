import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        
        int a = 0;
        int b = 0;
        
        while(a<n && b<n){
            if(A[a]<B[b]){
                answer++;
                a++;
                b++;
            }
            else{
                b++;
            }
        }
        
        return answer;
    }
}
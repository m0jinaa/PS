import java.util.*;

class Solution {
    int N,M,dest;
    int[] rock;
    
    boolean check(int x){
        int bef = 0;
        int destroyed = 0;
        
        for(int i = 0;i < M;i++){
            if(rock[i]-bef<x){
                destroyed++;
            }
            else{
                bef = rock[i];
            }
        }
        
        if(dest-bef<x){
            destroyed++;
        }
        
        return destroyed <= N;
    }
    public int solution(int distance, int[] rocks, int n) {
        
        int answer = 0;
        
        rock = rocks;
        Arrays.sort(rock);
        
        dest = distance;
        N = n;
        M = rocks.length;
        
        int s = 1;
        int e = distance;
        
        int mid;
        
        while(s <= e){
            mid = (s+e)/2;
            
            if(check(mid)){
                answer = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        
        return answer;
    }
}
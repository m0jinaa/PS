import java.util.*;

class Solution {
    int N;
    int[] core;
    
    boolean isPossible(int time){
        int cnt = 0;
        
        for(int c: core){
            cnt+=Math.ceil(time*1.0/c);
        }
        
        return cnt<N;
    }
    public int solution(int n, int[] cores) {
        N = n;
        core = cores;
        
        int s = 0;
        int e = 250_000_000;
        
        int t = -1;
        
        int mid;
        
        while(s<=e){
            mid = (s+e)/2;
            
            if(isPossible(mid)){
                s = mid+1;
                t = mid;
            }
            else{
                e = mid-1;
            }
        }
        
        int cnt = 0;
        
        for(int c : cores){
            cnt+=(int)Math.ceil(t*1.0/c);
        }
        
        int m = cores.length;
        
        int answer = -1;
        
        end : while(cnt<n){
            for(int i = 0;i<m;i++){
                if(t%cores[i] == 0){
                    cnt++;
                }
                
                if(cnt == n){
                    answer = i+1;
                    break end;
                }
            }  
            t++;
        }
        
        return answer;
        
    }
}
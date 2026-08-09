
import java.util.*;

class Solution {
    int MAX = 10_000_000;
    int n;
    boolean[] made;
    boolean[] isPrime;
    boolean[] used;
    int[] nums;
    
    void init(){
        isPrime = new boolean[MAX];
        made = new boolean[MAX];
        
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2;i<MAX;i++){
            if(!isPrime[i] || i >= 4000){
                continue;
            }
            
            for(int j = i*i;j<MAX;j+=i){
                isPrime[j] = false;
            }
        }
    }

    int combi(int x){
        int ret = 0;
        
        if(isPrime[x] && !made[x]){
            made[x] = true;
            ret++;
        }
        
        int nx;
        
        for(int i = 0;i<n;i++){
            if(used[i] || (x == 0 && nums[i] == 0)){
                continue;
            }
            
            nx = x*10+nums[i];
            
            used[i] = true;
            ret += combi(nx);
            used[i] = false;
        }
        
        return ret;
    }
    public int solution(String numbers) {
    
        init();
                
        char[] input = numbers.toCharArray();
                
        n = input.length;
    
        nums = new int[n];
        used = new boolean[n];
        
        for(int i = 0;i<n;i++){
            nums[i] = input[i]-'0';
        }
        
        int answer = combi(0);
        
        return answer;
    }
}
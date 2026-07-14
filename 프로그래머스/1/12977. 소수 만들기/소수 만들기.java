import java.util.Arrays;

class Solution {
    
    final int MAX = 3000;
    boolean[] isPrime;
    int[] numbers;
    int n;
    
    void init(){
        isPrime = new boolean[MAX];
        Arrays.fill(isPrime,true);
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2;i<MAX;i++){
            if(!isPrime[i])
                continue;
            for(int j = i*i;j<MAX;j+=i){
                isPrime[j] = false;
            }
        }
    }
    
    int countPrime(int ind, int c, int sum){
        if(c == 3){
            return isPrime[sum]?1:0;
        }
        else if(ind == n){
            return 0;
        }
        else{
            return countPrime(ind+1,c,sum)+countPrime(ind+1,c+1,sum+numbers[ind]);
        }
    }
    
    public int solution(int[] nums) {
        
        init();
        
        numbers = nums;
        n = nums.length;
        
        int answer = countPrime(0,0,0);
        
        return answer;
    }
}
class Solution {
    final int MOD = 1_234_567;
    int[] fibo;
    int getFibo(int x){
        fibo = new int[x+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2;i <= x;i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;
        }
        
        return fibo[x];
    }
    
    public int solution(int n) {
        int answer = getFibo(n);
        
        return answer;
    }
}
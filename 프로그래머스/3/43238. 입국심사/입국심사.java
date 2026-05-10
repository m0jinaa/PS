class Solution {
    int N;
    int[] time;
    
    boolean isPossible(long x){
        long c = 0;
        for(int t : time){
            c += (x / (1L*t));
        }
        
        return c >= N;
    }
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        N = n;
        time = times;
        
        long s = 1L;
        long e = 1_000_000_000_000_000_000L;
        
        long mid;
        
        //이분탐색으로 mid시간만에 모든 사람이 다 심사를 받을 수 있는지 체크
        while(s <= e){
            mid = (s + e) / 2;
            
            if(isPossible(mid)){
                answer = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        
        return answer;
    }
}
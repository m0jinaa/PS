class Solution {
    int n;
    long lim;
    int[] diff;
    int[] time;
    
    boolean checkTime(int x){
        long t = 0;
        long delay;
        
        for(int i = 0;i<n;i++){
            t+=time[i];
            if(x<diff[i]){
                delay = 1L*(diff[i]-x)*(time[i]+time[i-1]);
                t+=delay;
            }
            
            if(t>lim){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        n = diffs.length;
        diff = diffs;
        time = times;
        lim = limit;
        
        final int MAX = 100_000;
        
        int answer = 0;
        
        int s = 1;
        int e = MAX;
        
        int mid;
        
        while(s<=e){
            mid = (s+e)/2;
            
            if(checkTime(mid)){
                answer = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        
        return answer;
    }
}
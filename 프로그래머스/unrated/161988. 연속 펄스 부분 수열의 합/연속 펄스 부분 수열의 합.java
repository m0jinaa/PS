class Solution {
    public long solution(int[] sequence) {
        
        int n = sequence.length;
        
        for(int i = 1;i<n;i+=2){
            sequence[i]*=-1;
        }
        
        long[] maxDp = new long[n];
        long[] minDp = new long[n];
        long max,min;
        
        max = min = maxDp[0] = minDp[0] = sequence[0];
        
        for(int i = 1;i<n;i++){
            maxDp[i] = Math.max(maxDp[i-1],0)+sequence[i];
            max = Math.max(maxDp[i],max);
        }
        for(int i = 1;i<n;i++){
            minDp[i] = Math.min(minDp[i-1],0)+sequence[i];
            min = Math.min(minDp[i],min);
        }
        
        long answer = Math.max(Math.abs(min),Math.abs(max));
        
        return answer;
    }
}
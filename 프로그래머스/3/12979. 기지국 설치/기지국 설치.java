class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int s = 1;
        
        int l;
        
        int size = 2*w+1;
        
        for(int station : stations){
            if(s<station-w){
                l = station-w-s;
                        
                answer+=(int)Math.ceil(l*1.0/size);
            }
            s = station+w+1;
        }
        
        if(s<=n){
            l = n-s+1;
            
            answer += (int)Math.ceil(l*1.0/size);
        }
        
        
        return answer;
    }
}
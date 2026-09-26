class Solution {
    public int[] solution(long begin, long end) {
        int l = (int)(end-begin+1);
        
        int[] answer = new int[l];
        
        int s;
        
        for(int i = 1;i*2<=end;i++){
            s = Math.max(i*2,(int)Math.ceil(begin*1.0/i)*i);
            
            while(s<=end){
                answer[(int)(s-begin)] = i;
                s+=i;
            }
        }
        
        return answer;
    }
}
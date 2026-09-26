class Solution {
    int getDivider(long x){
        int ret = 1;
        
        int limit = (int)Math.sqrt(x);
        
        for(int i = 2;i<=limit;i++){
            if(x%i == 0){
                if(x/i>10000000){
                    ret = Math.max(ret,i);
                }
                else{
                    ret = (int)(x/i);
                    break;
                }
            }
        }
        
        return x == 1?0:ret;
    }
    
    public int[] solution(long begin, long end) {
        int l = (int)(end-begin+1);
        
        int[] answer = new int[l];
        
        for(int i = 0;i<l;i++){
            answer[i] = getDivider(begin+i);
        }
        
        return answer;
    }
}
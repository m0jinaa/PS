class Solution {
    public int[] solution(int[] sequence, int k) {
    
        int n = sequence.length;
        
        int start = 0;
        int end = n;
        
        int s = 0;
        int e = 0;
        
        int sum = sequence[0];
        
        while(e<n && s<=e){
            if(sum<k){
                if(e+1<n){
                    sum+=sequence[++e];
                }
                else{
                    break;
                }
            }
            else if(sum>k){
                sum-=sequence[s++];
            }
            else{
                if(e-s+1 < end-start+1){
                    start = s;
                    end = e;
                }
                sum-=sequence[s++];
                if(e+1<n){
                    sum+=sequence[++e];
                }
                else{
                    break;
                }
            }
        }
        
        int[] answer = new int[]{start, end};
        return answer;
    }
}
class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
        
        int now = 0;
        
        char[] input = s.toCharArray();
        int n = input.length;
        
        for(int i = 0;i<n;i++){
            if(input[i] == '0'){
                zero++;
            }
            else{
                now++;
            }
        }
        
        cnt++;
        
        int next;
        
        while(now != 1){
            //이진 변환횟수 증가
            cnt++;
            
            next = 0;
            
            //이진법으로 표현했을 때 0개수와 1개수 세기
            while(now > 0){
                if(now % 2 == 0){
                    zero++;
                }
                else{
                    next++;
                }
                
                now /= 2;
            }
            
            now = next;
        }
        
        int[] answer = new int[]{cnt, zero};
        
        return answer;
    }
}
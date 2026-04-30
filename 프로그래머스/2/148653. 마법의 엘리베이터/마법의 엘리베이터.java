class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int x;
        
        while(storey >0){
            x = storey%10;
            storey/=10;
            if(x<5){
                answer+=x;

            }
            else if(x>5){
                answer+=(10-x);
                storey++;
            }
            else{
                answer+=x;
                if(storey%10 >= 5){
                    storey++;
                }
            }
        }
        
        return answer;
    }
}
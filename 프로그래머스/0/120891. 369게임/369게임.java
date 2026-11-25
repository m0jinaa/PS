class Solution {
    public int solution(int order) {
        int answer = 0;
        
        int x;
        
        while(order>0){
            x = order%10;
            
            if(x!=0 && x%3 == 0){
                answer++;
            }
            
            order/=10;
        }
        
        return answer;
    }
}
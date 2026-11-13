class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        int service;
        
        while(chicken>=10){
            service = chicken/10;
            answer += service;
            
            chicken = service + chicken%10;
        }
        
        return answer;
    }
}
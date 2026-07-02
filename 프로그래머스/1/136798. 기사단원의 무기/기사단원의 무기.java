class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int c = 0;
        
        for(int i = 1;i<=number;i++){
            c = 0;
            
            for(int j = 1;j<=i;j++){
                if(i%j == 0){
                    c++;
                }
            }
            if(c>limit){
                answer+=power;
            }
            else{
                answer+=c;
            }
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int a,b;
        
        a = sides[0];
        b = sides[1];
        
        if(a>b){
            int t = a;
            a = b;
            b = t;
        }
        
        for(int i = 1;i<a+b;i++){
            if(i<b){
                if(b<a+i){
                    answer++;
                }
            }
            else if(i<a+b){
                answer++;
            }
        }
        
        return answer;
    }
}
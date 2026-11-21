class Solution {
    public int solution(int[] array) {
        int answer = 0;
            
        for(int x : array){
            while(x>0){
                if(x%10 == 7){
                    answer++;
                }
                x/=10;
            }
        }
        return answer;
    }
}
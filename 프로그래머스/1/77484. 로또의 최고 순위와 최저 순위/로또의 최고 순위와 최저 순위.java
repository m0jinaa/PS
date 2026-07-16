class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero = 0;
        int right = 0;
        boolean[] lotto = new boolean[46];
        
        for(int w : win_nums){
            lotto[w] = true;
        }
        
        for(int t : lottos){
            if(lotto[t]){
                right++;
            }
            else if(t == 0){
                zero++;
            }
        }
        
        int[] answer = new int[]{(right + zero) < 2 ? 6 : (7 - (right + zero)), right < 2 ? 6 : (7 - right)};        
        return answer;
    }
}
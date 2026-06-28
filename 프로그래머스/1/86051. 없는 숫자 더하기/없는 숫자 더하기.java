class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        
        boolean[] exists = new boolean[10];
        
        for(int n : numbers){
            if(exists[n]){
                continue;
            }
            else{
                exists[n] = false;
                answer -= n;
            }
        }
        
        return answer;
    }
}
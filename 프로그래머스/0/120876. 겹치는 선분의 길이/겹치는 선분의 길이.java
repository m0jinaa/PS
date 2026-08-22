class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        final int ADJUSTMENT = 100;
        
        int[] exists = new int[201];
        
        for(int[] line : lines){
            for(int s = line[0];s<line[1];s++){
                exists[s+ADJUSTMENT]++;
            }
        }
        
        for(int i = 0;i<201;i++){
            if(exists[i] >1){
                answer++;
            }
        }
        return answer;
    }
}
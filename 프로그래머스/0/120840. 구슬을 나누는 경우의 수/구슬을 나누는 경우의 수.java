class Solution {
    final int MAX = 30;
    int[][] combi;
    
    void init(){
        combi = new int[MAX+1][MAX+1];
        
        combi[0][0] = 1;
        
        for(int i = 0;i<MAX;i++){
            for(int j = 0;j<=i;j++){
                combi[i+1][j]+=combi[i][j];
                combi[i+1][j+1]+=combi[i][j];
            }
        }
    }
    public int solution(int balls, int share) {
        
        init();
        
        return combi[balls][share];
    }
}
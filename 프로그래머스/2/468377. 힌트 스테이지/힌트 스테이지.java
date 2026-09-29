class Solution {
    int n,k;
    int[][] hints;
    int[] hintCount;
    int[][] costs;
    
    int getMinCost(int x){
        if(x == n){
            return 0;
        }
        
        int stageCost = costs[x][Math.min(n-1,hintCount[x])];
        
        //힌트번들 안사
        int nextStage = getMinCost(x+1);
        
        int min = stageCost+nextStage;
        
        //힌트번들 사
        if(x+1<n){
            
            for(int i = 1;i<=k;i++){
                hintCount[hints[x][i]-1]++;
            }
            
            min = Math.min(min,stageCost+hints[x][0]+getMinCost(x+1));
            
            for(int i = 1;i<=k;i++){
                hintCount[hints[x][i]-1]--;
            }
        }
        
        return min;
        
    }
    public int solution(int[][] cost, int[][] hint) {
        
        n = cost.length;
        k = hint[0].length-1;
        
        costs = cost;
        hints = hint;
        hintCount = new int[n];
        
        int answer = getMinCost(0);
        
        return answer;
    }
}
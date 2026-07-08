class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] uniform = new int[n+1];
        
        for(int x : lost){
            uniform[x]--;
        }
        
        for(int x : reserve){
            uniform[x]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(uniform[i] >= 0){
                continue;
            }
            else if(uniform[i - 1] > 0){
                uniform[i - 1]--;
                uniform[i]++;
            }
            else if(i < n && uniform[i + 1] > 0){
                uniform[i + 1]--;
                uniform[i]++;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(uniform[i] >= 0){
                answer++;
            }
        }
        
        return answer;
    }
}
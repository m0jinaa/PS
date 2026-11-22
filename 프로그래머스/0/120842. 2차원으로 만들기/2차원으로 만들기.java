class Solution {
    public int[][] solution(int[] num_list, int n) {
        int c = num_list.length;
        int m = c/n;
        
        int[][] answer = new int[m][n];
        
        int x,y;
        
        for(int i = 0;i<c;i++){
            x = i/n;
            y = i%n;
            
            answer[x][y] = num_list[i];
        }
        
        return answer;
    }
}
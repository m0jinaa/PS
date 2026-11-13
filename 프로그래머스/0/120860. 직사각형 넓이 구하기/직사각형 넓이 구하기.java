class Solution {
    public int solution(int[][] dots) {
        
        final int INF = 257;
        
        int sx = INF;
        int sy = INF;
        int ex = -INF;
        int ey = -INF;

        
        for(int[] dot : dots){
            sx = Math.min(sx,dot[0]);
            sy = Math.min(sy,dot[1]);
            ex = Math.max(ex,dot[0]);
            ey = Math.max(ey,dot[1]);
        }

        int answer = (ex-sx)*(ey-sy);
        
        return answer;
    }
}
class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 51;
        int minY = 51;
        int maxX = -1;
        int maxY = -1;
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        char[][] map = new char[n][];
        
        for(int i = 0;i<n;i++){
            map[i] = wallpaper[i].toCharArray();
            for(int j = 0;j<m;j++){
                if(map[i][j] != '#'){
                    continue;
                }
                
                minX = Math.min(minX,i);
                minY = Math.min(minY,j);
                maxX = Math.max(maxX,i+1);
                maxY = Math.max(maxY,j+1);
            }
        }
        
        return new int[]{minX, minY, maxX,maxY};
    }
}
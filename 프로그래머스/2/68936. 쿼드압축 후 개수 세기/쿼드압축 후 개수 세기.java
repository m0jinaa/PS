class Solution {
    int[][] map;
    int[] count;
    
    void check(int x, int y, int d){
        boolean same = true;
        
        end :for(int i = 0;i<d;i++){
            for(int j = 0;j<d;j++){
                if(map[x+i][y+j]!=map[x][y]){
                    same = false;
                    break end;
                }
            }
        }
        
        if(same){
            count[map[x][y]]++;
        }
        else{
            int nd = d/2;
            
            check(x,y,nd);
            check(x+nd,y,nd);
            check(x,y+nd,nd);
            check(x+nd,y+nd,nd);
        }
    }
    public int[] solution(int[][] arr) {
        map = arr;
        int n = arr.length;
        
        count = new int[2];
        
        check(0,0,n);
        
        return count;
    }
}
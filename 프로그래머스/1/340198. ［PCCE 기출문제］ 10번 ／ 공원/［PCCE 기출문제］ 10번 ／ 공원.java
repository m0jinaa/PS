class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int n = park.length;
        int m = park[0].length;
        
        int limit;
        
        int possible = -1;
        
        boolean p;
        int max;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!park[i][j].equals("-1")){
                    continue;
                }        
                
                limit = Math.min(m-j,n-i);
                
                max = 0;
                
                for(int k = 0;k<limit;k++){
                    p = true;
                    for(int a = 0;a<k;a++){
                        if(!park[i+k][j+a].equals("-1") ||!park[i+a][j+k].equals("-1")){
                            p = false;
                            break;
                        }
                    }
                    
                    if(p){
                        max = k+1;
                    }
                    else{
                        break;
                    }
                }
                
                possible = Math.max(possible,max);
            }
        }
        
        int answer = -1;
        
        for(int mat : mats){
            if(mat<=possible){
                answer = Math.max(mat,answer);
            }
        }
        
        return answer;
    }
}
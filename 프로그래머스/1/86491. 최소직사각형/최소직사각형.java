class Solution {
    public int solution(int[][] sizes) {
        
        int big = 0;
        int small = 0;
        
        int a,b;
        
        for(int[] size : sizes){
            if(size[0]<size[1]){
                a = size[0];
                b = size[1];
            }    
            else{
                a = size[1];
                b = size[0];
            }
            
            big = Math.max(big,b);
            small = Math.max(small,a);
        }
        
        int answer = big * small;
        
        return answer;
    }
}
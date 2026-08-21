class Solution {
    public int solution(int[][] dots) {
        boolean parelle = false;
        
        if((dots[0][0]-dots[1][0])*(dots[2][1]-dots[3][1]) == (dots[0][1]-dots[1][1])*(dots[2][0]-dots[3][0])){
            parelle = true;
        }
        else if((dots[0][0]-dots[2][0])*(dots[1][1]-dots[3][1]) == (dots[0][1]-dots[2][1])*(dots[1][0]-dots[3][0])){
            parelle = true;
        }
        else if((dots[0][0]-dots[3][0])*(dots[1][1]-dots[2][1]) == (dots[0][1]-dots[3][1])*(dots[1][0]-dots[2][0])){
            parelle = true;
        }
        
        return parelle?1:0;
    }
}
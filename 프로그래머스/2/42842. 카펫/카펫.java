class Solution {
    public int[] solution(int brown, int yellow) {
        int w = 0, h = 0;
        
        int total = brown+yellow;
        
        //가로,세로 둘 다 최소 3이상
        int limit = total / 3;
        
        int y;
        
        //x:세로, y:가로
        for(int x = 3; x<=limit;x++){
            if(total % x != 0){
                continue;
            }
            y = total/x;
            
            if(x>y){
                break;
            }
            
            if(2*x+2*y-4 == brown){
                w = y;
                h = x;
                break;
            }
            
        }
        int[] answer = new int[]{w,h};
        
        return answer;
    }
}
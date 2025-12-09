class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int way = (num-1)%2;
        
        int d = num % w;
        
        int left,right;
        
        right = ((w-d)%w)*2+1;
        left = 2*w-right;            
        
        if(way == 1){
            int temp = right;
            right = left;
            left = temp;
        }
        
        int now = num;        
        
        while(now <= n){
            if(way == 0){
                now += right;
            }
            else{
                now += left;
            }
            answer++;
            way = 1 - way;
        }
        
        return answer;
    }
}
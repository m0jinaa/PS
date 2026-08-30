class Solution {
    public int solution(int[] array) {
        int[] count = new int[1001];
        
        int max = 0;
        int maxCnt = 0;
        
        for(int x : array){
            count[x]++;
            if(count[x] == maxCnt){
                max = -1;
            }
            else if(count[x]>maxCnt){
                maxCnt = count[x];
                max = x;
            }
        }
        
        return max;
    }
}
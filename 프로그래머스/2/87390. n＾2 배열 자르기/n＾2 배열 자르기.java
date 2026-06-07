class Solution {
    public int[] solution(int n, long left, long right) {
        int m = (int)(right - left + 1);
        
        int[] answer = new int[m];
        
        int r,c;
        
        for(int i = 0;i < m;i++){
            r = (int)((i + left) / n);
            c = (int)((i + left) % n);
            answer[i] = Math.max(r, c) + 1;
        }
        
        return answer;
    }
}
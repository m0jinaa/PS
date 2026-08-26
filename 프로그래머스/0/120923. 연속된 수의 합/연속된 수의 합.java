class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int s = (int)Math.ceil(total*1.0/num) - num/2;
        
        for(int i = 0;i<num;i++){
            answer[i] = s++;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        
        char[] number = (""+num).toCharArray();
        int n = number.length;
        
        for(int i = 0;i<n;i++){
            if(number[i]-'0' == k){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
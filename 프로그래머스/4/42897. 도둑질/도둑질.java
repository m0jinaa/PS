class Solution {
    public int solution(int[] money) {
        
        int n = money.length;
        
        int[] first = new int[n];
        int[] second = new int[n];
        
        first[0] = money[0];
        first[1] = Math.max(money[0],money[1]);
        second[1] = money[1];
        
        for(int i = 2;i<n;i++){
            first[i] = Math.max(first[i-2]+money[i],first[i-1]);
            second[i] = Math.max(second[i-2]+money[i],second[i-1]);
        }
        
        int answer = Math.max(first[n-2],second[n-1]);
        
        return answer;
    }
}
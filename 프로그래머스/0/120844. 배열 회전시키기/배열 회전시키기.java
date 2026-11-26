class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        int n = numbers.length;
        int d = "left".equals(direction)?1:-1;
        
        int[] answer = new int[n];
        
        int ind;
        
        for(int i = 0;i<n;i++){
            ind = (i+d+n)%n;
            answer[i] = numbers[ind];
        }
        return answer;
    }
}
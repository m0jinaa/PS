class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        
        int[] answer = new int[n];
        int[] next = new int[n];
        
        answer[n-1] = -1;
        
        next[n-1] = -1;
        
        int nx;
        
        for(int i = n-2;i>=0;i--){
            nx = i+1;
            
            while(nx !=-1 && numbers[nx] <= numbers[i]){
                nx = next[nx];
            }
            
            if(nx == -1){
                answer[i] = -1;
            }
            else{
                answer[i] = numbers[nx];
            }
            
            next[i] = nx;
        }
        
        return answer;
    }
}
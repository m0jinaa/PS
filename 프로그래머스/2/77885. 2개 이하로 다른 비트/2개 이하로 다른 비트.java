class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        
        long[] answer = new long[n];
        long smallest;
        long biggest;
        long t;
        
        for(int i = 0;i<n;i++){
            if((numbers[i] % 2) == 0 || (numbers[i] & 2) == 0){
                answer[i] = numbers[i]+1;
            }
            else{
                smallest = 0;
                biggest = 0;
                
                int ind = 2;
                
                while((numbers[i] & (1L<<ind)) != 0){
                    ind++;
                }
                
                answer[i] = numbers[i]+(1L<<ind) -(1L<<(ind-1));
            }
        }
        
        return answer;
    }
}
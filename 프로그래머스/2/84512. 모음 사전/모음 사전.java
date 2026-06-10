class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] target = word.toCharArray();
        
        char[] vowel = new char[]{'A','E','I','O','U'};
        
        final int MAX = 5;
        
        int n = target.length;
        
        int d;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 5; j++){
                if(vowel[j] == target[i]){
                    answer+= j * ((Math.pow(5, 5 - i) - 1) / 4);
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
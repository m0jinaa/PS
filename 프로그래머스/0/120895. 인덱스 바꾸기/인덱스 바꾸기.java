class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] input = my_string.toCharArray();
        
        char c = input[num1];
        input[num1] = input[num2];
        input[num2] = c;
        
        String answer = String.valueOf(input);
        
        return answer;
    }
}
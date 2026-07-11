class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] small = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        char[] input = s.toCharArray();
        
        for(char c : input){
            if('a'<=c && c<='z'){
                sb.append(small[(c-'a'+n)%26]);
            }
            else if('A'<=c && c <='Z'){
                sb.append(big[(c-'A'+n)%26]);
            }
            else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
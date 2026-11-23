class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        
        char[] alp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        char[] input = (age+"").toCharArray();
        
        for(char c : input){
            sb.append(alp[c-'0']);
        }
        
        return sb.toString();
    }
}
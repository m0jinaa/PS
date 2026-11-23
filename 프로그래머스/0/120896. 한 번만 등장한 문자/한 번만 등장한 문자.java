class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int[] cnt = new int[26];
        char[] alp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        char[] input = s.toCharArray();
        
        for(char c : input){
            cnt[c-'a']++;
        }
        
        for(int i = 0;i<26;i++){
            if(cnt[i] != 1){
                continue;
            }
            sb.append(alp[i]);
        }
        
        return sb.toString();
    }
}
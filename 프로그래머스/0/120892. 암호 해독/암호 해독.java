class Solution {
    public String solution(String cipher, int code) {
        char[] str = cipher.toCharArray();
        
        int n = str.length;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = code;i<=n;i+=code){
            sb.append(str[i-1]);
        }
        
        return sb.toString();
    }
}
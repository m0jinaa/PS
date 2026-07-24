class Solution {
    public int solution(String t, String p) {
        
        String now = t.substring(0,p.length());
        
        char[] row = t.toCharArray();
        
        int n = t.length();
        
        int answer = now.compareTo(p) <= 0 ? 1 : 0;
        
        for(int i = p.length();i<n;i++){
            now = now.substring(1).concat(String.valueOf(row[i]));

            if(now.compareTo(p)<=0){
                answer++;
            }
        }
        
        return answer;
    }
}
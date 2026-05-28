class Solution {
    public String solution(String s) {
        char[] upper = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        char[] row = s.toLowerCase().toCharArray();
        
        boolean shouldBeUpper = true;
        
        int n = row.length;
        
        for(int i = 0;i<n;i++){
            if(row[i] == ' '){
                shouldBeUpper = true;
            }
            else if(row[i]<'a' || row[i]>'z'){
                shouldBeUpper = false;
            }
            else if(shouldBeUpper){
                row[i] = upper[row[i]-'a'];
                shouldBeUpper = false;
            }            
        }
        String answer = String.valueOf(row);
        return answer;
    }
}
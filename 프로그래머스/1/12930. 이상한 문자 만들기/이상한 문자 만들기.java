class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] input = s.toCharArray();
        
        int n = input.length;
        int ind = 0;
        
        for(int i = 0;i<n;i++){
            if(input[i] == ' '){
                sb.append(input[i]);
                ind = 0;
            }    
            else if(ind % 2 == 0){
                sb.append(Character.toUpperCase(input[i]));
                ind++;
            }
            else{
                sb.append(Character.toLowerCase(input[i]));
                ind++;
            }
        }  
        
        return sb.toString();
    }
}
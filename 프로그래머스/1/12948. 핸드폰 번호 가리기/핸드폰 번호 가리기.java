class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        char[] input = phone_number.toCharArray();
        
        int n = input.length;
        
        for(int i = 0;i<n;i++){
            if(i<n-4){
                sb.append("*");
            }
            else{
                sb.append(input[i]);
            }
        }
        
        return sb.toString();
    }
}
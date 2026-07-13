class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean possible = true;
        
        int a = 0;
        int b = 0;
        
        int n = cards1.length;
        int m = cards2.length;
        
        for(String s : goal){
            if(a<n && cards1[a].equals(s)){
                a++;
            }
            else if(b<m && cards2[b].equals(s)){
                b++;
            }
            else{
                possible = false;
                break;
            }
        }
        
        return possible?"Yes":"No";
    }
}
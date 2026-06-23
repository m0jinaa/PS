import java.util.*;

class Solution{
    char[] word;
    int[][] isPalindrome;
    
    int checkPalindrome(int s, int e){
        if(s>e){
            return 0;
        }
        else if(isPalindrome[s][e] != -1){
            return isPalindrome[s][e];
        }
        else if(s == e){
            return isPalindrome[s][e] = 1;
        }
        
        int ret = 0;
        
        int l = checkPalindrome(s,e-1);
        
        int r = checkPalindrome(s+1,e);
        
        ret = Math.max(l,r);
        
        if(word[s] == word[e]){
            int m = checkPalindrome(s+1,e-1);
            
            if(m == e-s-1){
                ret = Math.max(ret,m+2);
            }
        }
        
        return isPalindrome[s][e] = ret;
    }
    
    public int solution(String s){
        
        int n = s.length();
        word = s.toCharArray();
        isPalindrome = new int[n][n];
        
        for(int i = 0;i < n;i++){
            Arrays.fill(isPalindrome[i],-1);
        }
        
        int answer = checkPalindrome(0,n-1);
        
        return answer;
    }
}
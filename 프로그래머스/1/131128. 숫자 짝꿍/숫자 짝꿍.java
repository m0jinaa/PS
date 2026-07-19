class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] A = new int[10];
        int[] common = new int[10];
            
        char[] XX = X.toCharArray();
        
        for(char c : XX){
            A[c-'0']++;
        }
        
        char[] YY = Y.toCharArray();
        
        for(char c : YY){
            if(A[c-'0']>0){
                A[c-'0']--;
                common[c-'0']++;
            }
        }
        
        boolean nonZero = false;        
        boolean empty = true;
        
        for(int i = 9;i>=0;i--){
            if(common[i]==0){
                continue;
            }
            
            while(common[i]-->0){
                sb.append(i);
                empty = false;
            }
            if(i!=0){
                nonZero = true;
            }
        }
        
        if(empty){
            sb.append(-1);
        }
        else if(!nonZero){
            return "0";
        }
        
        return sb.toString();
    }
}
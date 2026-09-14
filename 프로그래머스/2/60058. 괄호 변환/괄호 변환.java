class Solution {
    char[] S;
    
    String check(int s, int e){
        if(s>e){
            return "";
        }
        
        boolean wrong = false;
        
        int open = 0;
        int close = 0;
        int c = 0;
        
        String ret = "";
        
        for(int i = s;i<=e;i++){
            if(S[i] == '('){
                open++;
                c++;
            }    
            else{
                close++;
                c--;
            }
            
            if(c<0){
                wrong = true;
            }
            
            if(open == close){
                if(wrong){
                    ret+="(";
                    ret+=check(i+1,e);
                    ret+=")";
                    for(int j = s+1;j<i;j++){
                        if(S[j] == '('){
                            ret+=")";
                        }
                        else{
                            ret+="(";
                        }
                    }
                }
                else{
                    for(int j = s;j<=i;j++){
                        ret+=S[j];
                    }
                    
                    ret+=check(i+1,e);
                }
                break;
            }
        } 
        
        return ret;
    }
    
    public String solution(String p) {
        
        S = p.toCharArray();
        
        String answer = check(0,S.length-1);

        return answer;
    }
}
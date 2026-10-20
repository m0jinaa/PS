class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        
        String answer = s;
        
        String sub,now;
        
        int c;
        
        String comp;
        
        for(int i = 1;i<=n/2;i++){
            sub = s.substring(0,i);
            c = 1;
            for(int j = i;j<n;){
                if(j+i>n){
                    if(c>1){
                        sb.append(c).append(sub);
                    }
                    else{
                        sb.append(sub);
                    }
                    
                    sb.append(s.substring(j));
                    c = 0;
                    break;
                }
                
                now = s.substring(j,j+i);
                
                if(now.equals(sub)){
                    c++;
                }
                else if(c>1){
                    sb.append(c).append(sub);
                    sub = now;
                    c = 1;
                }
                else{
                    sb.append(sub);
                    sub = now;
                    c = 1;
                }
                j+=i;
            }
            
            if(c!=0){
                if(c>1){
                    sb.append(c).append(sub);
                }
                else{
                    sb.append(sub);
                }
            }
            
            comp = sb.toString();
            
            if(answer.length()>comp.length()){
                answer = comp;
            }
            sb.setLength(0);
        }
        
        return answer.length();
    }
}
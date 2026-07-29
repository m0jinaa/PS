class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int prev = 0;
        int now = 0;
        
        char[] dart = dartResult.toCharArray();
        
        char bef = '-';
        
        for(char c : dart){
            switch(c){
                case 'S':
                    break;
                case 'D':
                    now = now*now;
                    break;
                case 'T':
                    now = now*now*now;
                    break;
                case '*':
                    prev *= 2;
                    now *= 2;
                    break;
                case '#':
                    now *=(-1);
                    break;
                default:
                    if(bef == '1'){
                        now = now*10+(c-'0');
                    }
                    else{
                        answer+=prev;
                        prev = now;
                        now = c-'0';                        
                    }
                    break;
            }
            
            bef = c;
        }
        
        answer += prev + now;
        
        return answer;
    }
}
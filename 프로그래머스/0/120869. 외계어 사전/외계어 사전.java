class Solution {
    int getBitSum(String s){
        int sum = 0;
        char[] str = s.toCharArray();
        
        for(char c : str){
            sum += (1<<(c-'a'));
        }
        
        return sum;
    }
    
    public int solution(String[] spell, String[] dic) {
        int spelling = 0;
        
        for(String s : spell){
            spelling+=getBitSum(s);
        }
        
        int x;
        
        int answer = 2;
        
        for(String s : dic){
            x = getBitSum(s);
            
            if(x == spelling){
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}
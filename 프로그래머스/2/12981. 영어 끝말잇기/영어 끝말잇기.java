import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int number = 0;
        int order = 0;
        
        int p = n;
        int o = 0;
        
        Set<String> set = new HashSet<>();
        
        char last = '-', first = '-';
        
        for(String s : words){
            if(p == n){
                o++;
                p = 1;
            }
            else{
                p++;
            }
            
            //동일 단어 반복
            if(set.contains(s)){
                number = p;
                order = o;
                break;
            }
            
            set.add(s);
            
            //앞 단어와 끝말잇기가 연결되는지 확인
            first = s.charAt(0);
            
            if((p != 1 || o != 1) && first!=last){
                number = p;
                order = o;
                break;
            }
            
            last = s.charAt(s.length()-1);
        }
        
        
        int[] answer = {number, order};

        return answer;
    }
}
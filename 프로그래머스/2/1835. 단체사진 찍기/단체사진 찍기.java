
import java.util.*;

class Solution {
    int[][] condition;
    int N;
    boolean[] taken;
    int[] position;
    boolean check(){
        int d;
        
        for(int[] cond : condition){
            //두 프렌즈 사이의 거리
            d = Math.abs(position[cond[0]]-position[cond[1]])-1;
            
            if(cond[2] == 0 && d != cond[3]){
                return false;
            }
            else if(cond[2] == -1 && d>=cond[3]){
                return false;
            }
            else if(cond[2] == 1 && d<=cond[3]){
                return false;
            }
        }
        
        return true;
    }
    
    public int getCount(int x){
        if(x == N){
            if(check()){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            int ret = 0;
            
            for(int i = 0;i<N;i++){
                if(taken[i]){
                    continue;
                }
                taken[i] = true;
                position[x] = i;
                ret += getCount(x+1);
                position[x] = -1;
                taken[i] = false;
            }
            
            return ret;
        }
    }
    
    public int solution(int n, String[] data) {
        Map<Character,Integer> indMap = new HashMap<>();
        
        indMap.put('A',0);
        indMap.put('C',1);
        indMap.put('F',2);
        indMap.put('J',3);
        indMap.put('M',4);
        indMap.put('N',5);
        indMap.put('R',6);
        indMap.put('T',7);
        indMap.put('=',0);
        indMap.put('<',-1);
        indMap.put('>',1);
        N = 8;
        
        taken = new boolean[8];
        position = new int[8];
        Arrays.fill(position,-1);
        condition = new int[n][4];
        
        char[] cond;
        
        for(int i = 0;i<n;i++){
            cond = data[i].toCharArray();
            
            condition[i][0] = indMap.get(cond[0]);
            condition[i][1] = indMap.get(cond[2]);
            condition[i][2] = indMap.get(cond[3]);
            condition[i][3] = cond[4]-'0';
        }
        
        int answer = getCount(0);
        
        return answer;
    }
}
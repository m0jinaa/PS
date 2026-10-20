import java.util.*;

class Solution {
    Set<Integer> set;
    int row, col;
    String[][] table;
    Set<String> identified;
    boolean[] used;
    
    boolean check(int k){
        identified.clear();
        String s;
        
        for(int i = 0; i < row; i++){
            s = "";
            
            for(int j = 0; j < col; j++){
                if(!used[j]){
                    continue;
                }
                s = s.concat(" ").concat(table[i][j]);
            }
            
            //중복되는 컬럼이 있으면 안됨
            if(!identified.add(s)){
                return false;
            }
        }
        
        return true;
    }
    
    int getCombiCount(int x, int k){
        if(x == col){
            
            if(k != 0 && check(k)){
                
                for(int ck : set){
                    if((k & ck) == k || (k & ck) == ck){
                        return 0;
                    }    
                }
                
                set.add(k);
                return 1;
            }
            return 0;
        }
        else{
            int ret = 0;
            
            ret += getCombiCount(x + 1, k);
            
            used[x] = true;
            ret += getCombiCount(x + 1, k + (1 << x));
            used[x] = false;
            
            return ret;
        }
    }
    
    public int solution(String[][] relation) {
        
        row = relation.length;
        col = relation[0].length;
        
        identified = new HashSet<>();
        set = new HashSet<>();
        used = new boolean[col];
        
        table = relation;
        
        return getCombiCount(0, 0);
    }
}
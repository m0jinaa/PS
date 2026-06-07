import java.util.*;

class Solution {
    int[] target;
    int[] canBuy;
    int match;
    int n,m;
    
    void add(int ind){
        if(target[ind]>0 && canBuy[ind] == target[ind]){
            match--;
        }

        canBuy[ind]++;

        if(target[ind] > 0 && canBuy[ind] == target[ind]){
            match++;
        }
    }
    
    void delete(int ind){
        if(target[ind]>0 && canBuy[ind] == target[ind]){
            match--;
        }

        canBuy[ind]--;

        if(target[ind] > 0 && canBuy[ind] == target[ind]){
            match++;
        }        
    }
    public int solution(String[] want, int[] number, String[] discount) {
        final int MAX = 100_000;
        
        Map<String,Integer> indMap = new HashMap<>();
        
        int ind = 0;
        
        target = new int[MAX];
        
        for(String item : want){
            indMap.put(item,ind);
            target[ind] = number[ind];
            ind++;
        }
        
        canBuy = new int[MAX];
        
        int s = 0;
        int e = -1;
        
        match = 0;
        
        n = number.length;
        m = discount.length;
        
        int index;
        
        int answer = 0;
        
        while(e < m){
            if(e - s + 1 == 10){
                if(match == n){
                    answer++;
                }
                
                //앞에꺼 제거
                index = indMap.get(discount[s++]);
                delete(index);
                
                //뒤에꺼 추가
                if(++e < m){
                    if(!indMap.containsKey(discount[e])){
                        indMap.put(discount[e],ind++);
                    }
                    index = indMap.get(discount[e]);
                    add(index);
                }
            }
            else{
                //뒤에꺼 추가
                if(++e < m){
                    if(!indMap.containsKey(discount[e])){
                        indMap.put(discount[e],ind++);
                    }
                    index = indMap.get(discount[e]);
                    add(index);
                }
            }
        }
        
        return answer;
    }
}
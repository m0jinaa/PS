import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        int n = sticker.length;
        
        int answer;
        
        if(n == 1){
            answer = sticker[0];
        }        
        else if(n == 2){
            answer = Math.max(sticker[0],sticker[1]);
        }
        else{
            int[] useFirst = new int[n];
            int[] noUseFirst = new int[n];
            
            //첫번째를 쓴다 => 마지막꺼 안쓴다.
            useFirst[0] = sticker[0];
            useFirst[1] = Math.max(sticker[0],sticker[1]);
            
            //첫번째꺼 안쓴다 => 두번째꺼부터 시작
            noUseFirst[1] = sticker[1];
            
            for(int i = 2;i<n;i++){
                useFirst[i] = Math.max(useFirst[i-1],useFirst[i-2]+sticker[i]);
                noUseFirst[i] = Math.max(noUseFirst[i-1],noUseFirst[i-2]+sticker[i]);
            }
            
            answer = Math.max(useFirst[n-2],noUseFirst[n-1]);
        }
        
        return answer;
    }
}
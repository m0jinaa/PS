import java.util.*;

class Solution {
    int n;
    boolean[] v;
    int[][] dungeon;
    int answer;
    
    //c:현재까지 살펴본 던전 수, now : 현재 피로도, cnt: 현재까지 탐헌한 던전 수
    void findMaxCnt(int c, int now, int cnt){
        //모든 던전 살펴 봄
        if(c == n){
            answer = Math.max(answer,cnt);
        }
        else{
            for(int i = 0;i<n;i++){
                //이미 살펴본 던전일 때
                if(v[i]){
                    continue;
                }
                
                //방문체크
                v[i] = true;
                
                //탐험할 수 있는 던전인지 확인
                if(dungeon[i][0] <= now){
                    findMaxCnt(c+1,now-dungeon[i][1],cnt+1);
                }
                else{ //탐험 불가
                    findMaxCnt(c+1,now,cnt);
                }
                
                // 방문체크 해제
                v[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        
        n = dungeons.length;
        dungeon = dungeons;
        
        v = new boolean[n];
        
        answer = 0;
        
        findMaxCnt(0,k,0);
        
        return answer;
    }
}
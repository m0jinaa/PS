import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        final int MAX = 100_000;
        
        int ind = 0;
        int answer = 0;
        
        if(cacheSize == 0){
            answer = cities.length*5;
        }
        else{
            Map<String, Integer> indMap = new HashMap<>();
            int[] lastUsed = new int[MAX];
            int[] cache = new int[cacheSize];
            int cacheInd;

            //비어있는 상태로 만들기
            Arrays.fill(cache,-1);

            int cityInd;

            String city;

            int n = cities.length;
            boolean match;
            int lru;
            int t;

            for(int i = 0;i<n;i++){
                city = cities[i].toLowerCase();

                if(!indMap.containsKey(city)){
                    indMap.put(city,ind++);
                }    

                cityInd = indMap.get(city);

                //캐시 둘러보면서 아직 캐시에 남아있는지 확인
                t = MAX;
                lru = -1;
                match = false;

                for(int j = 0;j<cacheSize;j++){
                    if(cache[j] == cityInd){
                        match = true;
                        lru = j;
                        break;
                    }
                    else if(cache[j] == -1){
                        lru = j;
                        t = -1;
                    }
                    else if(lastUsed[cache[j]]<t){
                        t = lastUsed[cache[j]];
                        lru = j;
                    }
                }

                lastUsed[cityInd] = i;
                cache[lru] = cityInd;

                if(match){
                    answer += 1;
                }
                else{
                    answer += 5;
                }

            }
            
        }
        return answer;
    }
}
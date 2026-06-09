import java.util.*;

class Solution {
    public int[] solution(String s) {
        final int MAX = 100_000;
        
        //앞 뒤 {{,}} 모양 제거
        s = s.substring(2,s.length()-2);
    
        // },{ 기준으로 튜플 나누기
        String[] input = s.split("\\},\\{");
        
        boolean[] contains = new boolean[MAX+1];
        
        //원소 개수로 정렬
        Arrays.sort(input,(a,b)->(a.split(",").length-b.split(",").length));
        
        //String array에서 int 2d array로 mapping
        int[][] tuple = Arrays.stream(input)
            .map(row -> Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        
        int n = tuple.length;
        
        int[] answer = new int[n];
        
        //튜플마다 살펴보면서 새로 생긴 원소인지 확인
        for(int i = 0;i<n;i++){
            for(int v : tuple[i]){
                if(contains[v]){
                    continue;
                }
                contains[v] = true;
                answer[i] = v;
                break;
            }
        }
        return answer;
    }
}
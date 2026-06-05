import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //col번째 컬럼 오름차순, 첫번째 컬럼 내림차순 순서로 정렬
        Arrays.sort(data,Comparator.comparingInt((int[]a)->a[col-1]).thenComparing(Comparator.comparingInt((int[]b)->b[0]).reversed()));
        
        int s;
        
        for(int i = row_begin-1;i<row_end;i++){
            int mod = i+1;
            
            //s_i 값 계산
            s = Arrays.stream(data[i]).map(v -> v % mod).sum();
            
            //xor 값 계산
            answer ^= s;
        }
        
        return answer;
    }
}
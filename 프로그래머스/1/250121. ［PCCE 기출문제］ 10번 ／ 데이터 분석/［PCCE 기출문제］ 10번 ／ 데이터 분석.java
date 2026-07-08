import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String,Integer> indexMap = new HashMap<>();
        
        indexMap.put("code",0);
        indexMap.put("date",1);
        indexMap.put("maximum",2);
        indexMap.put("remain",3);
        
        int[][] answer = Arrays.stream(data).filter((int[] d) -> d[indexMap.get(ext)]<val_ext).sorted(Comparator.comparing(d->d[indexMap.get(sort_by)])).toArray(int[][]::new);
        
        return answer;
    }
}
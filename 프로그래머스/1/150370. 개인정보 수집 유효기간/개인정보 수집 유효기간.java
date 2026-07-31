import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String[] row;
        
        Map<String, Integer> duration = new HashMap<>();
        
        int ty,tm,td;
        
        row = today.split("[.]");
    
        ty = Integer.parseInt(row[0]);
        tm = Integer.parseInt(row[1]);
        td = Integer.parseInt(row[2]);
        
        final int TODAY = ty * 28*12+tm*28+td;
        
        for(String term : terms){
            row = term.split("[\\s]");
            
            duration.put(row[0],Integer.parseInt(row[1])*28);
        }
        
        int y,m,d;
        String t;
        
        int date;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = privacies.length;
        
        for(int i = 0;i<n;i++){
            row = privacies[i].split("[.\\s]");
            
            y = Integer.parseInt(row[0]);
            m = Integer.parseInt(row[1]);
            d = Integer.parseInt(row[2]);
            t = row[3];
            
            date = y*12*28+m*28+d+duration.get(t);
            
            if(date<=TODAY){
                list.add(i+1);
            }            
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;

class Solution {
    int n;
    char[][] order;
    int[] courses;
    int[] max;
    Map<String, Integer>[] menuMap;
    
    void combi(int ind, int food, int target, String menu){
        if(courses[target] == menu.length()){
            menuMap[target].put(menu,menuMap[target].getOrDefault(menu,0)+1);
            max[target] = Math.max(max[target],menuMap[target].get(menu));
            return;
        }
        else if(order[ind].length == food){
            return;
        }
        else{
            combi(ind,food+1,target,menu);
            combi(ind,food+1,target,menu+order[ind][food]);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
            
        LinkedList<String> answer = new LinkedList<>();
        
        n = orders.length;
        courses = course;
        order = new char[n][];
        
        for(int i = 0;i<n;i++){
            order[i] = orders[i].toCharArray();
            Arrays.sort(order[i]);
        }
        
        int m = course.length;
        
        menuMap = new HashMap[m];
        
        for(int i = 0;i<m;i++){
            menuMap[i] = new HashMap<>();
        }
        
        max = new int[m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(order[i].length<course[j]){
                    break;
                }
                else{
                    combi(i,0,j,"");
                }
            }
        }
        
        for(int i = 0;i<m;i++){
            //최소 두 명 이상의 손님이 주문해야 함
            if(max[i]<2){
                continue;
            }
            
            for(Map.Entry<String,Integer> set : menuMap[i].entrySet()){
                if(set.getValue() == max[i]){
                    answer.add(set.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
}
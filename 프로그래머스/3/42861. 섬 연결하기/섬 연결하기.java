import java.util.*;

class Solution {
    int[] parent;
    
    class Road implements Comparable<Road>{
        int a,b,c;
        public Road(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public int compareTo(Road r){
            return this.c-r.c;
        }
    }
    
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    boolean union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x==y){
            return false;
        }
        else if(x<y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
        
        return true;
    }
    
    public int solution(int n, int[][] costs) {
    
        int answer = 0;
    
        parent = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        
        int m = costs.length;
        
        Road[] roads = new Road[m];
        
        for(int i = 0;i<m;i++){
            roads[i] = new Road(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(roads);
        
        for(Road r : roads){
            if(union(r.a, r.b)){
                answer+=r.c;
            }
        }
        
        return answer;
    }
}
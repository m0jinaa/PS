import java.util.*;

class Solution {
    class Route implements Comparable<Route>{
        int s,e;
        public Route(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Route r){
            if(this.e!=r.e){
                return this.e-r.e;
            }
            else{
                return this.s-r.s;
            }
        }
    }
    public int solution(int[][] routes) {
        
        int n = routes.length;
        
        Route[] route = new Route[n];
        
        for(int i = 0;i<n;i++){
            route[i] = new Route(routes[i][0],routes[i][1]);
        }
        
        Arrays.sort(route);

        int answer = 0;
        
        int s = route[0].s;
        int e = route[0].e;
        
        for(Route r : route){
            if(e<r.s){
                answer++;
                s = r.s;
                e = r.e;
            }
            else{
                s = Math.max(s,r.s);
                e = Math.min(e,r.e);
            }
        }
        
        answer++;
        
        return answer;
    }
}
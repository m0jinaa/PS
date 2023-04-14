import java.util.*;
import java.io.*;
class Solution {
    class Line implements Comparable<Line>{
        int s,e;
        public Line(int s, int e){
            super();
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Line line){
            if(this.s != line.s){
                return this.s-line.s;
            }
            else{
                return this.e-line.e;
            }
        }
    }
    
    public int solution(int[][] targets) {
        
        int n = targets.length;
        
        Line[] lines = new Line[n];
        
        for(int i = 0;i<n;i++){
            lines[i] = new Line(targets[i][0],targets[i][1]);
        }
        
        Arrays.sort(lines);
        
        int answer = 1;
        
        int s = 0;
        int e = 100_000_000;
        
        for(Line line: lines){
            if(e<=line.s){
                answer++;
                s = line.s;
                e = line.e;
            }
            else{
                s = Math.max(s,line.s);
                e = Math.min(e,line.e);
            }
        }
        
        return answer;
    }
}
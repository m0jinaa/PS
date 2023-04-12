import java.util.*;
import java.io.*;
class Solution {
    int[][] cost = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
    int answer = Integer.MAX_VALUE;
    int n;
    int[] tools,mineral;
    public void combi(int ind,int total){
        //다이아도구
        int c=0;
        for(int i = 0;i<3;i++){
            if(tools[i]==0)
                continue;
            c = 0;
            for(int j = 0;j<5 && ind+j<n;j++){
                c+= cost[i][mineral[ind+j]];
                // System.out.println(j+ " " +mineral[j]);                
                // System.out.println(cost[i][mineral[j]]);
            }            
            tools[i]--;
            // System.out.println(i+" "+ind+" "+(c+total));
            if(ind+5>=n || (tools[0]==0 && tools[1] == 0 && tools[2] == 0)){
                answer = Math.min(answer,c+total);
            }
            else{
                combi(ind+5,c+total);
            }
            tools[i]++;
            
            
        }
    }
    public int solution(int[] picks, String[] minerals) {
        tools = new int[3];
        for(int i = 0;i<3;i++){
            tools[i] = picks[i];
        }
        n = minerals.length;
        mineral = new int[n];

        // System.out.println(Arrays.toString(tools));
        for(int i = 0;i<n;i++){
            switch(minerals[i]){
                case "diamond":
                    mineral[i] = 0;
                    break;
                case "iron":
                    mineral[i] = 1;
                    break;
                case "stone":
                    mineral[i] = 2;
                    break;
            }
        }
        // System.out.println(Arrays.toString(mineral));        
        combi(0,0);
        
        return answer;
    }
}
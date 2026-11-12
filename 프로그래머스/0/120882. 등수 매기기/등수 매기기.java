import java.util.*;

class Solution {
    class Score implements Comparable<Score>{
        int ind, sum;
        
        public Score(int ind, int sum){
            this.ind = ind;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Score s){
            return s.sum-this.sum;
        }
    }
    public int[] solution(int[][] score) {
        int n = score.length;
        
        int[] answer = new int[n];
        
        Score[] scores = new Score[n];
        
        for(int i = 0;i<n;i++){
            scores[i] = new Score(i,score[i][0]+score[i][1]);
        }
        
        Arrays.sort(scores);
        
        int befRank = 0;
        int befScore = 201;
    
        for(int i = 0;i<n;i++){
            if(scores[i].sum == befScore){
                answer[scores[i].ind] = befRank;
            }
            else{
                answer[scores[i].ind] = i+1;
                befRank = i+1;
                befScore = scores[i].sum;
            }
        }
        
        return answer;
    }
}
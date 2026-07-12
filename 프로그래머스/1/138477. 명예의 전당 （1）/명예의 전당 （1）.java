import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        
        int[] answer = new int[n];
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0;i<n;i++){
            if(q.size() == k){
                if(q.peek() < score[i]){
                    q.poll();
                    q.add(score[i]);
                }
            }
            else{
                q.add(score[i]);
            }
            
            answer[i] = q.peek();
        }
        
        return answer;
    }
}
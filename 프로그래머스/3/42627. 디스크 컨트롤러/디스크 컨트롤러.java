import java.util.*;

class Solution {
    class Disk implements Comparable<Disk>{
        // 요청 순서, 요청 시간, 소요 시간
        int p, t, d;
        
        public Disk(int p, int t, int d){
            this.p = p;
            this.t = t;
            this.d = d;
        }
        
        // 소요 시간, 요청 시간, 요청 순서 순으로 정렬
        @Override
        public int compareTo(Disk disk) {
            if(this.d != disk.d) {
                return this.d - disk.d;
            }
            else if(this.t != disk.t) {
                return this.t - disk.t;
            }
            else {
                return this.p - disk.p;
            }
        }
        
        @Override
        public String toString() {
            return "["+this.p+", "+this.t+", "+this.d+"]";
        }
    }
    public int solution(int[][] jobs) {

        LinkedList<Disk> list = new LinkedList<>();
        
        int n = jobs.length;
        
        for(int i = 0; i < n; i++){
            list.add(new Disk(i, jobs[i][0], jobs[i][1]));    
        }
        
        // 요청 시간 순으로 정렬
        Collections.sort(list, new Comparator<Disk>() {
            @Override
            public int compare(Disk a, Disk b) {
                return a.t - b.t;
            }
        });
        
        PriorityQueue<Disk> q = new PriorityQueue<>();
        
        // 현재 시간
        int time = 0;
        
        Disk now;
        
        // 반환 시간의 합
        int total = 0;
        
        while(!list.isEmpty() || !q.isEmpty()){
            if(q.isEmpty() && !list.isEmpty() && time < list.peekFirst().t){
                time = list.peekFirst().t;
            }
            
            // 현재 시간보다 이전에 요청된 작업 대기열에 추가하기
            while(!list.isEmpty() && time >= list.peekFirst().t){
                q.add(list.pollFirst());
            }
            
            now = q.poll();
            
            time += now.d;
            
            // 반환 시간 합치기
            total += (time - now.t);
        }
        
        // 평균 시간 구하기
        int answer = total / n;
        
        return answer;
    }
}
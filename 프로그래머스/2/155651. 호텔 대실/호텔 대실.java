import java.util.*;

class Solution {
    static class Booking implements Comparable<Booking>{
        int s,e;
        public Booking(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Booking b){
            if(this.s !=b.s){
                return this.s-b.s;
            }
            else{
                return this.e-b.e;
            }
        }
    }
    
    public int solution(String[][] book_time) {

        int n = book_time.length;
        
        Booking[] bookings = new Booking[n];
        
        int h,m,s,e;
        String[] time;
        for(int i = 0;i<n;i++){
            time = book_time[i][0].split(":");
            
            //대실 시작시간
            h = Integer.parseInt(time[0]);
            m = Integer.parseInt(time[1]);
            
            s = h*60+m;
            
            //대실 종료시간
            time = book_time[i][1].split(":");

            h = Integer.parseInt(time[0]);
            m = Integer.parseInt(time[1]);
            
            //청소시간 포함
            e = h*60+m+10;
            
            bookings[i] = new Booking(s,e);
        }
        
        //대실 목록 정렬
        Arrays.sort(bookings);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(0);
        
        for(int i = 0;i<n;i++){
            if(q.peek()<=bookings[i].s){
                q.poll();
            }
            q.add(bookings[i].e);
        }
        
        int answer = q.size();
        
        return answer;
    }
}
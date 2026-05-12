import java.util.*;

class Solution {
    class Homework implements Comparable<Homework>{
        String name;
        int start,playtime;
        
        public Homework(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public void reducePlaytime(int p){
            this.playtime = this.playtime - p;
        }
        
        @Override
        public int compareTo(Homework h){//시작시간 순으로 정렬
            return this.start-h.start;
        }
        
        @Override
        public String toString(){
            return "["+this.name+", "+this.start+", "+this.playtime+"]";
        }
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        
        String[] answer = new String[n];
        int ind = 0;
        
        LinkedList<Homework> delay = new LinkedList<>();
        LinkedList<Homework> homeworks = new LinkedList<>();
        
        int h,m,t,p;
        String name;
        String[] time;
        for(int i = 0;i<n;i++){
            name = plans[i][0];
            
            time = plans[i][1].split(":");
            
            h = Integer.parseInt(time[0]);
            m = Integer.parseInt(time[1]);
            t = h*60+m;
            
            p = Integer.parseInt(plans[i][2]);
            
            homeworks.add(new Homework(name, t, p));
        }
        
        //시작 시간 순으로 정렬
        Collections.sort(homeworks);
        
        int now = homeworks.peekFirst().start;
        int freetime;
        
        Homework homework;
        
        while(!delay.isEmpty() || !homeworks.isEmpty()){

            //계획 순서는 다 끝냈고 멈춘것만 남았을 때            
            if(homeworks.isEmpty()){
                while(!delay.isEmpty()){
                    homework = delay.pollLast();
                    answer[ind++] = homework.name;
                }
            }// 계획 중간에 남는시간이 생겼을 때
            else if(!delay.isEmpty() && !homeworks.isEmpty() && homeworks.peekFirst().start > now){
                freetime = homeworks.peekFirst().start - now;
                
                now = homeworks.peekFirst().start;
                
                while(!delay.isEmpty() && freetime > 0){
                    homework = delay.pollLast();
                    
                    if(homework.playtime<=freetime){
                        freetime-=homework.playtime;
                        answer[ind++] = homework.name;
                    }
                    else{
                        homework.reducePlaytime(freetime);
                        
                        delay.add(homework);

                        freetime = 0;
                    }
                }
            }else{
                homework = homeworks.pollFirst();
                
                //뒷 일정과 겹칠 때
                if(!homeworks.isEmpty() && homeworks.peekFirst().start<homework.start+homework.playtime){
                    homework.reducePlaytime(homeworks.peekFirst().start-homework.start);
                    now = homeworks.peekFirst().start;
                    delay.add(homework);
                }
                else{
                    answer[ind++] = homework.name;
                    now = homework.start+homework.playtime;
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    class Player{
        Player prev,next;
        String name;
        
        public Player(String name){
            this.name = name;
            this.prev = null;
            this.next = null;
        }
        
        public void setPrev(Player p){
            this.prev = p;
        }
        
        public void setNext(Player p){
            this.next = p;
        }
    }
    public String[] solution(String[] players, String[] callings) {
        
        int n = players.length;
        
        Map<String, Integer> indMap = new HashMap<>();
        
        Player[] raceStatus = new Player[n];
        
        int first = 0;
        
        for(int i = 0;i<n;i++){
            raceStatus[i] = new Player(players[i]);
            
            indMap.put(players[i],i);
            
            if(i>0){
                raceStatus[i-1].setNext(raceStatus[i]);
                raceStatus[i].setPrev(raceStatus[i-1]);
            }
        }
        
        int ind;
        
        Player bef;
        
        for(String name : callings){
            ind = indMap.get(name);
            
            bef = raceStatus[ind].prev;
            
            raceStatus[ind].setPrev(bef.prev);
            
            if(bef.prev!=null){
                bef.prev.setNext(raceStatus[ind]);
            }

            bef.setNext(raceStatus[ind].next);
            bef.setPrev(raceStatus[ind]);

            if(raceStatus[ind].next != null){
                raceStatus[ind].next.setPrev(bef);
            }
            raceStatus[ind].setNext(bef);
            
            if(raceStatus[ind].prev == null){
                first = ind;
            }
        }
        
        String[] answer = new String[n];
        
        Player p = raceStatus[first];
        
        int i = 0;
        
        while(p!=null){
            answer[i] = p.name;
            p = p.next;
            i++;
        }
        
        return answer;
    }
}
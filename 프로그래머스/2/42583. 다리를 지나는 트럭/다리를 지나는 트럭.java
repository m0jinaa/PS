import java.util.*;

class Solution {
    class Truck{
        int out,w;
        
        public Truck(int out, int w){
            this.out = out;
            this.w = w;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int n = truck_weights.length;
        
        int ind = 0;
        int t = 0;
        
        LinkedList<Truck> bridge = new LinkedList<>();
        
        int total_weight = 0;
        
        Truck truck;
        
        while(ind<n){
            t++;
            if((!bridge.isEmpty() && bridge.peekFirst().out==t) || total_weight+truck_weights[ind]>weight || bridge.size()==bridge_length){
                truck = bridge.pollFirst();
                t = truck.out;
                total_weight-=truck.w;
            }
            
            if(total_weight+truck_weights[ind]<=weight){
                bridge.add(new Truck(t+bridge_length,truck_weights[ind]));
                total_weight += truck_weights[ind];
                ind++;
            }
        }

        while(!bridge.isEmpty()){
            truck = bridge.pollFirst();
            answer = truck.out;
        }
        return answer;
    }
}
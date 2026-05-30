import java.util.*;

class Solution {
    class Element{
        int x,ind;
        public Element(int x, int ind){
            this.x = x;
            this.ind = ind;
        }
    }
    
    public int[] solution(String[] operations) {
        
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b)->(a.x-b.x));
        PriorityQueue<Element> maxHeap = new PriorityQueue<>((a,b)->(b.x-a.x));
        Set<Integer> deleted = new HashSet<>();
        
        String[] op;
        int x;
        
        int n = operations.length;
        Element now;
        
        for(int i = 0;i<n;i++){
            op = operations[i].split(" ");
            
            if("I".equals(op[0])){
                x = Integer.parseInt(op[1]);
                
                minHeap.add(new Element(x,i));
                maxHeap.add(new Element(x,i));
            }
            else{
                x = Integer.parseInt(op[1]);
                
                if(x == 1){
                    while(!maxHeap.isEmpty()){
                        now = maxHeap.poll();
                        if(!deleted.contains(now.ind)){
                            deleted.add(now.ind);
                            break;
                        }
                    }
                }
                else{
                    while(!minHeap.isEmpty()){
                        now = minHeap.poll();
                        if(!deleted.contains(now.ind)){
                            deleted.add(now.ind);
                            break;
                        }
                    }
                }
            }
        }
        
        int min = 0;
        int max = 0;
        
        while(!minHeap.isEmpty()){
            now = minHeap.poll();
            if(!deleted.contains(now.ind)){
                min = now.x;
                break;
            }
        }
        
        while(!maxHeap.isEmpty()){
            now = maxHeap.poll();
            if(!deleted.contains(now.ind)){
                max = now.x;
                break;
            }
        }
        
        int[] answer = new int[]{max,min};
        return answer;
    }
}
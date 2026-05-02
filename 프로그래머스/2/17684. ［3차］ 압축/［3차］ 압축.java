import java.util.*;

class Solution {    
    public Map<String,Integer> indexMap;
    public void init(){
        //사전 초기화
        indexMap.put("A",1);
        indexMap.put("B",2);
        indexMap.put("C",3);
        indexMap.put("D",4);
        indexMap.put("E",5);
        indexMap.put("F",6);
        indexMap.put("G",7);
        indexMap.put("H",8);
        indexMap.put("I",9);
        indexMap.put("J",10);
        indexMap.put("K",11);
        indexMap.put("L",12);
        indexMap.put("M",13);
        indexMap.put("N",14);
        indexMap.put("O",15);
        indexMap.put("P",16);
        indexMap.put("Q",17);
        indexMap.put("R",18);
        indexMap.put("S",19);
        indexMap.put("T",20);
        indexMap.put("U",21);
        indexMap.put("V",22);
        indexMap.put("W",23);
        indexMap.put("X",24);
        indexMap.put("Y",25);
        indexMap.put("Z",26);
    }
    
    public int[] solution(String msg) {
        //압축 저장용
        LinkedList<Integer> compressed = new LinkedList<>();
        
        char[] message = msg.toCharArray();
        indexMap = new HashMap<>();
        
        init();
        
        String now = "";
        int befInd = 0;
        int index = 27;
        
        for(char m : message){
            now += m;
            
            //사전에 존재
            if(indexMap.containsKey(now)){
                befInd = indexMap.get(now);
            }
            else{
                //새로 사전에 등록
                indexMap.put(now,index++);
                
                compressed.add(befInd);
                now = ""+m;
                befInd = indexMap.get(now);
            }
        }
        
        compressed.add(befInd);
        
        int n = compressed.size();
        
        int[] answer = new int[n];
        
        for(int i =0;i<n;i++){
            answer[i] = compressed.poll();
        }
        return answer;
    }
}
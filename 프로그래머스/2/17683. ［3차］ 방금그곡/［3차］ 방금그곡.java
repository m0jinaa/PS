import java.util.*;

class Solution {
    public Map<String,String> melodyMap;
    char[] input;
    int n;
    LinkedList<String> list;
    
    // 라디오에서 실제로 재생된 멜로디
    public String radioConverter(String m, int l){
        int size = m.length();
        
        list.clear();
        
        int r = l/size;
        
        for(int i = 0;i<r;i++){
            list.add(m);
        }
        
        if(l % size > 0){
            list.add(m.substring(0, l % size));
        }
        
        return String.join("",list);
    }
    
    //음계 단순화
    public String musicConverter(String m){
        char[] input = m.toCharArray();
        
        int n = input.length;
        
        list.clear();
        
        for(int i = 0;i<n;i++){
            if(input[i] == '#'){
                list.pollLast();
                list.add(melodyMap.get(""+input[i-1]+input[i]));
            }
            else{
                list.add(melodyMap.get(""+input[i]));
            }
        }
        
        return String.join("",list);
    }
    
    //시간을 분단위로 변환
    public int timeConverter(String t){
        String[] time = t.split(":");
        
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        
        return h * 60 + m;
    }
    
    public void init(){
        melodyMap = new HashMap<>();
        
        melodyMap.put("C","a");
        melodyMap.put("C#","b");
        melodyMap.put("D","c");
        melodyMap.put("D#","d");
        melodyMap.put("E","e");
        melodyMap.put("F","g");
        melodyMap.put("F#","h");
        melodyMap.put("G","i");
        melodyMap.put("G#","j");
        melodyMap.put("A","k");
        melodyMap.put("A#","l");
        melodyMap.put("B","m");
        
        list = new LinkedList<>();
    }

    public String solution(String m, String[] musicinfos) {
        
        init();
        
        String answer = "(None)";
        int length = 0;
        
        String melody = musicConverter(m);
        
        String radio;
        
        int start,end, playTime;
        String[] info;
        String title;
        String music;
        
        
        for(String musicInfo : musicinfos){
            info = musicInfo.split(",");
            
            // 시작 시각
            start = timeConverter(info[0]);
            
            // 종료 시각
            end = timeConverter(info[1]);
            
            //재생 시간
            playTime = end-start;
            
            // 음악 제목
            title = info[2];
            
            // 악보
            music = musicConverter(info[3]);
            
            // 재생된 음악
            radio = radioConverter(music, playTime);
            
            // 재생된 음악에 멜로디가 포함된 경우 
            if(radio.indexOf(melody) != -1){
                
                //조건 일치하는 음악이 여러개인 경우 재생시간이 가장 긴 것
                if(playTime > length){
                    answer = title;
                    length = playTime;
                }
            }
        }
        
        return answer;
    }
}
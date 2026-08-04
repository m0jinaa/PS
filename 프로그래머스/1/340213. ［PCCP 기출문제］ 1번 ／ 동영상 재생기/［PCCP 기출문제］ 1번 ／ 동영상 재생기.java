class Solution {
    int getTime(String time){
        String[] row = time.split(":");
        int m = Integer.parseInt(row[0]);
        int s = Integer.parseInt(row[1]);
        
        return m*60+s;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int total = getTime(video_len);
        int now = getTime(pos);
        int start = getTime(op_start);
        int end = getTime(op_end);
        
        final String PREV = "prev";
        final String NEXT = "next";
        
        if(start<=now && now <=end){
            now = end;
        }
        
        for(String c : commands){
            if(PREV.equals(c)){
                now = Math.max(0,now-10);
            }   
            else if(NEXT.equals(c)){
                now = Math.min(now+10,total);
            }
            
            if(start<=now && now <=end){
                now = end;
            }
        }
        
        int min = now/60;
        int sec = now%60;
        
        String answer = String.format("%02d:%02d",min,sec);
        
        return answer;
    }
}
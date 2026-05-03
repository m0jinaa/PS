import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        final int MAX = 10_000;
        final int MAX_TIME = 23*60+59;
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
                
        int[] totalParkTime = new int[MAX];
        
        //입차시간 저장
        int[] in = new int[MAX];
        
        //초기화
        Arrays.fill(in,-1);
        
        String[] time;
        String act;
        int parkTime;
        
        int h,m,t,car,f;
        String[] input;
        
        final String IN = "IN";
        final String OUT = "OUT";
        
        for(String record : records){
            input = record.split(" ");
            
            //시간
            time = input[0].split(":");
            
            h = Integer.parseInt(time[0]);
            m = Integer.parseInt(time[1]);
            
            t = h*60+m;
            
            //차량번호
            car = Integer.parseInt(input[1]);
            
            //출차인지 입차인지
            act = input[2];
            
            if(IN.equals(act)){//입차
                in[car] = t;
            }
            else{
                parkTime = t-in[car];
                
                totalParkTime[car]+=parkTime;
                
                in[car] = -1;
            } 
        }
        
        int c = 0;
        
        ArrayList<Integer> fee = new ArrayList<>();
        
        //요금 계산
        for(int i = 0;i<MAX;i++){
            
            //주차장 이용 안함
            if(totalParkTime[i] == 0 && in[i] == -1){
                continue;
            }
            
            //아직 출차하지 않은 경우 주차 시간 계산
            if(in[i] != -1){
                parkTime = MAX_TIME-in[i];
                totalParkTime[i] += parkTime;
            }
            
            //이용 요금 = 기본요금 +단위요금 *Math.ceil(max(0,이용시간 - 기본시간)/단위시간)
            f = baseFee + unitFee * (int)Math.ceil(1.0 * Math.max(0, totalParkTime[i] - baseTime) / unitTime);
            
            fee.add(f);            
        }
        
        return fee.stream().mapToInt(Integer::intValue).toArray();
    }
}
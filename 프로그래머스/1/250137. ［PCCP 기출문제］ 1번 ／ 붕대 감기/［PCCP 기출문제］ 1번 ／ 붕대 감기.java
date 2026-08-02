class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int hp = health;
        int time = 0;
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        // 붕대감기 연속 성공 회수
        int c;
        
        int cure;
        
        for(int[] attack : attacks){
            cure = attack[0]-time-1;
            
            c = cure/t;
            hp = Math.min(hp+cure*x+c*y,health);
            
            hp-=attack[1];
            time = attack[0];
            
            if(hp <= 0){
                hp = -1;
                break;
            }
        }
        
        return hp;
    }
}
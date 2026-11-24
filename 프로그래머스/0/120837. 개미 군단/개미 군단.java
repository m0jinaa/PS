class Solution {
    public int solution(int hp) {
        
        int general = hp/5;
        int soldier = (hp-general*5)/3;
        int worker = (hp-general*5)%3;
        
        int answer = general+soldier+worker;
        
        while(general>0){
            general--;
            worker += 5+3*soldier;
            soldier = worker/3;
            worker = worker%3;
            
            answer = Math.min(answer,general+soldier+worker);
        }
        
        return answer;
    }
}
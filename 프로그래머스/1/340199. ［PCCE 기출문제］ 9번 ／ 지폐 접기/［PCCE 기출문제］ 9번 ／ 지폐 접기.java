class Solution {
    int fold(int h, int w, int r, int c){
        int t;
        
        if(h<w){
            t = h;
            h = w;
            w = t;
        }
        
        if(r<c){
            t = r;
            r = c;
            c = t;
        }
        
        int cnt = 0;
        
        while(r>h || c>w){
            r/=2;
            cnt++;
            if(r<c){
                t = r;
                r = c;
                c = t;
            }
        }
        
        return cnt;
    }
    public int solution(int[] wallet, int[] bill) {
        int answer = fold(wallet[0], wallet[1], bill[0], bill[1]);
        
        return answer;
    }
}
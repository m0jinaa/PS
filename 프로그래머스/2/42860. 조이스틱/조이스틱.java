class Solution {
    public int solution(String name) {
        char[] spell = name.toCharArray();
        
        int n = spell.length;
        
        int c = 0;
        int s = n-1;
        
        int left,right,up,down;
        
        int a,j;
        
        for(int i = 0;i<n;i++){
            up = spell[i]-'A';
            down = 'Z'-spell[i]+1;
            
            c += Math.min(up,down);
            
            if(i+1 == n || spell[i+1] !='A'){
                continue;
            }
            
            j = i+1;
            while(j<n && spell[j] == 'A'){
                j++;
            }
            
            //기존방식, 현재위치 -> 연속된 A가 끝나는 지점, 연속된 A가 끝나는지점 -> 현재위치
            s = Math.min(s,Math.min(2*i+n-j,i+2*(n-j)));
        }
        
        return c+s;
    }
}
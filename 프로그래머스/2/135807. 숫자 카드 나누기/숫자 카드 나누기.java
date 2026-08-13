class Solution {
    int gcd(int x, int y){
        int t;
        
        while(y>0){
            t = x%y;
            x = y;
            y = t;
        }
        
        return x;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int n = arrayA.length;
        int m = arrayB.length;
        
        int gcdA = arrayA[0];

        for(int i = 1;i<n;i++){
            gcdA = gcd(gcdA,arrayA[i]);
        }
        
        boolean divided = false;
        
        for(int i = 0;i<m;i++){
            if(arrayB[i]%gcdA == 0){
                divided = true;
                break;
            }
        }
        
        if(!divided){
            answer = Math.max(answer,gcdA);
        }
        
        int gcdB = arrayB[0];

        for(int i = 1;i<m;i++){
            gcdB = gcd(gcdB,arrayB[i]);
        }
        
        divided = false;
        
        for(int i = 0;i<n;i++){
            if(arrayA[i]%gcdB == 0){
                divided = true;
                break;
            }
        }
        
        if(!divided){
            answer = Math.max(answer,gcdB);
        }
        
        return answer;
    }
}
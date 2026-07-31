class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] x = new int[]{3,0,0,0,1,1,1,2,2,2,3,3};
        int[] y = new int[]{1,0,1,2,0,1,2,0,1,2,0,2};
        
        int ld,rd;
        int l = 10,r = 11;
        
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                sb.append("L");
                l = n;
            }
            else if(n == 3 || n == 6 || n == 9){
                sb.append("R");
                r = n;
            }
            else{
                ld = Math.abs(x[n]-x[l])+Math.abs(y[n]-y[l]);
                rd = Math.abs(x[n]-x[r])+Math.abs(y[n]-y[r]);
                
                if(ld<rd){
                    sb.append("L");
                    l = n;
                }
                else if(ld>rd){
                    sb.append("R");
                    r = n;
                }
                else if(hand.equals("left")){
                    sb.append("L");
                    l = n;
                }
                else{
                    sb.append("R");
                    r = n;
                }
            }
        }
        
        return sb.toString();
    }
}
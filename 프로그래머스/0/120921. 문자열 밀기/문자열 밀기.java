class Solution {
    public int solution(String A, String B) {
        B = B.concat(B);
        
        return B.indexOf(A);
    }
}
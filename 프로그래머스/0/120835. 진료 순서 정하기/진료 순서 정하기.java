import java.util.*;

class Solution {
    class Patient implements Comparable<Patient>{
        int ind,e;
        
        public Patient(int ind, int e){
            this.ind = ind;
            this.e = e;
        }
        
        @Override
        public int compareTo(Patient p){
            return p.e-this.e;
        }
    }
    public int[] solution(int[] emergency) {
        
        int n = emergency.length;
        
        Patient[] patients = new Patient[n];
        
        for(int i = 0;i<n;i++){
            patients[i] = new Patient(i,emergency[i]);
        }
        
        Arrays.sort(patients);
        
        int[] answer = new int[n];
        
        for(int i = 0;i<n;i++){
            answer[patients[i].ind] = i+1;
        }
        
        return answer;
    }
}
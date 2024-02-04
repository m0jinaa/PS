import java.util.*;
import java.io.*;

class Main{
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int cnt = 0;
        int bef = 0;
        long answer = 0;
        int x;
        for(int i = 0;i<n;i++){
            x = Integer.parseInt(st.nextToken());

            if(bef<x){
                cnt++;
            }
            else{
                cnt = 1;
            }
            answer+=cnt;
            bef = x;
        }

        System.out.println(answer);
   }
}
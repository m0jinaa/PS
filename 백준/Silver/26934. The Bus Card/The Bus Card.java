import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int target = (int)Math.ceil(k*1.0/100);
        
        int five = target/5;
        int two = (target-five*5)/2;
        int one = (target-five*5-two*2);


        int answer = five+two+one;
        int c;
        while(five>0){
            five--;
            c = two*2+one+5;
            two = c/2;
            one = c%2;

            answer = Math.min(answer,five+two+one);
        }

        System.out.print(answer);
    }
}
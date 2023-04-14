import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{

    public static void main(String[] args)throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int dasom = Integer.parseInt(br.readLine());

        for(int i = 1;i<n;i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(!pq.isEmpty() && pq.peek()>=dasom+answer) {
            answer++;
            pq.offer(pq.poll()-1);
        }

        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        while(t-->0 && pq.peek()>1 && pq.peek()>=h){
            cnt++;
            pq.add(pq.poll()/2);
        }

        if(pq.peek()>=h){
            System.out.println("NO\n"+pq.peek());
        }
        else{
            System.out.println("YES\n"+cnt);
        }
	}
}
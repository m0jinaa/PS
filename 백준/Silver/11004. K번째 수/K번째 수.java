import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < k; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int x;
		
		for(int i = k;i<n;i++) {
			x = Integer.parseInt(st.nextToken());
			if(pq.peek()<=x) {
				continue;
			}
			pq.poll();
			pq.add(x);
		}
		
		System.out.println(pq.peek());
	}
}
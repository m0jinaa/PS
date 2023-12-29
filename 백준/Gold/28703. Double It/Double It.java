import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> q = new PriorityQueue<>();

		long max = 0;
		long x;
		st = new StringTokenizer(br.readLine(), " ");

		while (n-- > 0) {
			x = Long.parseLong(st.nextToken());

			max = Math.max(max, x);
			q.add(x);
		}

		long answer = max - q.peek();
		long limit = max;

		while (true) {
			x = q.poll();

			answer = Math.min(answer, max - x);
			if (x > limit)
				break;
			if (x * 2 > max) {
				max = x * 2;
			}
			q.add(x * 2);

		}

		System.out.println(answer);
	}
}
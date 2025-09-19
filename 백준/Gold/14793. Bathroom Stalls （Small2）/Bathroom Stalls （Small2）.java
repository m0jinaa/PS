import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n, k;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int x, l = -1, r = -1;

		for (int t = 1; t <= tc; t++) {
			pq.clear();

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			pq.add(n);

			while (k-- > 0) {
				x = pq.poll();

				l = r = (x - 1) / 2;

				if (x % 2 == 0) {
					r++;
				}

				if (l != 0)
					pq.add(l);
				if (r != 0)
					pq.add(r);
			}

			sb.append("Case #").append(t).append(": ").append(r).append(" ").append(l).append("\n");
		}

		System.out.print(sb.toString());
	}
}
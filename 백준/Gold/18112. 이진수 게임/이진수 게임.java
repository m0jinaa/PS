import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int s = Integer.parseUnsignedInt(br.readLine(), 2);
		int e = Integer.parseUnsignedInt(br.readLine(), 2);

		final int INF = 1024;

		int[] v = new int[INF];

		Arrays.fill(v, INF);

		LinkedList<Integer> q = new LinkedList<>();

		int x;
		int answer = 0;
		int nx;

		q.add(s);
		v[s] = 0;
		int y;
		while (!q.isEmpty()) {
			x = q.poll();
			if (x == e) {
				answer = v[x];
				break;
			}

			if (x + 1 < 1024 && v[x + 1] == INF) {
				v[x + 1] = v[x] + 1;
				q.add(x + 1);
			}

			if (x - 1 > 0 && v[x - 1] == INF) {
				v[x - 1] = v[x] + 1;
				q.add(x - 1);
			}
			y = (int) Math.floor(Math.log10(x) / Math.log10(2));

			for (int i = 0; i < y; i++) {
				nx = x ^ (int) Math.pow(2, i);
				if (v[nx] == INF) {
					v[nx] = v[x] + 1;
					q.add(nx);
				}
			}
		}

		System.out.println(answer);
	}
}
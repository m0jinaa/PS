import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Gate {
		long f, c;

		public Gate(long f, long c) {
			super();
			this.f = f;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Gate[] gates = new Gate[n];

		long f, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			f = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());

			gates[i] = new Gate(f, c);
		}

		long INF = Long.MAX_VALUE;
		long answer;

		long cost, flux;
		int max = 1 << n;
		int p, ind;

		int m = Integer.parseInt(br.readLine());

		long v, t;

		for (int tc = 1; tc <= m; tc++) {
			st = new StringTokenizer(br.readLine());

			v = Long.parseLong(st.nextToken());
			t = Long.parseLong(st.nextToken());

			answer = INF;

			for (int i = 1; i < max; i++) {
				p = i;
				flux = 0;
				cost = 0;
				ind = 0;

				while (p > 0) {
					if ((p & 1) != 0) {
						cost += gates[ind].c;
						flux += gates[ind].f;
					}
					p >>= 1;
					ind++;
				}

				if (flux * t >= v && cost < answer) {
					answer = cost;
				}
			}
			sb.append("Case ").append(tc).append(": ").append(answer == INF ? "IMPOSSIBLE" : answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}
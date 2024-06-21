import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Ore {
		int s, k;

		public Ore(int s, int k) {
			super();
			this.s = s;
			this.k = k;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] type = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			type[i] = Integer.parseInt(br.readLine());
		}

		LinkedList<Ore>[] list = new LinkedList[15001];

		for (int i = 1; i <= 15000; i++) {
			list[i] = new LinkedList<>();
		}

		int s, e, t;

		int max = 0;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			max = Math.max(max, e);

			list[e].add(new Ore(s, (e - s) * type[t]));
		}

		int[] dp = new int[max + 1];

		for (int i = 1; i <= max; i++) {
			dp[i] = dp[i - 1];
			for (Ore o : list[i]) {
				dp[i] = Math.max(dp[i], dp[o.s] + o.k);
			}
		}

		System.out.println(dp[max]);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Hay implements Comparable<Hay> {
		int w, h;

		public Hay(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Hay hay) {
			if (this.w > hay.w)
				return -1;
			else if (this.w < hay.w)
				return 1;
			else if (this.h > hay.h)
				return -1;
			else if (this.h < hay.h)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Hay[] hays = new Hay[n + 1];

		final int INF = Integer.MAX_VALUE;

		hays[0] = new Hay(INF, INF);

		int h, w;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			hays[i] = new Hay(h, w);
		}

		Arrays.sort(hays);

		int[] dp = new int[n + 1];

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (hays[j].h > hays[i].h && hays[j].w > hays[i].w) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				answer = Math.max(answer, dp[i]);
			}
		}

		System.out.println(answer);
	}
}
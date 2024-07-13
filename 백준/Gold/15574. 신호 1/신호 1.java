import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Dot implements Comparable<Dot> {
		int x, y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot d) {
			if (this.x != d.x)
				return this.x - d.x;
			else
				return this.y - d.y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Dot[] dots = new Dot[n];

		int x, y;

		double[] dp = new double[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			dots[i] = new Dot(x, y);
		}

		Arrays.sort(dots);

		double answer = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (dots[i].x == dots[j].x)
					continue;
				dp[i] = Math.max(dp[i],
						dp[j] + Math.sqrt(Math.pow(dots[i].x - dots[j].x, 2) + Math.pow(dots[i].y - dots[j].y, 2)));
			}

			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long s;
	static Mole[] moles;

	static class Mole implements Comparable<Mole> {
		int x, y, t;

		public Mole(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public int compareTo(Mole m) {
			return this.t - m.t;
		}
	}

	static boolean canGo(int a, int b) {
		double d = Math.sqrt(Math.pow(moles[a].x - moles[b].x, 2) + Math.pow(moles[a].y - moles[b].y, 2));

		int t = moles[b].t - moles[a].t;

		return d <= 1L * s * t;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		moles = new Mole[n + 1];

		moles[0] = new Mole(0, 0, 0);

		int x, y, t;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			moles[i] = new Mole(x, y, t);
		}

		Arrays.sort(moles);

		int[] dp = new int[n + 1];

		Arrays.fill(dp, -1);
		dp[0] = 0;

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == -1 || !canGo(j, i))
					continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
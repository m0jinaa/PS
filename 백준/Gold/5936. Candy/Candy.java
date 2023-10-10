import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long[] dp;
	static boolean[] v;
	static boolean[] add;
	static int[] canEat;

	static long getCnt(int x) {
		if (dp[x] != -2)
			return dp[x];
		else if (v[x])
			return -1;
		v[x] = true;
		long cnt = 0;

		int nx;
		long temp;
		for (int y : canEat) {
			if (y > x)
				continue;

			nx = x - y;
			while (nx <= n && add[nx])
				nx += m;
			temp = getCnt(nx);

			if (temp == -1) {
				cnt = -1;
				break;
			} else {
				cnt = Math.max(cnt, y + temp);
			}
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int nopt = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		canEat = new int[nopt];

		for (int i = 0; i < nopt; i++) {
			canEat[i] = Integer.parseInt(br.readLine());
		}

		add = new boolean[n + 1];

		for (int i = 0; i < f; i++) {
			add[Integer.parseInt(br.readLine())] = true;
		}

		dp = new long[50001];
		v = new boolean[50001];

		Arrays.fill(dp, -2);

		System.out.println(getCnt(n));
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp;
	static ArrayList<Integer>[] canGo;

	static int getCnt(int x) {
		if (dp[x] != -1)
			return dp[x];
		if (x == n)
			return dp[x] = 1;

		int cnt = 0;

		for (int y : canGo[x]) {
			cnt += getCnt(y);
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int a, b;
		canGo = new ArrayList[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			dp[i] = -1;
		}

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0)
				break;
			canGo[a].add(b);
		}

		System.out.println(getCnt(1));
	}
}
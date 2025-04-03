import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] v;
	static ArrayList<Integer>[] canGo;
	static int[][] dp;

	static int getMost(int x, int d) {
		if (dp[x][d] != -1)
			return dp[x][d];
		// 이전노드를 베티가 방문했다면 현재노드는 방문 안한때만 고려하고
		// 이전노드를 베티가 방문하지 않았다면 현재 노드는 방문하거나 안하는 두 케이스 모두 고려해서 비교.

		int cnt0 = 0;

		int cnt1 = d == 0 ? 1 : 0;

		for (int y : canGo[x]) {
			if (v[y])
				continue;

			v[y] = true;

			cnt0 += getMost(y, 0);

			// 이전노드 베티가 방문 안했을 때
			if (d == 0)
				cnt1 += getMost(y, 1);

			v[y] = false;
		}

		return dp[x][d] = Math.max(cnt0, cnt1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		canGo = new ArrayList[n + 1];
		dp = new int[n + 1][2];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			Arrays.fill(dp[i], -1);
		}

		int x, y;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		v[1] = true;
		int answer = getMost(1, 0);

		System.out.println(answer);
	}
}
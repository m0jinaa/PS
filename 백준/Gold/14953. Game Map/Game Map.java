import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] neighbor;
	static ArrayList<Integer>[] connected;
	static int[] dp;

	static int getMax(int x) {
		if (dp[x] != 0)
			return dp[x];
		int cnt = 1;

		for (int y : connected[x]) {
			if (neighbor[y] <= neighbor[x])
				continue;
			cnt = Math.max(cnt, 1 + getMax(y));
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		neighbor = new int[n];
		connected = new ArrayList[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			connected[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connected[a].add(b);
			connected[b].add(a);
			neighbor[a]++;
			neighbor[b]++;
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(getMax(i), answer);
		}

		System.out.println(answer);
	}
}
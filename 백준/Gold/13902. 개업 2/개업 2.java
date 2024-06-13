import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> set;
	static int n;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static int getMin() {
		dp[0] = 0;

		for (int w : set) {
			if (w > n)
				continue;
			dp[w] = 1;
		}

		for (int x = 1; x <= n; x++) {
			if (dp[x] == 1)
				continue;
			for (int y : set) {
				if (x < y || dp[x - y] == INF)
					continue;
				dp[x] = Math.min(dp[x], dp[x - y] + 1);
			}
		}

		return dp[n] == INF ? -1 : dp[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		set = new ArrayList<>();

		dp = new int[n + 1];

		int[] wok = new int[k];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < k; i++) {
			wok[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			set.add(wok[i]);
			for (int j = i + 1; j < k; j++) {
				if (wok[i] + wok[j] > n)
					continue;
				set.add(wok[i] + wok[j]);
			}
		}

		Collections.sort(set, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		Arrays.fill(dp, INF);

		int answer = getMin();

		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static long[] worth;
	static long[] dp;
	static boolean[] v;
	static final long INF = -1_000_000_000_001L;
	static long getMax(int x) {
		if (dp[x] != INF)
			return dp[x];
		v[x] = true;
		long max = 0;
		long temp;
		for (int y : canGo[x]) {
			if(v[y])
				continue;
			temp = getMax(y);
			if(temp<0)
				continue;
			max+=temp;
		}
		
		max+=worth[x];
		return dp[x] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		canGo = new ArrayList[n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int a, b;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			canGo[a].add(b);
			canGo[b].add(a);
		}

		st = new StringTokenizer(br.readLine(), " ");

		worth = new long[n];

		for (int i = 0; i < n; i++) {
			worth[i] = Long.parseLong(st.nextToken());
		}

		dp = new long[n];
		
		Arrays.fill(dp, INF);
		
		System.out.println(getMax(0));
	}
}
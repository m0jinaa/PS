import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] v;
	static long[][] dp;
	static ArrayList<Integer>[] connectedTo;
	static long[][] colorCost;

	static long getMin(int x, int c) {
		if (dp[x][c] != 0) {
			return dp[x][c];
		}

		long cost = colorCost[x][c];

		v[x] = true;

		if (c == 0) {
			for (int y : connectedTo[x]) {
				if (v[y])
					continue;
				cost += Math.min(getMin(y, 0), getMin(y, 1));
			}
		} else {
			for (int y : connectedTo[x]) {
				if (v[y])
					continue;
				cost += getMin(y, 0);
			}
		}

		v[x] = false;

		return dp[x][c] = cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		connectedTo = new ArrayList[n];
		v = new boolean[n];
		dp = new long[n][2];
		colorCost = new long[n][2];

		int x, y;

		for (int i = 0; i < n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			connectedTo[x].add(y);
			connectedTo[y].add(x);
		}

		long w, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			colorCost[i][0] = w;
			colorCost[i][1] = b;
		}

		long answer = Math.min(getMin(0, 0), getMin(0, 1));

		System.out.println(answer);
	}
}
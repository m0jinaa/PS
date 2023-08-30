import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long[] order;
	static long[] depth;
	static int ind = 1;
	static ArrayList<Integer>[] canGo;

	static void dfs(int x) {
		order[x] = ind++;

		for (int y : canGo[x]) {
			if (order[y] != -1)
				continue;
			depth[y] = depth[x] + 1;
			dfs(y);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		order = new long[n + 1];
		depth = new long[n + 1];

		Arrays.fill(order, -1);

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(canGo[i], Collections.reverseOrder());
		}

		dfs(r);

		long answer = 0;

		for (int i = 1; i <= n; i++) {
			answer += depth[i] * order[i];
		}

		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static long[] depth;
	static int order = 1;

	static long dfs(int x) {
		long answer = 0;

		for (int y : canGo[x]) {
			if (depth[y] != -1)
				continue;

			depth[y] = depth[x] + 1;

			answer += depth[y] * (++order) + dfs(y);
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		depth = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(canGo[i]);
		}

		Arrays.fill(depth, -1);

		depth[r] = 0;

		System.out.println(dfs(r));
	}
}
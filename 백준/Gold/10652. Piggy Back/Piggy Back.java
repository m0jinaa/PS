import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] energy;
	static ArrayList<Integer>[] canGo;
	static long[][] cost;
	static final long INF = 1_000_000_000_000_001L;
	static LinkedList<Integer> q;

	static void bfs(int ind, int x) {
		cost[x][ind] = 0;
		q.clear();
		q.add(x);

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : canGo[now]) {
				if (cost[y][ind] != INF)
					continue;
				cost[y][ind] = cost[now][ind] + energy[ind];
				q.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int b = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		energy = new int[] { b, e, p };
		canGo = new ArrayList[n + 1];
		cost = new long[n + 1][3];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			Arrays.fill(cost[i], INF);
		}

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		bfs(0, 1);
		bfs(1, 2);
		bfs(2, n);

		long answer = INF;

		long temp;

		for (int i = 1; i <= n; i++) {
			temp = cost[i][0] + cost[i][1] + cost[i][2];
			answer = Math.min(answer, temp);
		}

		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;
	static LinkedList<Integer> q;
	static int[] dist;

	static int find(int prev, int now) {
		v[now] = true;
		int ret;
		for (int nx : canGo[now]) {
			if (v[nx]) {
				if (nx != prev) {
					q.add(now);
					dist[now] = 0;
					return nx;
				}
			} else {
				ret = find(now, nx);
				if (ret != -1) {
					dist[now] = 0;
					q.add(now);
					return now == ret ? -1 : ret;
				}
			}
		}

		return -1;
	}

	static void bfs() {

		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int nx : canGo[now]) {
				if (dist[nx] != -1)
					continue;
				dist[nx] = dist[now] + 1;
				q.add(nx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int x, y;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		q = new LinkedList<>();

		Arrays.fill(dist, -1);
		find(-1, 1);

		bfs();

		for (int i = 1; i <= n; i++) {
			sb.append(dist[i]).append(i == n ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}
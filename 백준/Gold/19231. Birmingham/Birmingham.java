import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dist, answer;
	static boolean[] v;

	static ArrayList<Integer>[] connectTo;
	static LinkedList<Integer> queue;

	static void bfs() {

		int now;
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int y : connectTo[now]) {
				if (v[y])
					continue;
				v[y] = true;
				dist[y] = dist[now] + 1;
				queue.add(y);
			}
		}
	}

	public static void init() {
		int d = 1;
		int day = 1;

		while (d < n) {
			for (int j = d; j < d + day * k; j++) {
				if (j < n)
					answer[j] = day;
			}
			d += day * k;
			day++;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		connectTo = new ArrayList[n + 1];
		dist = new int[n + 1];
		answer = new int[n + 1];
		v = new boolean[n + 1];

		init();

		for (int i = 1; i <= n; i++) {
			connectTo[i] = new ArrayList<>();
		}

		queue = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");
		int x;

		while (q-- > 0) {
			x = Integer.parseInt(st.nextToken());
			queue.add(x);
			v[x] = true;
		}

		int y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			connectTo[x].add(y);
			connectTo[y].add(x);
		}
		bfs();

		for (int i = 1; i <= n; i++) {
			sb.append(answer[dist[i]]).append(i == n ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}
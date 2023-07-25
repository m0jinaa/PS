import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] time;
	static int[] cnt;
	static LinkedList<Integer> q;
	static ArrayList<Integer>[] near;

	static void bfs() {
		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : near[now]) {
				if (time[y] != -1)
					continue;
				cnt[y]++;
				if (cnt[y] >= (near[y].size() + 1) / 2) {
					time[y] = time[now] + 1;
					q.add(y);
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		time = new int[n + 1];
		Arrays.fill(time, -1);

		near = new ArrayList[n + 1];
		cnt = new int[n + 1];

		q = new LinkedList<>();

		int x;
		for (int i = 1; i <= n; i++) {
			near[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");

			while ((x = Integer.parseInt(st.nextToken())) != 0) {
				near[i].add(x);
			}
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());
			q.add(x);
			time[x] = 0;
		}

		bfs();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append(time[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
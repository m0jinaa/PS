import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] canGo;
	static boolean[] v;
	static int[] loc;

	static void bfs(int x) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(x);
		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int y = canGo[now][0]; y <= canGo[now][1]; y++) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(y);
			}
		}
	}

	static int left(int x) {
		int s = 0;
		int e = n - 1;

		int answer = n - 1;
		int m;
		while (s <= e) {
			m = (s + e) / 2;
			if (loc[m] >= x) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return answer;

	}

	static int right(int x) {
		int s = 0;
		int e = n - 1;

		int answer = 0;
		int m;
		while (s <= e) {
			m = (s + e) / 2;
			if (loc[m] <= x) {
				answer = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		canGo = new int[n][2];
		v = new boolean[n];

		loc = new int[n];
		int[] dist = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			canGo[i][0] = left(loc[i] - dist[i]);
			canGo[i][1] = right(loc[i] + dist[i]);
		}

		bfs(s - 1);

		for (int i = 0; i < n; i++) {
			if (!v[i])
				continue;
			sb.append(i + 1).append(" ");
		}

		System.out.println(sb.toString());
	}
}
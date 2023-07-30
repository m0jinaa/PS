import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;
	static ArrayList<Integer>[] canGo;

	static int bfs() {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);

		v[1] = true;
		int x;
		int cnt = 1;
		while (!q.isEmpty()) {
			x = q.poll();

			for (int y : canGo[x]) {
				if (v[y])
					continue;
				v[y] = true;
				cnt++;
				q.add(y);
			}
		}

		return cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];

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

		int cnt = bfs();

		if (cnt == n) {
			sb.append(0).append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				if (v[i])
					continue;
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
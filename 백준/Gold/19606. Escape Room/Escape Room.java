import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		final int MAX = n * m;

		boolean[] v = new boolean[MAX + 1];

		int x;

		LinkedList<Integer>[] canGo = new LinkedList[MAX + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= m; j++) {
				x = Integer.parseInt(st.nextToken());

				if (x > MAX)
					continue;

				if (canGo[i * j] == null) {
					canGo[i * j] = new LinkedList<>();
				}

				canGo[i * j].add(x);
			}
		}

		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);
		v[1] = true;

		int now;

		boolean possible = false;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == MAX) {
				possible = true;
				break;
			} else if (canGo[now] == null)
				continue;

			for (int nx : canGo[now]) {
				if (v[nx])
					continue;

				q.add(nx);
				v[nx] = true;
			}
		}

		System.out.println(possible ? "yes" : "no");
	}
}
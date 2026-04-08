import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<>();

		int[] level = new int[n];
		LinkedList<Integer>[] similiarTo = new LinkedList[n + 1];

		for (int i = 0; i < n; i++) {
			similiarTo[i] = new LinkedList<>();
			level[i] = INF;
		}

		// 호러 영화 체크
		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (h-- > 0) {
			x = Integer.parseInt(st.nextToken());

			level[x] = 0;
			q.add(x);
		}

		int a, b;

		while (l-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			similiarTo[a].add(b);
			similiarTo[b].add(a);
		}

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int next : similiarTo[now]) {
				if (level[next] != INF)
					continue;

				level[next] = level[now] + 1;
				q.add(next);
			}
		}

		int max = -1;
		int answer = -1;

		for (int i = 0; i < n; i++) {
			if (max < level[i]) {
				max = level[i];
				answer = i;
			}
		}

		System.out.println(answer);
	}
}
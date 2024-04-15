import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] shouldDo;
	static boolean[] v;

	static int bfs(int x) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(x);
		v[x] = true;

		int now;

		int answer = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int nx : shouldDo[now]) {
				if (v[nx])
					continue;
				v[nx] = true;
				answer++;
				q.add(nx);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		shouldDo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			shouldDo[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			shouldDo[b].add(a);
		}

		int start = Integer.parseInt(br.readLine());

		System.out.println(bfs(start));
	}
}
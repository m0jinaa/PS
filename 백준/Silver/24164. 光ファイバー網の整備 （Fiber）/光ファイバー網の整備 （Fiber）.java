import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;
	static ArrayList<Integer>[] connectedWith;
	static LinkedList<Integer> q;

	static void bfs(int x) {
		q.clear();

		q.add(x);
		v[x] = true;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : connectedWith[now]) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		connectedWith = new ArrayList[n + 1];
		v = new boolean[n + 1];
		q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			connectedWith[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connectedWith[a].add(b);
			connectedWith[b].add(a);
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (v[i])
				continue;
			bfs(i);
			answer++;
		}

		System.out.println(answer - 1);

	}
}
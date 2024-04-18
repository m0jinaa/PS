import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] friendWith;
	static int[] money;
	static boolean[] v;
	static LinkedList<Integer> q;

	static boolean bfs(int x) {
		q.clear();

		q.add(x);
		v[x] = true;
		int sum = money[x];

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int next : friendWith[now]) {
				if (v[next])
					continue;
				v[next] = true;
				sum += money[next];
				q.add(next);
			}
		}

		return sum == 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		friendWith = new ArrayList[n];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			friendWith[i] = new ArrayList<>();
		}

		money = new int[n];
		v = new boolean[n];

		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			friendWith[a].add(b);
			friendWith[b].add(a);
		}

		boolean answer = true;

		for (int i = 0; i < n; i++) {
			if (!v[i] && !bfs(i)) {
				answer = false;
				break;
			}
		}

		System.out.println(answer ? "POSSIBLE" : "IMPOSSIBLE");
	}
}
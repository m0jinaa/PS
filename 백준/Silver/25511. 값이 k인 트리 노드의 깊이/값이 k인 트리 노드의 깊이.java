import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int[] v;

	static int bfs(int x) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);
		v[0] = 0;

		int d = -1;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == x) {
				d = v[now];
				break;
			}

			for (int y : canGo[now]) {
				if (v[y] != -1)
					continue;
				v[y] = v[now] + 1;
				q.add(y);
			}
		}

		return d;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		v = new int[n];
		canGo = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
			v[i] = -1;
		}

		int p, c;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			canGo[p].add(c);
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		int target = -1;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (x != k)
				continue;
			target = i;
			break;
		}

		System.out.println(bfs(target));
	}
}
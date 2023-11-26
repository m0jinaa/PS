import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] connectedWith;
	static int[] v;
	static LinkedList<Integer> q;

	static int bfs(int x) {
		q.clear();
		q.add(x);
		v[x] = 0;

		int now;

		int dist = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : connectedWith[now]) {
				if (v[y] != -1)
					continue;
				v[y] = v[now] + 1;
				dist += v[y];
				q.add(y);
			}
		}

		return dist;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		connectedWith = new ArrayList[n + 1];
		v = new int[n + 1];
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

		int min = Integer.MAX_VALUE;
		int answer = -1;
		int dist;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(v, -1);

			dist = bfs(i);

			if (min > dist) {
				min = dist;
				answer = i;
			}
		}

		System.out.println(answer);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static int[] v;

	static int bfs() {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);

		v[1] = 0;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int y : canGo[x]) {
				if (v[y] != -1)
					continue;
				v[y] = v[x] + 1;
				q.add(y);
			}
		}

		return v[n] - 1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			v[i] = -1;
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		System.out.println(bfs());
	}
}
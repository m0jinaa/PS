import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] v;
	static ArrayList<Integer>[] canGo;
	static ArrayList<Integer>[] reverse;

	static LinkedList<Integer> q;

	static void bfs() {
		q.clear();
		q.add(1);
		v[1] = 1;

		int x;
		while (!q.isEmpty()) {
			x = q.poll();

			if (x == n)
				break;

			for (int y : canGo[x]) {
				if (v[y] != 0)
					continue;
				v[y] = v[x] + 1;
				q.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int m, a, b, x;
		ArrayList<Integer> city = new ArrayList<>();
		LinkedList<Integer> track = new LinkedList<>();
		boolean[] check;

		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			canGo = new ArrayList[n + 1];
			reverse = new ArrayList[n + 1];
			v = new int[n + 1];
			check = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				canGo[i] = new ArrayList<>();
				reverse[i] = new ArrayList<>();
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				canGo[a].add(b);
				reverse[b].add(a);
			}

			bfs();

			city.clear();
			track.clear();

			track.add(n);
			city.add(n);
			check[n] = true;
			while (!track.isEmpty()) {
				x = track.poll();

				if (x == 1)
					continue;

				for (int y : reverse[x]) {
					if (v[y] != v[x] - 1 || check[y])
						continue;
					track.add(y);
					city.add(y);
					check[y] = true;
				}
			}

			Collections.sort(city);

			for (int c : city) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}